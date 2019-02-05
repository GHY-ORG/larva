package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.IFileMapper;
import cn.ghy.larva.domain.File;
import cn.ghy.larva.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IFileServiceImpl implements IFileService {
    private final IFileMapper iFileMapper;

    @Autowired
    public IFileServiceImpl(IFileMapper iFileMapper) {
        this.iFileMapper = iFileMapper;
    }

    public int deleteById(Long fileId) {
        return iFileMapper.deleteById(fileId);
    }

    public int insert(File file) {
        return iFileMapper.insert(file);
    }

    public File selectById(Long fileId) {
        return iFileMapper.selectById(fileId);
    }

    public int updateById(File file) {
        return iFileMapper.updateById(file);
    }
}