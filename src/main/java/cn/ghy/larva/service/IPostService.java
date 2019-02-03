package cn.ghy.larva.service;

import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.PostMeta;

import java.util.List;

public interface IPostService {

    Long postInsert(Post post);

    void metaInsert(PostMeta meta);

    void deleteById(Long postId);

    Post selectById(Long postId);

    List<Post> selectAll();
}
