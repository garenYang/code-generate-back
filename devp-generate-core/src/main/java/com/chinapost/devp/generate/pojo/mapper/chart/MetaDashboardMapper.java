package com.chinapost.devp.generate.pojo.mapper.chart;

import com.chinapost.devp.generate.pojo.dto.chart.MetaDashboardAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.MetaDashboardUpdateDTO;
import com.chinapost.devp.generate.pojo.po.chart.MetaDashboardPO;
import com.chinapost.devp.generate.pojo.vo.chart.MetaDashboardShowVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 【看板】映射
 *
 * @author: cpit
 * @date: 2020/06/13
 */
@Mapper
public interface MetaDashboardMapper {

    MetaDashboardMapper INSTANCE = Mappers.getMapper(MetaDashboardMapper.class);

    /**
     * addDTO映射po
     *
     * @param metaDashboardAddDTO
     * @return
     */
    MetaDashboardPO fromAddDTO(MetaDashboardAddDTO metaDashboardAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param metaDashboardPO
     * @param metaDashboardUpdateDTO
     */
    void setUpdateDTO(@MappingTarget MetaDashboardPO metaDashboardPO, MetaDashboardUpdateDTO metaDashboardUpdateDTO);

    /**
     * po映射showVO
     *
     * @param metaDashboardPO
     * @return
     */
    MetaDashboardShowVO toShowVO(MetaDashboardPO metaDashboardPO);

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "name"),
            @Mapping(target = "title"),
            @Mapping(target = "module"),
            @Mapping(target = "feature"),
    })
    MetaDashboardPO copy(MetaDashboardPO metaDashboardFromJson);


}

