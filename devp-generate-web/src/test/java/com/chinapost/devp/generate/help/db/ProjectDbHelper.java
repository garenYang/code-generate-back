package com.chinapost.devp.generate.help.db;

import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbAddDTO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbUpdateDTO;
import com.chinapost.devp.generate.pojo.po.db.ProjectDbPO;
import com.chinapost.devp.generate.service.db.ProjectDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.chinapost.devp.generate.pojo.example.db.ProjectDbExample.*;

@Component
public class ProjectDbHelper {

    @Autowired
    private ProjectDbService projectDbService;

    /**
     * 生成add测试数据
     *
     * @return
     */
    public ProjectDbAddDTO getProjectDbAddDTO() {
        ProjectDbAddDTO dto = new ProjectDbAddDTO();
        dto.setProjectId(SafeUtil.getInteger(E_PROJECT_ID));
        dto.setDbConnectName(E_DB_CONNECT_NAME);
        dto.setDialectName(E_DIALECT_NAME);
        dto.setDbHost(E_DB_HOST);
        dto.setDbPort(SafeUtil.getInteger(E_DB_PORT));
        dto.setDbName(E_DB_NAME);
        dto.setDbUser(E_DB_USER);
        dto.setDbPassword(E_DB_PASSWORD);
        dto.setIsSavePassword(SafeUtil.getInteger(E_IS_SAVE_PASSWORD));
        dto.setOrderNo(SafeUtil.getInteger(E_ORDER_NO));
        return dto;
    }


    /**
     * 生成update测试数据
     *
     * @return
     */
    public ProjectDbUpdateDTO getProjectDbUpdateDTO(ProjectDbPO projectDb) {
        ProjectDbUpdateDTO dto = new ProjectDbUpdateDTO();
        dto.setId(projectDb.getId());
        dto.setProjectId(projectDb.getProjectId());
        dto.setDbConnectName(projectDb.getDbConnectName());
        dto.setDialectName(projectDb.getDialectName());
        dto.setDbHost(projectDb.getDbHost());
        dto.setDbPort(projectDb.getDbPort());
        dto.setDbName(projectDb.getDbName());
        dto.setDbUser(projectDb.getDbUser());
        dto.setDbPassword(projectDb.getDbPassword());
        dto.setIsSavePassword(projectDb.getIsSavePassword());
        dto.setOrderNo(projectDb.getOrderNo());
        return dto;
    }

    /**
     * 保存示例
     *
     * @return
     */
    public ProjectDbPO saveProjectDbExample() {
        ProjectDbAddDTO addDTO = this.getProjectDbAddDTO();
        return projectDbService.save(addDTO);
    }


}

