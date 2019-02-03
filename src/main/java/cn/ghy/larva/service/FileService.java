package cn.ghy.larva.service;


import cn.ghy.larva.domain.File;

public interface FileService {
    int deleteById(Long fileId);

    int insert(File record);

    File selectById(Long fileId);

    int updateById(File record);
}