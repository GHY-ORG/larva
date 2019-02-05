package cn.ghy.larva.dao;

import cn.ghy.larva.domain.Post;

import java.util.List;
import java.util.Map;

public interface IPostMapper {
    Long postInsert(Post post);

    void metaInsert(Map<String, Object> meta);

    int deleteById(Long postId);

    int updateById(Post post);

    Post selectById(Long postId);

    List<Post> selectAll();
}