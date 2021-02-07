package com.chinapost.devp.generate.help;


import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.pojo.dto.MetaConstAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaConstUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaConstPO;

import static com.chinapost.devp.generate.pojo.example.MetaConstExample.*;

/**
 * 测试数据
 *
 * @author: cpit
 * @date: 2017/5/12
 */
public class MetaConstHelper {

    /**
     * 生成add测试数据
     *
     * @return
     */
    public static MetaConstAddDTO getAddDTO(Integer projectId) {
        MetaConstAddDTO dto = new MetaConstAddDTO();
        dto.setProjectId(projectId);
        dto.setConstName(E_CONSTNAME);
        dto.setConstRemark(E_CONSTREMARK);
        dto.setConstType(SafeUtil.getInteger(E_CONSTTYPE));
        return dto;
    }


    /**
     * 生成update测试数据
     *
     * @return
     */
    public static MetaConstUpdateDTO getUpdateDTO(MetaConstPO metaConst) {
        MetaConstUpdateDTO dto = new MetaConstUpdateDTO();
        dto.setProjectId(metaConst.getProjectId());
        dto.setConstId(metaConst.getConstId());
        dto.setConstName(metaConst.getConstName() + "1");
        dto.setConstRemark(metaConst.getConstRemark() + "1");
        dto.setConstType(metaConst.getConstType());
        return dto;
    }

}
