package cn.ghy.larva.service;

import cn.ghy.larva.domain.Post;

import java.util.List;

public interface IPostService {

    void insert(Post post);

    void deleteById(Long postId);

    Post selectById(Long postId);

    List<Post> selectAll();
}
