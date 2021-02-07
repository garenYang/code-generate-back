package com.chinapost.devp.generate.service.db;

import com.chinapost.devp.generate.pojo.dto.db.ProjectDbConnectionDTO;
import lombok.Data;

import java.util.List;

/**
 * @author zhangwei
 * @version 1.0
 * @Description: Java类描述
 * @date 2021/1/29 11:43
 */
@Data
public class DataSourceContext {

    private ProjectDbStrategy projectDbStrategy;

    public int testConnection(ProjectDbConnectionDTO dbConnectionDTO) {
        projectDbStrategy = ProjectDbStrategyFactory.getInstance().creator(dbConnectionDTO.getDialectName());
        return projectDbStrategy.testConnection(dbConnectionDTO);
    }

    public List<String> allTable(ProjectDbConnectionDTO dbConnectionDTO) {
        projectDbStrategy = ProjectDbStrategyFactory.getInstance().creator(dbConnectionDTO.getDialectName());
        return projectDbStrategy.allTable(dbConnectionDTO);
    }

    public String generateDdl(ProjectDbConnectionDTO dbConnectionDTO) {
        projectDbStrategy = ProjectDbStrategyFactory.getInstance().creator(dbConnectionDTO.getDialectName());
        return projectDbStrategy.generateDdl(dbConnectionDTO);
    }
}
