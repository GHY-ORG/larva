package cn.ghy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Author: Ziyang
 * @Email: meetziyang@gmail.com
 * @Date: 2018/10/1 23:00
 * @Description:
 */
public class FileUtils {

  public String getRoot() throws UnsupportedEncodingException {
    /**
     * @description: 获取该项目根路径
     * @param: []
     * @return: java.lang.String
     */
    String rawRoot =
        Objects.requireNonNull(this.getClass().getClassLoader().getResource("/")).getPath()
            .replaceAll("WEB-INF/classes/", "")
            + "upload/";
    return new UrlUtils().decodeUrl(rawRoot);
  }

  public boolean isDirectory(String directoryPath) {
    /**
     * @description: 判断是否为目录
     * @param: [directoryPath]
     * @return: boolean
     */
    return new File(directoryPath).isDirectory();
  }

  public boolean isDirectoryExits(String directoryPath) {
    /**
     * @description: 判断路径是否存在
     * @param: [directoryPath]
     * @return: boolean
     */
    return new File(directoryPath).exists();
  }

  public boolean isFile(String filePath) {
    /**
     * @description: 判断是否为文件
     * @param: [filePath]
     * @return: boolean
     */
    return new File(filePath).isFile();
  }

  public boolean isFileExit(String filePath) {
    return new File(filePath).exists();
  }

  public String getFileShortName(String fileName) {
    /**
     * @description: 获取文件名
     * @param: [fileName]
     * @return: java.lang.String
     */
    if (fileName != null && fileName.length() > 0 && fileName.lastIndexOf(".") > -1) {
      return fileName.substring(0, fileName.lastIndexOf("."));
    }
    return fileName;
  }

  public String getFileSuffix(String fileName) {
    /**
     * @description: 获取文件后缀
     * @param: [fileName]
     * @return: java.lang.String
     */
    if (fileName != null && fileName.length() > 0 && fileName.lastIndexOf(".") > -1) {
      return fileName.substring(fileName.lastIndexOf("."));
    }
    return "";
  }

  public void createDirectory(String directory) {
    /**
     * @description: 创建目录
     * @param: [directory]
     * @return: void
     */
    File dir = new File(directory);
    if (!dir.exists()) {
      dir.mkdirs();
    }
  }

  public void writeExcel(XSSFWorkbook workbook, String excelFilePath) throws IOException {
    /**
     * @description: 保存Excel文件
     * @param: [workbook, excelFilePath]
     * @return: void
     */
    FileOutputStream fileOutputStream = new FileOutputStream(excelFilePath);
    try {
      workbook.write(fileOutputStream);
    } finally {
      fileOutputStream.close();
    }
  }

  public XSSFWorkbook readExcel(String excelFilePath) throws IOException {
    /**
     * @description: 读取Excel文件
     * @param: [excelFilePath]
     * @return: org.apache.poi.xssf.usermodel.XSSFWorkbook
     */
    FileInputStream fileInputStream = new FileInputStream(excelFilePath);
    XSSFWorkbook workbook;
    try {
      workbook = new XSSFWorkbook(fileInputStream);
    } finally {
      fileInputStream.close();
    }
    return workbook;
  }
/*
  public boolean fileDownload(HttpServletResponse httpServletResponse, String fileName){

    httpServletResponse.setHeader("content-type", "application/octet-stream");
    httpServletResponse.setHeader("Content-Disposition",
        "attachment;filename=" + new UrlUtils().encodeUrl(fileName));
    httpServletResponse.setContentType("application/octet-stream");
  }*/
}
