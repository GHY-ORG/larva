package cn.ghy.service.impl;

import cn.ghy.entity.File;
import cn.ghy.mapper.FileMapper;
import cn.ghy.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件 服务实现类
 * </p>
 *
 * @author Ziyang
 * @since 2018-10-13
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

}
