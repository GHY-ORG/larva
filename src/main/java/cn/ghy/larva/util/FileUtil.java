package cn.ghy.larva.util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public String baseLocalURL = "D:/upload/";
    private String baseVisitURL = "/upload/";

    public List<cn.ghy.larva.domain.File> upload(HttpServletRequest request, String destination) throws IOException {
        return upload(request, destination, "");
    }

    public ArrayList<cn.ghy.larva.domain.File> upload(HttpServletRequest request, String destination, String description) throws IOException {
        ArrayList<cn.ghy.larva.domain.File> iFiles = new ArrayList<>();
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //取得request中的所有文件
            List<MultipartFile> files = multiRequest.getFiles("file");
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                assert fileName != null;
                if (!"".equals(fileName.trim())) {
                    //保存本地文件
                    file.transferTo(new File(baseLocalURL + destination + "/" + fileName));
                    //获取文件信息
                    cn.ghy.larva.domain.File iFile = getFileInfo(file, destination, description);
                    iFiles.add(iFile);
                }
            }
        }
        return iFiles;
    }

    private cn.ghy.larva.domain.File getFileInfo(MultipartFile file, String destination, String description) {
        cn.ghy.larva.domain.File iFile = new cn.ghy.larva.domain.File();
        String fileName = file.getOriginalFilename();
        iFile.setFileName(fileName);
        iFile.setFileSize(file.getSize());
        iFile.setFileType(this.getFileSuffix(fileName));
        iFile.setLocalUrl(baseLocalURL + destination + "/" + fileName);
        iFile.setVisitUrl(baseVisitURL + destination + "/" + fileName);
        iFile.setDescription(description);
        return iFile;
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
