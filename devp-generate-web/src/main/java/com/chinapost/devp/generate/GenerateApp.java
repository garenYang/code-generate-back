package com.chinapost.devp.generate;

import com.chinapost.devp.common.optimistic.EnableOptimisticLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 项目启动入口
 *
 * @author: cpit
 */
@SpringBootApplication
@EnableOptimisticLock
public class GenerateApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GenerateApp.class);
        app.run(args);
    }

    /**
     * 兼容tomcat部署模式
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GenerateApp.class);
    }

}
