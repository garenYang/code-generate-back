package com.chinapost.devp.generate.service.db;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.ds.simple.SimpleDataSource;
import cn.hutool.db.meta.MetaUtil;
import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.RuntimeMsgException;
import com.chinapost.devp.generate.constant.DdlConst;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbConnectionDTO;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhangwei
 * @version 1.0
 * @Description: Java类描述
 * @date 2021/1/29 11:41
 */
@Slf4j
public class MysqlStrategy implements ProjectDbStrategy {

    @Override
    public int testConnection(ProjectDbConnectionDTO dbConnectionDTO) {
        int isOK = 1;
        //获取数据源信息
        DataSource ds = getDataSource(dbConnectionDTO);
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            isOK = 0;
            log.info("mysql数据库连接失败,message = {}", e.getMessage());
        } finally {
            DbUtil.close(connection);
        }

        return isOK;
    }

    @Override
    public List<String> allTable(ProjectDbConnectionDTO dbConnectionDTO) {
        int connection = testConnection(dbConnectionDTO);
        if (0 == connection) {
            throw new RuntimeMsgException(ErrorCode.DB_CONNECTION_ERROR.getDesc());
        }
        DataSource ds = getDataSource(dbConnectionDTO);
        List<String> tables = MetaUtil.getTables(ds);
        DbUtil.close(ds);
        return tables;
    }

    @Override
    public String generateDdl(ProjectDbConnectionDTO dbConnectionDTO) {
        List<String> allTables = allTable(dbConnectionDTO);
        if (CollUtil.isEmpty(allTables)) {
            throw new RuntimeMsgException("数据库没有建表,请先在数据库创建表");
        }
        DataSource ds = getDataSource(dbConnectionDTO);
        String ddl;
        if (1 == dbConnectionDTO.getSelectAll()) {
            ddl = createTableDdl(ds, allTables);
        } else {
            List<String> tableNames = dbConnectionDTO.getTableNames();
            if (CollUtil.isEmpty(tableNames)) {
                throw new RuntimeMsgException("选择的数据库表名为空,请选择需要反向生成的表名");
            }
            if (!allTables.containsAll(tableNames)) {
                throw new RuntimeMsgException("选择的数据库表名有误,请选择正确的表名");
            }
            ddl = createTableDdl(ds, tableNames);
        }
        DbUtil.close(ds);
        return ddl;
    }

    private DataSource getDataSource(ProjectDbConnectionDTO dbConnectionDTO) {
        StringBuilder sb = new StringBuilder("jdbc:mysql://");
        sb.append(dbConnectionDTO.getDbHost())
                .append(":").append(dbConnectionDTO.getDbPort())
                .append("/").append(dbConnectionDTO.getDbName());
        log.info("mysql测试数据库连接url = {},user = {},password = {}", sb.toString(), dbConnectionDTO.getDbUser(), dbConnectionDTO.getDbPassword());
        DataSource ds = new SimpleDataSource(sb.toString(), dbConnectionDTO.getDbUser(), dbConnectionDTO.getDbPassword());

        return ds;
    }

    private String createTableDdl(DataSource ds, List<String> tableNames) {
        StringBuilder ddl = new StringBuilder();
        tableNames.forEach(t -> {
            try {
                Entity entity = DbUtil.use(ds).queryOne(DdlConst.CREATE_TABLE_DDL + t);
                String str = entity.getStr(DdlConst.CREATE_TABLE_FIELD);
                ddl.append(str).append(";\r\n");
            } catch (SQLException e) {
                log.info("mysql生成ddl语句SQL执行失败,tableName = {},message = {}", t, e.getMessage());
            }
        });
        return ddl.toString();
    }
}
