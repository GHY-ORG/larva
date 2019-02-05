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

    public void insert(Post post) {
        iPostMapper.postInsert(post);
        Long id = post.getPostId();
        for (PostMeta meta : post.getMetas()) {
            meta.setPostId(id);
            iPostMapper.metaInsert(meta);
        }
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
