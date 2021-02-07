package com.chinapost.devp.generate.help;


import com.chinapost.devp.generate.pojo.dto.MetaCascadeExtAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaCascadeExtUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaCascadeExtPO;

/**
 * 测试数据
 *
 * @author: cpit
 * @date: 2017/5/12
 */
public class MetaCascadeExtHelper {

    /**
     * 生成add测试数据
     *
     * @return
     */
    public static MetaCascadeExtAddDTO getAddDTO(Integer fieldId, Integer entityId, Integer cascadeFieldId, Integer cascadeEntityId) {
        MetaCascadeExtAddDTO dto = new MetaCascadeExtAddDTO();
        dto.setFieldId(fieldId);
        dto.setEntityId(entityId);
        dto.setAlias("alias" + fieldId);
        dto.setList(true);
        dto.setShow(true);
        dto.setQuery(true);
        dto.setCascadeEntityId(cascadeEntityId);
        dto.setCascadeFieldId(cascadeFieldId);
        return dto;
    }


    /**
     * 生成update测试数据
     *
     * @return
     */
    public static MetaCascadeExtUpdateDTO getUpdateDTO(MetaCascadeExtPO metaCascadeExt) {
        MetaCascadeExtUpdateDTO dto = new MetaCascadeExtUpdateDTO();
        dto.setCascadeExtId(metaCascadeExt.getCascadeExtId());
        dto.setFieldId(metaCascadeExt.getFieldId());
        dto.setEntityId(metaCascadeExt.getEntityId());
        dto.setAlias(metaCascadeExt.getAlias() + "s");
        dto.setList(metaCascadeExt.getList());
        dto.setShow(metaCascadeExt.getShow());
        dto.setQuery(metaCascadeExt.getQuery());
        dto.setCascadeEntityId(metaCascadeExt.getCascadeEntityId());
        dto.setCascadeFieldId(metaCascadeExt.getCascadeFieldId());
        return dto;

    }

}
