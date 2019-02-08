package cn.ghy.larva.service.impl;

import cn.ghy.larva.dao.IFileMapper;
import cn.ghy.larva.domain.File;
import cn.ghy.larva.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ziyang
 */
@Service
public class IFileServiceImpl implements IFileService {
  private final IFileMapper iFileMapper;

  @Autowired
  public IFileServiceImpl(IFileMapper iFileMapper) {
    this.iFileMapper = iFileMapper;
  }

  @Override
  public int deleteById(Long fileId) {
    return iFileMapper.deleteById(fileId);
  }

  @Override
  public int insert(File file) {
    return iFileMapper.insert(file);
  }

  @Override
  public File selectById(Long fileId) {
    return iFileMapper.selectById(fileId);
  }

  @Override
  public int updateById(File file) {
    return iFileMapper.updateById(file);
  }
}