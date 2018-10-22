package cn.ghy.controller;

import cn.ghy.entity.Response;
import cn.ghy.service.FileService;
import cn.ghy.utils.FileUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author Ziyang
 * @Email meetziyang@gmail.com
 * @description 文件 前端控制器
 * @since 2018/10/2 17:54
 */
@RestController
public class FileController {

  private final FileService fileService;

  private FileUtils fileUtils = new FileUtils();

  private String root = fileUtils.getRoot();

  @Autowired
  public FileController(FileService fileService) throws UnsupportedEncodingException {
    this.fileService = fileService;
  }

  @RequestMapping(value = "/file/{destination}", method = RequestMethod.POST)
  public Response insert(@PathVariable String destination, HttpServletRequest request)
      throws Exception {
    /*
      @description: 单/多文件上传
     * @param: [destination, request]
     * @return: cn.ghy.entity.Response
     */
    Response response;

    String absolutePath = root + destination + "/";
    String relativePath = "/upload/" + destination + "/";

    if (!fileUtils.isDirectory(absolutePath)) {
      response = new Response(400, "Destination is not a directory.");
      return response;
    }
    if (!fileUtils.isDirectoryExits(absolutePath)) {
      response = new Response(400, "This directory does not exit..");
      return response;
    }

    //创建一个通用的多部分解析器
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
        request.getSession().getServletContext());
    //判断 request 是否有文件上传,即多部分请求
    if (multipartResolver.isMultipart(request)) {
      //转换成多部分request
      MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
      //取得request中的所有文件
      List<MultipartFile> files = multiRequest.getFiles("files");
      for (MultipartFile file : files) {
        String fileName = file.getOriginalFilename();
        //如果名称不为“”,说明该文件存在，否则说明该文件不存在
        if (!"".equals(fileName.trim())) {
          file.transferTo(new File(absolutePath + fileName));

          cn.ghy.entity.File fileEntity = new cn.ghy.entity.File();
          fileEntity.setName(fileUtils.getFileShortName(fileName));
          fileEntity.setSuffix(fileUtils.getFileSuffix(fileName));
          fileEntity.setSize(file.getSize());
          fileEntity.setLocalUrl(absolutePath + fileName);
          fileEntity.setVisitUrl(relativePath + fileName);
          fileEntity.setUploadUid(1);
          fileService.save(fileEntity);
        }
      }
      response = new Response(200, "Successfully uploaded file.");
    } else {
      response = new Response(400, "Upload file not selected.");
    }
    return response;
  }

  @RequestMapping(value = "/file/{id}/download", method = RequestMethod.GET)
  public Response download(HttpServletResponse httpServletResponse, @PathVariable int id) {
    Response response;
    cn.ghy.entity.File file = fileService.getById(id);
    String filePath = file.getLocalUrl();
    String fileName = file.getName() + file.getSuffix();
    if (!fileUtils.isFileExit(filePath)) {
      response = new Response(400, "This file does not exit..");
    } else {
      response = new Response(400, "This file does not exit.");
    }
    return response;
  }
}

