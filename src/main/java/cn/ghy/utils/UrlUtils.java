package cn.ghy.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Ziyang
 * @Email: meetziyang@gmail.com
 * @Date: 2018/10/2 22:22
 * @Description:
 */
public class UrlUtils {

  public String encodeUrl(String decodedUrl) {
    return URLEncoder.encode(decodedUrl, StandardCharsets.UTF_8);
  }

  public String decodeUrl(String encodedUrl) {
    return URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8);
  }
}
