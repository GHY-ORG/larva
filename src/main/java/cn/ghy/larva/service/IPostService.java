package cn.ghy.larva.service;

import cn.ghy.larva.domain.Category;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.Tag;
import java.util.List;

/**
 * @author Ziyang
 */
public interface IPostService {

  /**
   * <p>
   * 插入文章（包括文章基本信息、元字段、标签与分类映射关系等）
   * </p>
   *
   * @param post 文章
   * @return 文章Id
   * @throws Exception 文章的分类不存在，需创建该分类
   */
  Long insertPost(Post post) throws Exception;

  /**
   * <p>
   * 根据文章Id，删除文章（包括文章基本信息、元字段、标签与分类映射关系等）
   * </p>
   *
   * @param postId 文章Id
   * @throws Exception 文章不存在
   */
  void deletePostByPostId(Long postId) throws Exception;

  /**
   * <p>
   * 根据文章Id，更新文章
   * </p>
   *
   * @param post 文章
   * @throws Exception 文章不存在
   */
  void updatePostByPostId(Post post) throws Exception;

  /**
   * <p>
   * 根据文章Id，查询文章
   * </p>
   *
   * @param postId 文章Id
   * @return 文章
   */
  Post selectPostByPostId(Long postId);

  /**
   * <p>
   * 查询所有符合条件的文章
   * </p>
   *
   * @param userId 用户Id
   * @param postTitle 文章标题
   * @param postContent 文章内容
   * @param postType 文章类型
   * @param postStatus 文章状态
   * @param categoryId 文章分类Id
   * @param tagId 文章标签Id
   * @return List<Post>
   */
  List<Post> selectAllPost(Long userId, String postTitle, String postContent, Integer postType,
      Integer postStatus, Long categoryId, Long tagId);

  /**
   * <p>
   * 插入文章分类
   * </p>
   *
   * @param category 分类
   * @return 分类Id
   */
  Long insertCategory(Category category);

  /**
   * <p>
   * 根据分类Id，删除分类及文章分类映射关系
   * </p>
   *
   * @param categoryId 分类Id
   */
  void deleteCategoryByCategoryId(Long categoryId);

  /**
   * <p>
   * 根据分类Id，更新分类
   * </p>
   *
   * @param category 分类
   * @throws Exception 分类不存在
   */
  void updateCategoryByCategoryId(Category category) throws Exception;

  /**
   * <p>
   * 根据分类Id，查询分类
   * </p>
   *
   * @param categoryId 分类Id
   * @return Category
   */
  Category selectCategoryByCategoryId(Long categoryId);

  /**
   * <p>
   * 查询所有符合条件的分类
   * </p>
   *
   * @param categoryName 分类名称
   * @return List<Category>
   */
  List<Category> selectAllCategory(String categoryName);

  /**
   * <p>
   * 插入文章标签
   * </p>
   *
   * @param tag 标签
   * @return 标签Id
   */
  Long insertTag(Tag tag);

  /**
   * <p>
   * 根据标签Id，删除标签及文章标签映射关系
   * </p>
   *
   * @param tagId 标签Id
   */
  void deleteTagByTagId(Long tagId);

  /**
   * <p>
   * 根据标签Id，更新标签
   * </p>
   *
   * @param tag 标签
   * @throws Exception 标签不存在
   */
  void updateTagByTagId(Tag tag) throws Exception;

  /**
   * <p>
   * 根据标签Id，查询标签
   * </p>
   *
   * @param tagId 标签Id
   * @return Tag
   */
  Tag selectTagByTagId(Long tagId);

  /**
   * <p>
   * 查询所有符合条件的标签
   * </p>
   *
   * @param tagName 标签名称
   * @return List<Tag>
   */
  List<Tag> selectAllTag(String tagName);
}
