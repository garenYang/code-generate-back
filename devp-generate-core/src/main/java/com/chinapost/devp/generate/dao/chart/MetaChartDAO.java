package com.chinapost.devp.generate.dao.chart;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.chart.MetaChartPO;
import com.chinapost.devp.generate.pojo.qo.chart.MetaChartQO;
import com.chinapost.devp.generate.pojo.vo.chart.MetaChartListVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【图表】数据库操作
 *
 * @author: cpit
 * @date: 2020/04/04
 */
@Repository
@Mapper
public interface MetaChartDAO extends DAO<MetaChartPO> {

    /**
     * 根据条件查询【图表】列表
     *
     * @param metaChartQO
     * @return
     */
    List<MetaChartListVO> findListByQuery(MetaChartQO metaChartQO);

    List<MetaChartPO> findByProjectId(Integer projectId);


}



