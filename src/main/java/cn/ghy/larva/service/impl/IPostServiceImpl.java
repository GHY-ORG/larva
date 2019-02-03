package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.IPostMapper;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.domain.PostMeta;
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

    public Long postInsert(Post post) {
        return iPostMapper.postInsert(post);
    }

    public void metaInsert(PostMeta postMeta) {
        iPostMapper.metaInsert(postMeta);
    }

    public void deleteById(Long postId) {
        iPostMapper.deleteById(postId);
    }

    public Post selectById(Long postId) {
        return iPostMapper.selectById(postId);
    }

    public List<Post> selectAll() {
        return iPostMapper.selectAll();
    }
}
