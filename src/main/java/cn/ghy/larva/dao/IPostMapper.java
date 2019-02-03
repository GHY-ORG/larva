package cn.ghy.larva.dao;

import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.PostMeta;

import java.util.List;

public interface IPostMapper {
    Long postInsert(Post post);

    void metaInsert(PostMeta postMeta);

    int deleteById(Long postId);

    int updateById(Post post);

    Post selectById(Long postId);

    List<Post> selectAll();
}