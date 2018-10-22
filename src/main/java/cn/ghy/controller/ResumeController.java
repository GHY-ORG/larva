package cn.ghy.controller;

import cn.ghy.entity.Response;
import cn.ghy.entity.Resume;
import cn.ghy.utils.FileUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ziyang
 * @Email meetziyang@gmail.com
 * @description 简历 前端控制器
 * @since 2018/10/2 17:54
 */
@ControllerAdvice
@RestController
@RequestMapping(value = "/resume")
public class ResumeController {

  private FileUtils fileUtils = new FileUtils();
  private String basePath = fileUtils.getRoot() + "resumes/ghy/";

  public ResumeController() throws UnsupportedEncodingException {
  }

  @RequestMapping(value = "/ghy", method = RequestMethod.POST)
  public Response insert(@Valid @RequestBody Resume resume, BindingResult result)
      throws IOException {
    if (result.hasErrors()) {
      return new Response(400, "Illegal input.");
    } else {
      fileUtils.createDirectory(basePath);
      String path = basePath + getResumeFileName();
      resume.write2Excel(path);
      return new Response(201, "Successfully submit your resume.");
    }
  }

  private String getResumeFileName() {
    String fileName;
    Calendar cal = Calendar.getInstance();
    int month = cal.get(Calendar.MONTH) + 1;
    int year = cal.get(Calendar.YEAR);
    if (month <= 6) {
      fileName = year + "_spring" + ".xlsx";
    } else {
      fileName = year + "_fall" + ".xlsx";
    }
    return fileName;
  }
}