package com.chinapost.devp.generate.help;


import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.constant.FeatureConst;
import com.chinapost.devp.generate.pojo.dto.MetaProjectAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaProjectFeatureDTO;
import com.chinapost.devp.generate.pojo.dto.MetaProjectUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.FeatureMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;

import static com.chinapost.devp.generate.pojo.example.MetaProjectExample.*;

/**
 * 测试数据
 *
 * @author: cpit
 * @date: 2017/5/12
 */
public class MetaProjectHelper {

    /**
     * 生成add测试数据
     *
     * @return
     */
    public static MetaProjectAddDTO getAddDTO() {
        MetaProjectAddDTO metaProjectAddDTO = new MetaProjectAddDTO();
        metaProjectAddDTO.setAuthor(E_AUTHOR);
        metaProjectAddDTO.setProjectName(E_PROJECTNAME);
        metaProjectAddDTO.setPackageName(E_PACKAGENAME);
        metaProjectAddDTO.setProjectDesc(E_PROJECTDESC);
        metaProjectAddDTO.setGroupId(E_GROUPID);
        metaProjectAddDTO.setRemote(SafeUtil.getBoolean(E_REMOTE));
        metaProjectAddDTO.setFeature(getFeature());
        return metaProjectAddDTO;
    }


    private static MetaProjectFeatureDTO getFeature() {
        MetaProjectFeatureDTO dto = new MetaProjectFeatureDTO();
        dto.setBootVersion(FeatureConst.Boot.BOOT_2);
        return dto;
    }

    /**
     * 生成update测试数据
     *
     * @return
     */
    public static MetaProjectUpdateDTO getUpdateDTO(MetaProjectPO metaProject) {
        MetaProjectUpdateDTO metaProjectUpdateDTO = new MetaProjectUpdateDTO();
        metaProjectUpdateDTO.setProjectId(metaProject.getProjectId());
        metaProjectUpdateDTO.setAuthor(metaProject.getAuthor() + 1);
        metaProjectUpdateDTO.setProjectName(metaProject.getProjectName() + 1);
        metaProjectUpdateDTO.setPackageName(metaProject.getPackageName() + 1);
        metaProjectUpdateDTO.setProjectDesc(metaProject.getProjectDesc() + 1);
        metaProjectUpdateDTO.setGroupId(metaProject.getGroupId() + 1);
        metaProjectUpdateDTO.setRemote(metaProject.getRemote());
        MetaProjectFeatureDTO featureDTO = FeatureMapper.asProjectFeatureDTO(metaProject.getFeature());
        metaProjectUpdateDTO.setFeature(featureDTO);
        return metaProjectUpdateDTO;
    }

}
