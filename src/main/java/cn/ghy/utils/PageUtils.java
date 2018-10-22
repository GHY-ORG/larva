package cn.ghy.utils;

/**
 * @Author: Ziyang
 * @Email: meetziyang@gmail.com
 * @Date: 2018/10/2 02:34
 * @Description:
 */
public class PageUtils {

  public boolean isAsc(String order) {
    boolean isAsc;
    switch (order) {
      case "asc":
        isAsc = true;
        break;
      case "desc":
        isAsc = false;
        break;
      default:
        isAsc = true;
        break;
    }
    return isAsc;
  }
}
