package com.jeremy.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by jeremysong on 5/21/2017.
 * 使用springboot扫描的两种注解配置方式：
 * 1、@Controller
 *       @EnableAutoConfiguration
 *       @ComponentScan
 * 2、@SpringBootApplication
 *       @SpringBootApplication注解等价于以默认属性使用
 *       @Configuration,
 *       @EnableAutoConfiguration和
 *       @ComponentScan.
 * 另外application.java也应该按照官方的建议放在root目录下，这样才能扫描到Service和dao，不然还会引起，扫描不到注解的问题。
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        // 通过代码的方式配置SpringBoot的启动端口
        //configurableEmbeddedServletContainer.setPort(8686);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
