package com.chinapost.devp.generate.web.config;

import com.chinapost.devp.generate.constant.WebConst;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger配置引入
 *
 * @author: cpit
 */
@Configuration
@ConditionalOnProperty(
    value = "springfox.documentation.enabled",
    havingValue = "true",
    matchIfMissing = true
)
public class SwaggerConfig {

    @Value(WebConst.API_PATH)
    private String apiPath;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
            .select()
            .paths(PathSelectors.ant(apiPath + "/**"))
            .build();
    }

}
