package cn.ghy.larva.dao;

import cn.ghy.larva.domain.Category;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPostMapper {

    void insertPost(Post post);

    void insertCategory(Category category);

    void insertPostCategory(@Param("postId") Long postId, @Param("categoryId") Long categoryId);

    void insertMeta(@Param("postId") Long postId, @Param("metaKey") String metaKey, @Param("metaValue") String metaValue);

    void insertTag(Tag tag);

    void insertPostTag(@Param("postId") Long postId, @Param("tagId") Long tagId);

    int deleteById(Long postId);

    int updateById(Post post);

    Post selectPostById(Long postId);

    List<Post> selectAllPost(@Param("userId") Long userId, @Param("postTitle") String postTitle, @Param("postContent") String postContent, @Param("postType") Integer postType, @Param("postStatus") Integer postStatus, @Param("categoryId") Long categoryId, @Param("tagId") Long tagId);

    Category selectCategoryById(Long categoryId);

    List<Category> selectAllCategory();

    Tag selectTagById(Long tagId);

    Tag selectTagByTagName(String tagName);

    List<Tag> selectAllTag();
}