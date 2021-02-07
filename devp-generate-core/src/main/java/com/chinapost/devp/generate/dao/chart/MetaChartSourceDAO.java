package com.chinapost.devp.generate.dao.chart;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.chart.source.MetaChartSourcePO;
import com.chinapost.devp.generate.pojo.qo.chart.MetaChartSourceQO;
import com.chinapost.devp.generate.pojo.vo.chart.source.MetaChartSourceListVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【图表数据源】数据库操作
 *
 * @author: cpit
 * @date: 2020/04/04
 */
@Repository
@Mapper
public interface MetaChartSourceDAO extends DAO<MetaChartSourcePO> {

    /**
     * 根据条件查询【图表数据源】列表
     *
     * @param metaChartSourceQO
     * @return
     */
    List<MetaChartSourceListVO> findListByQuery(MetaChartSourceQO metaChartSourceQO);


    List<MetaChartSourcePO> findByProjectId(Integer projectId);


}



