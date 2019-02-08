package cn.ghy.larva;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ziyang
 */
@EnableSwagger2
@SpringBootApplication
@MapperScan("cn.ghy.larva.dao")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}