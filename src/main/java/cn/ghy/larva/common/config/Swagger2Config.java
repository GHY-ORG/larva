package cn.ghy.larva.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ziyang
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("cn.ghy.larva"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Larva CMS RESTful APIs")
        .description(
            "Larva is a Spring MVC-based website background management system with built-in user management, role management, section management, content management, and data analysis.")
        .version("0.0.1.RELEASE")
        .license("MIT")
        .licenseUrl("https://choosealicense.com/licenses/mit/")
        .build();
  }
}