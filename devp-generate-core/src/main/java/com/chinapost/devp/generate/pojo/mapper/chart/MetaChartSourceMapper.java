package com.chinapost.devp.generate.pojo.mapper.chart;

import com.chinapost.devp.generate.pojo.dto.chart.source.MetaChartSourceAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.MetaChartSourceUpdateDTO;
import com.chinapost.devp.generate.pojo.po.chart.source.MetaChartSourcePO;
import com.chinapost.devp.generate.pojo.vo.chart.source.MetaChartSourceShowVO;
import com.chinapost.devp.generate.pojo.vo.chart.source.MetaChartSourceWithItemsShowVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 【图表数据源】映射
 *
 * @author: cpit
 * @date: 2020/04/04
 */
@Mapper
public interface MetaChartSourceMapper {

    MetaChartSourceMapper INSTANCE = Mappers.getMapper(MetaChartSourceMapper.class);

    /**
     * addDTO映射po
     *
     * @param metaChartSourceAddDTO
     * @return
     */
    MetaChartSourcePO fromAddDTO(MetaChartSourceAddDTO metaChartSourceAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param metaChartSourcePO
     * @param metaChartSourceUpdateDTO
     */
    void setUpdateDTO(@MappingTarget MetaChartSourcePO metaChartSourcePO, MetaChartSourceUpdateDTO metaChartSourceUpdateDTO);

    /**
     * po映射showVO
     *
     * @param metaChartSourcePO
     * @return
     */
    MetaChartSourceShowVO toShowVO(MetaChartSourcePO metaChartSourcePO);


    MetaChartSourceWithItemsShowVO toWithItemsShowVO(MetaChartSourcePO po);

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "feature"),
            @Mapping(target = "aggregation"),
    })
    MetaChartSourcePO copy(MetaChartSourcePO metaChartSourcePO);
}

