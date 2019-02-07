package cn.ghy.larva.service;

import cn.ghy.larva.domain.Category;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.Tag;

import java.util.List;

public interface IPostService {

    Long insertPost(Post post) throws Exception;
    Long insertCategory(Category category);
    Long insertTag(Tag tag);

    void deleteById(Long postId);

    Post selectPostById(Long postId);

    List<Post> selectAllPost();
}
