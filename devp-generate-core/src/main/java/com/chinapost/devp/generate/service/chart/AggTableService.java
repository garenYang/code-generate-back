package com.chinapost.devp.generate.service.chart;

import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.pojo.dto.chart.AggTableAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.AggTableUpdateDTO;
import com.chinapost.devp.generate.pojo.dto.chart.ChartItemDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.AggTablePO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.DimensionPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.MetricsPO;
import com.chinapost.devp.generate.pojo.vo.chart.AggTableVO;
import com.chinapost.devp.generate.service.MetaProjectService;
import com.chinapost.devp.generate.util.ChartValidateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 聚合表服务类
 *
 * @author: cpit
 * @date: 2020-05-05
 */
@Service
public class AggTableService {

    @Autowired
    private MetaChartService metaChartService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 校验【聚合表】数据合法性
     *
     * @param po
     */
    public void check(AggTablePO po) {
        List<ChartItemDTO<DimensionPO>> dimensionList = po.getDimensionList();
        List<ChartItemDTO<MetricsPO>> metricsList = po.getMetricsList();
        List<ChartItemDTO> list = Lists.newArrayList(dimensionList);
        list.addAll(metricsList);
        ChartValidateUtil.checkItemAliasConflict(list);
    }

    /**
     * 新增【聚合表】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public AggTablePO save(AggTableAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        AggTablePO po = MetaChartMapper.INSTANCE.fromAggTableAddDTO(addDTO);
        po.featureSerialize();
        this.check(po);
        metaChartService.doSave(po);
        metaProjectService.updateProject(project);
        return po;
    }


    /**
     * 修改【图表】
     *
     * @param updateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public AggTablePO update(AggTableUpdateDTO updateDTO) {
        Integer chartId = updateDTO.getChartId();
        AggTablePO po = metaChartService.getMetaChart(chartId, true);
        Integer projectId = po.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        MetaChartMapper.INSTANCE.setAggTableUpdateDTO(po, updateDTO);
        po.featureSerialize();
        this.check(po);
        metaChartService.doUpdate(po);
        metaProjectService.updateProject(project);
        return po;
    }


    /**
     * 查询【图表】详情
     *
     * @param chartId
     * @return
     */
    public AggTableVO show(Integer chartId) {
        AggTablePO po = metaChartService.getMetaChart(chartId, true);
        AggTableVO vo = MetaChartMapper.INSTANCE.toAggTableVO(po);
        return vo;
    }

}
