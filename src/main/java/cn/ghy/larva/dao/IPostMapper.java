package cn.ghy.larva.dao;

import cn.ghy.larva.domain.Category;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.Tag;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ziyang
 */
public interface IPostMapper {

  /**
   * <p>
   * 插入文章（仅包含文章基本属性）
   * </p>
   *
   * @param post 文章
   */
  void insertPost(Post post);

  /**
   * <p>
   * 插入文章分类
   * </p>
   *
   * @param category 分类
   */
  void insertCategory(Category category);

  /**
   * <p>
   * 插入文章与分类映射关系（一对一）
   * </p>
   *
   * @param postId 文章Id
   * @param categoryId 分类Id
   */
  void insertPostCategory(@Param("postId") Long postId, @Param("categoryId") Long categoryId);

  /**
   * <p>
   * 插入文章元字段（文章额外属性，如：点赞数、访问数等）
   * </p>
   *
   * @param postId 文章Id
   * @param metaKey 文章元字段键
   * @param metaValue 文章元字段值
   */
  void insertPostMeta(@Param("postId") Long postId, @Param("metaKey") String metaKey,
      @Param("metaValue") String metaValue);

  /**
   * <p>
   * 插入文章标签
   * </p>
   *
   * @param tag 标签
   */
  void insertTag(Tag tag);

  /**
   * <p>
   * 插入文章与标签映射关系（一对多）
   * </p>
   *
   * @param postId 文章Id
   * @param tagId 标签Id
   */
  void insertPostTag(@Param("postId") Long postId, @Param("tagId") Long tagId);

  /**
   * <p>
   * 根据文章Id，删除文章（包括文章基本信息、元字段、标签与分类映射关系等）
   * </p>
   *
   * @param postId 文章Id
   */
  void deletePostByPostId(Long postId);

  /**
   * <p>
   * 根据文章Id，删除文章元字段
   * </p>
   *
   * @param postId 文章Id
   */
  void deletePostMetaByPostId(Long postId);

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
   * 根据标签Id，删除标签及文章标签映射
   * </p>
   *
   * @param tagId 标签Id
   */
  void deleteTagByTagId(Long tagId);

  /**
   * <p>
   * 根据文章Id，删除文章标签映射
   * </p>
   *
   * @param postId 文章Id
   */
  void deletePostTagByPostId(Long postId);

  /**
   * <p>
   * 根据文章Id更新文章（仅包含文章基本属性）
   * </p>
   *
   * @param post 文章
   */
  void updatePostByPostId(Post post);

  /**
   * <p>
   * 根据分类Id更新分类
   * </p>
   *
   * @param category 分类
   */
  void updateCategoryByCategoryId(Category category);

  /**
   * <p>
   * 根据文章Id，更新文章与分类映射关系（一对一）
   * </p>
   *
   * @param postId 文章Id
   * @param categoryId 分类Id
   */
  void updatePostCategoryByPostId(@Param("postId") Long postId,
      @Param("categoryId") Long categoryId);

  /**
   * <p>
   * 根据标签Id，更新标签
   * </p>
   *
   * @param tag 标签
   */
  void updateTagByTagId(Tag tag);

  /**
   * <p>
   * 根据文章Id，查询文章
   * </p>
   *
   * @param postId 文章Id
   * @return Post
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
   * @param categoryId 分类Id
   * @param tagId 标签Id
   * @return List<Post>
   */
  List<Post> selectAllPost(@Param("userId") Long userId, @Param("postTitle") String postTitle,
      @Param("postContent") String postContent, @Param("postType") Integer postType,
      @Param("postStatus") Integer postStatus, @Param("categoryId") Long categoryId,
      @Param("tagId") Long tagId);

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
  List<Category> selectAllCategory(@Param("categoryName") String categoryName);

  /**
   * <p>
   * 根据标签Id，获取标签
   * </p>
   *
   * @param tagId 标签Id
   * @return Tag
   */
  Tag selectTagByTagId(Long tagId);

  /**
   * <p>
   * 根据标签名称，获取标签
   * </p>
   *
   * @param tagName 标签名称
   * @return Tag
   */
  Tag selectTagByTagName(String tagName);

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