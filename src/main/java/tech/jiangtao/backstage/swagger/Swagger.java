package tech.jiangtao.backstage.swagger;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @class: Swagger </br>
 * @description: Swagger配置 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 10/04/2017 2:13 AM</br>
 * @version: 0.0.1 </br>
 **/
@Configuration
@EnableSwagger2
@EnableWebMvc
public class Swagger {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }


  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo(
        "JMessage项目",
        "项目所有接口文档",
        "0.0.8",
        "Kevin",
        "jiangtao103cp@gmail.com",
        "闭源",
        "http://message.jiangtao.tech");
    return apiInfo;
  }
}
