package com.chinapost.devp.generate.help;


import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.pojo.dto.MetaEntityAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaEntityUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaEntityPO;

import static com.chinapost.devp.generate.pojo.example.MetaEntityExample.*;

/**
 * 测试数据
 *
 * @author: cpit
 * @date: 2017/5/12
 */
public class MetaEntityHelper {

    /**
     * 生成add测试数据
     *
     * @return
     */
    public static MetaEntityAddDTO getAddDTO(Integer projectId, int i) {
        MetaEntityAddDTO dto = new MetaEntityAddDTO();
        dto.setProjectId(projectId);
        dto.setSchemaName(E_SCHEMANAME);
        dto.setClassName(E_CLASSNAME + i);
        dto.setTableName(E_TABLENAME + i);
        dto.setPageSign(SafeUtil.getBoolean(E_PAGESIGN));
        dto.setDesc(E_DESC + i);
        dto.setTitle(E_TITLE + i);
        return dto;
    }


    /**
     * 生成update测试数据
     *
     * @return
     */
    public static MetaEntityUpdateDTO getUpdateDTO(MetaEntityPO metaEntity) {
        MetaEntityUpdateDTO dto = new MetaEntityUpdateDTO();
        dto.setProjectId(metaEntity.getProjectId());
        dto.setEntityId(metaEntity.getEntityId());
        dto.setSchemaName(metaEntity.getSchemaName() + "1");
        dto.setClassName(metaEntity.getClassName() + "1");
        dto.setTableName(metaEntity.getTableName() + "1");
        dto.setTitle(metaEntity.getTitle() + "1");
        dto.setDesc(metaEntity.getDesc() + "1");
        dto.setPageSign(metaEntity.getPageSign());
        return dto;
    }

}
