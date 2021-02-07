package com.chinapost.devp.generate.web;

import com.chinapost.devp.generate.AbstractTest;
import com.chinapost.devp.generate.constant.WebConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * web单元测试抽象类
 *
 * @author: cpit
 * @date: 2020/5/12
 */
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public abstract class AbstractWebTest extends AbstractTest {

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    protected MockMvc restMockMvc;

    @Value(WebConst.API_PATH)
    protected String apiPath;

    protected String getApiPath() {
        if (StringUtils.isBlank(apiPath)) {
            return "";
        }
        return apiPath;
    }

}
