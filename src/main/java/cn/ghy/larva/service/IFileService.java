package cn.ghy.larva.service;

import cn.ghy.larva.domain.File;

/**
 * @author Ziyang
 */
public interface IFileService {
  int deleteById(Long fileId);

  int insert(File record);

  File selectById(Long fileId);

  int updateById(File record);
}