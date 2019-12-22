//package com.sy.sprite.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// *
// * @description springMvc对外开放api接口文档配置类
// * @author dxy
// * @date 2019-12-09
// * @url http://localhost:8080/swagger-ui.html
// *
// * 注意：1.整合swagger2.9.2版本时，需要implements WebMvcConfigurer中addResourceHandlers，
// * 否则访问swagger-ui.html报404
// */
//@Configuration
//@EnableSwagger2
//public class Swagger2Config implements WebMvcConfigurer {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //为controller包路径
//                .apis(RequestHandlerSelectors.basePackage("com.sy.sprite"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * 构建 api文档的详细信息函数
//     *
//     * @return ApiInfo
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                //页面标题
//                .title("算法精灵 API接口文档")
//                //创建人
//                .contact(new Contact("算法精灵", "http://hehear.com", "hehear@126.com"))
//                //版本号
//                .version("1.0")
//                //描述
//                .description("算法精灵 API接口文档")
//                .build();
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//
//}
