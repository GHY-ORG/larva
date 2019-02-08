package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.IPostMapper;
import cn.ghy.larva.domain.Category;
import cn.ghy.larva.domain.Meta;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.Tag;
import cn.ghy.larva.service.IPostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ziyang
 */
@Service
public class IPostServiceImpl implements IPostService {
  private final IPostMapper iPostMapper;

  @Autowired
  public IPostServiceImpl(IPostMapper iPostMapper) {
    this.iPostMapper = iPostMapper;
  }

  @Override
  public Long insertPost(Post post) throws Exception {
    Long categoryId = post.getCategory().getCategoryId();
    if (isCategoryExit(categoryId)) {
      throw new Exception("Category: " + post.getCategory().getCategoryName() + " doesn't exit.");
    }
    iPostMapper.insertPost(post);
    Long postId = post.getPostId();

    iPostMapper.insertPostCategory(postId, categoryId);

    this.insertMetas(post.getMetas(), postId);
    this.insertTags(post.getTags(), postId);
    return postId;
  }

  @Override
  public void deletePostByPostId(Long postId) throws Exception {
    if (iPostMapper.selectPostByPostId(postId) != null) {
      iPostMapper.deletePostByPostId(postId);
    } else {
      throw new Exception("Post:" + postId + "doesn't exit.");
    }
  }

  @Override
  public void updatePostByPostId(Post post) throws Exception {
    Long postId = post.getPostId();
    if (iPostMapper.selectPostByPostId(postId) != null) {
      Long categoryId = post.getCategory().getCategoryId();
      if (isCategoryExit(categoryId)) {
        throw new Exception("Category: " + categoryId + " doesn't exit.");
      }
      iPostMapper.updatePostCategoryByPostId(postId, categoryId);
      iPostMapper.updatePostByPostId(post);
      iPostMapper.deletePostMetaByPostId(postId);
      this.insertMetas(post.getMetas(), postId);
      iPostMapper.deletePostTagByPostId(postId);
      this.insertTags(post.getTags(), postId);
    } else {
      throw new Exception("Post:" + postId + "doesn't exit.");
    }
  }

  @Override
  public Post selectPostByPostId(Long postId) {
    return iPostMapper.selectPostByPostId(postId);
  }

  @Override
  public List<Post> selectAllPost(Long userId, String postTitle, String postContent,
      Integer postType, Integer postStatus, Long categoryId, Long tagId) {
    return iPostMapper.selectAllPost(userId, postTitle, postContent, postType, postStatus,
        categoryId, tagId);
  }

  @Override
  public Long insertCategory(Category category) {
    iPostMapper.insertCategory(category);
    return category.getCategoryId();
  }

  @Override
  public void deleteCategoryByCategoryId(Long categoryId) {
    iPostMapper.deleteCategoryByCategoryId(categoryId);
  }

  @Override
  public void updateCategoryByCategoryId(Category category) throws Exception {
    Long categoryId = category.getCategoryId();
    if (!isCategoryExit(categoryId)) {
      throw new Exception("Category: " + categoryId + " doesn't exit.");
    } else {
      iPostMapper.updateCategoryByCategoryId(category);
    }
  }

  @Override
  public Category selectCategoryByCategoryId(Long categoryId) {
    return iPostMapper.selectCategoryByCategoryId(categoryId);
  }

  @Override
  public List<Category> selectAllCategory(String categoryName) {
    return iPostMapper.selectAllCategory(categoryName);
  }

  @Override
  public Long insertTag(Tag tag) {
    Tag tag1 = iPostMapper.selectTagByTagId(tag.getTagId());
    Tag tag2 = iPostMapper.selectTagByTagName(tag.getTagName());
    if (tag1 == null && tag2 == null) {
      iPostMapper.insertTag(tag);
      return tag.getTagId();
    } else if (tag1 != null) {
      return tag1.getTagId();
    } else {
      return tag2.getTagId();
    }
  }

  @Override
  public void deleteTagByTagId(Long tagId) {
    iPostMapper.deleteTagByTagId(tagId);
  }

  @Override
  public void updateTagByTagId(Tag tag) throws Exception {
    Long tagId = tag.getTagId();
    if (iPostMapper.selectTagByTagId(tagId) == null) {
      throw new Exception("Tag: " + tagId + " doesn't exit.");
    } else {
      iPostMapper.updateTagByTagId(tag);
    }
  }

  @Override
  public Tag selectTagByTagId(Long tagId) {
    return iPostMapper.selectTagByTagId(tagId);
  }

  @Override
  public List<Tag> selectAllTag(String tagName) {
    return iPostMapper.selectAllTag(tagName);
  }

  private void insertMetas(List<Meta> metas, Long postId) {
    for (Meta meta : metas) {
      iPostMapper.insertPostMeta(postId, meta.getMetaKey(), meta.getMetaValue());
    }
  }

  private void insertTags(List<Tag> tags, Long postId) {
    for (Tag tag : tags) {
      Long tagId = insertTag(tag);
      iPostMapper.insertPostTag(postId, tagId);
    }
  }

  private boolean isCategoryExit(Long categoryId) {
    Category category =
        iPostMapper.selectCategoryByCategoryId(categoryId);
    return category == null;
  }
}
