package com.chinapost.devp.generate.service.db;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.db.dialect.DialectName;

import java.util.Map;

/**
 * @author zhangwei
 * @version 1.0
 * @Description: Java类描述
 * @date 2021/1/29 11:36
 */
public class ProjectDbStrategyFactory {

    private static ProjectDbStrategyFactory factory = new ProjectDbStrategyFactory();

    private ProjectDbStrategyFactory() {
    }

    private static Map<String, ProjectDbStrategy> strategyMap = CollUtil.newHashMap();

    static {
        strategyMap.put(DialectName.MYSQL.name(), new MysqlStrategy());
    }

    public ProjectDbStrategy creator(String dialectName) {
        return strategyMap.get(dialectName);
    }

    public static ProjectDbStrategyFactory getInstance() {
        return factory;
    }
}
