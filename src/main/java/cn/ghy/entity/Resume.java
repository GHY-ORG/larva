package cn.ghy.entity;

import cn.ghy.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Ziyang
 * @Email meetziyang@gmail.com
 * @description 文件 前端控制器
 * @since 2018/10/2 17:54
 */
public class Resume {

  @NotNull
  @Size(min = 2, max = 15)
  private String name;

  private String sex;

  @Past
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthday;

  @NotNull
  private String gradeMajor;

  @Pattern(regexp = "[1-9][0-9]{4,}")
  private String qq;

  @NotNull
  @Email
  private String email;

  @NotNull
  //支持手机号码，3-4位区号，7-8位直播号码，1－4位分机号
  @Pattern(regexp = "^((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)")
  private String phone;

  @NotNull
  private boolean office;

  @NotNull
  private boolean operationDepartment;

  @NotNull
  private boolean developmentDepartment;

  @NotNull
  private boolean designDepartment;

  @NotNull
  private boolean filmDepartment;

  @NotNull
  private boolean informationDepartment;

  @NotNull
  private boolean lifeWebsite;

  @NotNull
  private boolean musicWebsite;

  @NotNull
  private boolean softwareWebsite;

  @NotNull
  private boolean studyWebsite;

  @NotNull
  private String reason;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getGradeMajor() {
    return gradeMajor;
  }

  public void setGradeMajor(String gradeMajor) {
    this.gradeMajor = gradeMajor;
  }

  public String getQQ() {
    return qq;
  }

  public void setQQ(String qq) {
    this.qq = qq;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public boolean isOffice() {
    return office;
  }

  public void setOffice(boolean office) {
    this.office = office;
  }

  public boolean isOperationDepartment() {
    return operationDepartment;
  }

  public void setOperationDepartment(boolean operationDepartment) {
    this.operationDepartment = operationDepartment;
  }

  public boolean isDevelopmentDepartment() {
    return developmentDepartment;
  }

  public void setDevelopmentDepartment(boolean developmentDepartment) {
    this.developmentDepartment = developmentDepartment;
  }

  public boolean isDesignDepartment() {
    return designDepartment;
  }

  public void setDesignDepartment(boolean designDepartment) {
    this.designDepartment = designDepartment;
  }

  public boolean isFilmDepartment() {
    return filmDepartment;
  }

  public void setFilmDepartment(boolean filmDepartment) {
    this.filmDepartment = filmDepartment;
  }

  public boolean isInformationDepartment() {
    return informationDepartment;
  }

  public void setInformationDepartment(boolean informationDepartment) {
    this.informationDepartment = informationDepartment;
  }

  public boolean isLifeWebsite() {
    return lifeWebsite;
  }

  public void setLifeWebsite(boolean lifeWebsite) {
    this.lifeWebsite = lifeWebsite;
  }

  public boolean isMusicWebsite() {
    return musicWebsite;
  }

  public void setMusicWebsite(boolean musicWebsite) {
    this.musicWebsite = musicWebsite;
  }

  public boolean isSoftwareWebsite() {
    return softwareWebsite;
  }

  public void setSoftwareWebsite(boolean softwareWebsite) {
    this.softwareWebsite = softwareWebsite;
  }

  public boolean isStudyWebsite() {
    return studyWebsite;
  }

  public void setStudyWebsite(boolean studyWebsite) {
    this.studyWebsite = studyWebsite;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public String toString() {
    return "Resume{" +
        "name='" + name + '\'' +
        ", sex='" + sex + '\'' +
        ", birthday=" + birthday +

        ", gradeMajor='" + gradeMajor + '\'' +
        ", QQ='" + qq + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", office=" + office +
        ", operationDepartment=" + operationDepartment +
        ", developmentDepartment=" + developmentDepartment +
        ", designDepartment=" + designDepartment +
        ", filmDepartment=" + filmDepartment +
        ", informationDepartment=" + informationDepartment +
        ", lifeWebsite=" + lifeWebsite +
        ", musicWebsite=" + musicWebsite +
        ", softwareWebsite=" + softwareWebsite +
        ", studyWebsite=" + studyWebsite +
        ", reason='" + reason + '\'' +
        '}';
  }


  public void write2Excel(String excelFilePath) throws IOException {

    FileUtils fileUtils = new FileUtils();
    File file = new File(excelFilePath);
    XSSFWorkbook workbook;

    //初始化excel文件
    if (!file.exists()) {
      workbook = new XSSFWorkbook();
      XSSFSheet sheet = workbook.createSheet();
      String[] excelHeaders = {
          "姓名", "性别", "出生日期", "年级专业", "QQ", "邮箱", "电话号码", "办公室", "运营部", "开发部",
          "设计部", "影视部", "资讯部", "生活网", "音乐网", "软件园", "学苑", "报名原因", "提交时间"
      };
      Row row = sheet.createRow(0);
      for (int i = 0; i < excelHeaders.length; i++) {
        Cell cell = row.createCell(i);
        cell.setCellValue(excelHeaders[i]);
      }
      fileUtils.writeExcel(workbook, excelFilePath);
    }

    workbook = fileUtils.readExcel(excelFilePath);
    XSSFSheet sheet = workbook.getSheetAt(0);
    Row row = sheet.createRow(sheet.getLastRowNum() + 1);
    int cellIndex = 0;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    //修复当birthday为null时，DataFormat会发生报错的情况
    String birthdayT;
    if (birthday == null) {
      birthdayT = null;
    } else {
      birthdayT = simpleDateFormat.format(birthday);
    }
    String[] personalInformation = {name, sex, birthdayT, gradeMajor, qq, email, phone};
    for (String aPersonalInformation : personalInformation) {
      Cell cell = row.createCell(cellIndex++);
      cell.setCellValue(aPersonalInformation);
    }
    boolean[] personalIntention = {
        office, operationDepartment, developmentDepartment, designDepartment, filmDepartment,
        informationDepartment, lifeWebsite, musicWebsite, softwareWebsite, studyWebsite
    };
    for (boolean aPersonalIntention : personalIntention) {
      Cell cell = row.createCell(cellIndex++);
      cell.setCellValue(aPersonalIntention);
    }
    Cell cell = row.createCell(cellIndex++);
    cell.setCellValue(reason);
    simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    cell = row.createCell(cellIndex++);
    Date now = new Date();
    cell.setCellValue(simpleDateFormat.format(now));

    fileUtils.writeExcel(workbook, excelFilePath);
  }
}
