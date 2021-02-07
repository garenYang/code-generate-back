package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.generate.pojo.dto.MetaMtmCascadeExtAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaMtmCascadeExtUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaMtmCascadeExtPO;
import com.chinapost.devp.generate.pojo.vo.MetaMtmCascadeExtShowVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 【多对多级联扩展】映射
 *
 * @author: cpit
 * @date: 2020/09/21
 */
@Mapper
public interface MetaMtmCascadeExtMapper {

    MetaMtmCascadeExtMapper INSTANCE = Mappers.getMapper(MetaMtmCascadeExtMapper.class);

    /**
     * addDTO映射po
     *
     * @param metaMtmCascadeExtAddDTO
     * @return
     */
    MetaMtmCascadeExtPO fromAddDTO(MetaMtmCascadeExtAddDTO metaMtmCascadeExtAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param metaMtmCascadeExtPO
     * @param metaMtmCascadeExtUpdateDTO
     */
    void setUpdateDTO(@MappingTarget MetaMtmCascadeExtPO metaMtmCascadeExtPO, MetaMtmCascadeExtUpdateDTO metaMtmCascadeExtUpdateDTO);

    /**
     * po映射showVO
     *
     * @param metaMtmCascadeExtPO
     * @return
     */
    MetaMtmCascadeExtShowVO toShowVO(MetaMtmCascadeExtPO metaMtmCascadeExtPO);

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "alias"),
            @Mapping(target = "list"),
            @Mapping(target = "show"),
            @Mapping(target = "query"),
    })
    MetaMtmCascadeExtPO copy(MetaMtmCascadeExtPO mtmCascadeExtFromJson);


}

