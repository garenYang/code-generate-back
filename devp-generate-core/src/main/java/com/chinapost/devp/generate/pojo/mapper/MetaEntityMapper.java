package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.generate.pojo.dto.MetaEntityAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaEntityUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaEntityPO;
import com.chinapost.devp.generate.pojo.vo.MetaEntityShowVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 实体映射
 * <p>基于mapstruct来实现，编译器自动生成实现类
 *
 * @author: cpit
 * @date: 2020/5/12
 */
@Mapper(uses = {FeatureMapper.class, LabelsMapper.class})
public interface MetaEntityMapper {

    MetaEntityMapper INSTANCE = Mappers.getMapper(MetaEntityMapper.class);

    /**
     * addDTO映射po
     *
     * @param addDTO
     * @return
     */
    MetaEntityPO fromAddDTO(MetaEntityAddDTO addDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param metaEntityPO
     * @param metaEntityUpdateDTO
     */
    void setPO(@MappingTarget MetaEntityPO metaEntityPO, MetaEntityUpdateDTO metaEntityUpdateDTO);

    /**
     * po映射showVO
     *
     * @param metaEntityPO
     * @return
     */
    MetaEntityShowVO toShowVO(MetaEntityPO metaEntityPO);

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "schemaName"),
            @Mapping(target = "className"),
            @Mapping(target = "tableName"),
            @Mapping(target = "title"),
            @Mapping(target = "desc"),
            @Mapping(target = "pageSign"),
            @Mapping(target = "feature"),
            @Mapping(target = "labels"),
    })
    MetaEntityPO copy(MetaEntityPO entity);


}
