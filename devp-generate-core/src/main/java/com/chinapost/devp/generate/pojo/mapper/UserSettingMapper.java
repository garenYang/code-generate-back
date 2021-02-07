package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.generate.pojo.dto.UserSettingAddDTO;
import com.chinapost.devp.generate.pojo.dto.UserSettingUpdateDTO;
import com.chinapost.devp.generate.pojo.po.UserSettingPO;
import com.chinapost.devp.generate.pojo.vo.UserSettingShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * 【用户配置】映射
 *
 * @author: cpit
 * @date: 2020/11/08
 */
@Mapper
public interface UserSettingMapper {

    UserSettingMapper INSTANCE = Mappers.getMapper(UserSettingMapper.class);

    /**
     * addDTO映射po
     *
     * @param userSettingAddDTO
     * @return
     */
    UserSettingPO fromAddDTO(UserSettingAddDTO userSettingAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param userSettingPO
     * @param userSettingUpdateDTO
     */
    void setUpdateDTO(@MappingTarget UserSettingPO userSettingPO, UserSettingUpdateDTO userSettingUpdateDTO);

    /**
     * po映射showVO
     *
     * @param userSettingPO
     * @return
     */
    UserSettingShowVO toShowVO(UserSettingPO userSettingPO);

}

