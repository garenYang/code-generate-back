package com.chinapost.devp.generate.config;

import com.chinapost.devp.common.util.SpringUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring配置
 *
 * @author: cpit
 * @date: 2017/8/24
 */
@Configuration
public class GenerateConfiguration {

    /**
     * 在这配置bean以后会把applicationContext注入到该类
     *
     * @return
     */
    @Bean
    public SpringUtil springUtil() {
        return new SpringUtil();
    }

    @Bean
    @ConfigurationProperties(prefix = "devp")
    public GenerateProperties generateProperties() {
        return new GenerateProperties();
    }

}
