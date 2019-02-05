package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.IPostMapper;
import cn.ghy.larva.domain.Meta;
import cn.ghy.larva.domain.Post;
import cn.ghy.larva.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (Meta meta : post.getMetas()) {
            Map<String, Object> temp = new HashMap<>(3);
            temp.put("postId", id);
            temp.put("metaKey", meta.getMetaKey());
            temp.put("metaValue", meta.getMetaValue());
            iPostMapper.metaInsert(temp);
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
