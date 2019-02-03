package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.FileMapper;
import cn.ghy.larva.domain.File;
import cn.ghy.larva.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    private final FileMapper fileMapper;

    @Autowired
    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public int deleteById(Long fileId) {
        return fileMapper.deleteById(fileId);
    }

    public int insert(File file) {
        return fileMapper.insert(file);
    }

    public File selectById(Long fileId) {
        return fileMapper.selectById(fileId);
    }

    public int updateById(File file) {
        return fileMapper.updateById(file);
    }
}