package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.IPostMapper;
import cn.ghy.larva.domain.Category;
import cn.ghy.larva.domain.Meta;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.Tag;
import cn.ghy.larva.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPostServiceImpl implements IPostService {
    private final IPostMapper iPostMapper;

    @Autowired
    public IPostServiceImpl(IPostMapper iPostMapper) {
        this.iPostMapper = iPostMapper;
    }

    public Long insertPost(Post post) throws Exception {

        Category category = iPostMapper.selectCategoryById(post.getCategory().getCategoryId());
        if (category == null) {
            throw new Exception("Category: " + post.getCategory().getCategoryName() + " doesn't exit.");
        }
        Long categoryId = post.getCategory().getCategoryId();

        iPostMapper.insertPost(post);
        Long postId = post.getPostId();

        iPostMapper.insertPostCategory(postId, categoryId);

        List<Tag> tags = post.getTags();
        for (Tag tag : tags) {
            Long tagId = insertTag(tag);
            iPostMapper.insertPostTag(postId, tagId);
        }

        List<Meta> metas = post.getMetas();
        for (Meta meta : metas) {
            iPostMapper.insertMeta(postId, meta.getMetaKey(), meta.getMetaValue());
        }
        return postId;
    }
    public Long insertCategory(Category category) {
        iPostMapper.insertCategory(category);
        return category.getCategoryId();
    }
    public Long insertTag(Tag tag) {
        Tag iTag = iPostMapper.selectTagByTagName(tag.getTagName());
        if (iTag == null) {
            iPostMapper.insertTag(tag);
            return tag.getTagId();
        } else {
            return iTag.getTagId();
        }
    }

    public void deleteById(Long postId) {
        iPostMapper.deleteById(postId);
    }

    public Post selectPostById(Long postId) {
        return iPostMapper.selectPostById(postId);
    }
    public List<Post> selectAllPost() {
        return iPostMapper.selectAllPost();
    }
}
