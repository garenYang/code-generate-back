package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.generate.pojo.dto.MetaIndexAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaIndexUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaIndexPO;
import com.chinapost.devp.generate.pojo.vo.MetaIndexShowVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 索引映射
 * <p>基于mapstruct来实现，编译器自动生成实现类
 *
 * @author: cpit
 * @date: 2020/5/16
 */
@Mapper(uses = CommonMapper.class)
public interface MetaIndexMapper {

    MetaIndexMapper INSTANCE = Mappers.getMapper(MetaIndexMapper.class);

    /**
     * addDTO映射po
     *
     * @param addDTO
     * @return
     */
    @Mapping(target = "fieldIds", qualifiedByName = {"CommonMapper", "StringToIntegerList"})
    MetaIndexPO fromAddDTO(MetaIndexAddDTO addDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param metaIndexPO
     * @param metaIndexUpdateDTO
     */
    @Mapping(target = "fieldIds", ignore = true)
    void setPO(@MappingTarget MetaIndexPO metaIndexPO, MetaIndexUpdateDTO metaIndexUpdateDTO);


    /**
     * po映射showVO
     *
     * @param metaIndexPO
     * @return
     */
    @Mapping(target = "fields", ignore = true)
    MetaIndexShowVO toShowVO(MetaIndexPO metaIndexPO);

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "indexName"),
            @Mapping(target = "unique"),
            @Mapping(target = "uniqueCheck"),
    })
    MetaIndexPO copy(MetaIndexPO index);

}
