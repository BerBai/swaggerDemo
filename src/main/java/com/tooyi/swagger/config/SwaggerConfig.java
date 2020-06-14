package com.tooyi.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


/**
 * Ceated by tooyi on 20/6/14 09:24
 */
@Configuration
@EnableSwagger2  // 开启swagger
public class SwaggerConfig {

    @Bean
    public Docket docket1 () {
        return  new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2 () {
        return  new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    // 配置swagger Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示的swagger环境 1.测试dev 2.发布ver
        Profiles profiles = Profiles.of("dev","test");
        // 获取项目的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(flag) // swagger开关
                .groupName("tooyi")
                .apiInfo(apiInfo()).select()
                // RequestHandlerSelectors配置要扫描接口的方式 basePackage()指定要扫描的包 any()扫描全部 none()都不扫描
                // withClassAnnotation扫描类上的注解
                // withMethodAnnotation扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.tooyi.swagger.controller"))
                // 需要过滤的路径
//                .paths(PathSelectors.ant("/hello"))
                .build();
    }

    // 配置swagger信息 = apiInfo
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("tooyi","https://github.com/tooyi","tooyie@126.com");

        return new ApiInfo("tooyi Swagger 接口", "越努力，越幸运。",
                "1.0", "https://tooyi.github.io",
                contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
