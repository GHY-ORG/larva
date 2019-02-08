package cn.ghy.larva.dao;

import cn.ghy.larva.domain.File;

/**
 * @author Ziyang
 */
public interface IFileMapper {
  /**
   * <p>
   * 根据文件Id删除数据框中文件信息
   * </p>
   *
   * @param fileId 文件Id
   */
  int deleteById(Long fileId);

  int insert(File record);

  File selectById(Long fileId);

  int updateById(File record);
}