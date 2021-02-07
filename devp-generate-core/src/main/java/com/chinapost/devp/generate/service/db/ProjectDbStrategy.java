package com.chinapost.devp.generate.service.db;

import com.chinapost.devp.generate.pojo.dto.db.ProjectDbConnectionDTO;

import java.util.List;

/**
 * @author zhangwei
 * @version 1.0
 * @Description: Java类描述
 * @date 2021/1/29 11:36
 */
public interface ProjectDbStrategy {

    int testConnection(ProjectDbConnectionDTO dbConnectionDTO);

    List<String> allTable(ProjectDbConnectionDTO dbConnectionDTO);

    String generateDdl(ProjectDbConnectionDTO dbConnectionDTO);
}
