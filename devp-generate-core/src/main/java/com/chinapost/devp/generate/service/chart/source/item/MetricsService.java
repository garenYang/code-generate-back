package com.chinapost.devp.generate.service.chart.source.item;

import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.pojo.dto.chart.source.item.MetricsAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.item.MetricsUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartSourceItemMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.MetricsPO;
import com.chinapost.devp.generate.service.MetaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【指标】服务类
 *
 * @author: cpit
 * @date: 2020-05-10
 */
@Service
public class MetricsService {

    @Autowired
    private MetaChartSourceItemService metaChartSourceItemService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 【指标】数据预处理
     *
     * @param po
     */
    public void preparePO(MetricsPO po) {
        po.featureSerialize();
        metaChartSourceItemService.preparePO(po);
    }

    /**
     * 新增【指标】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public MetricsPO save(MetricsAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        MetricsPO po = this.doSave(addDTO);
        metaProjectService.updateProject(project);
        return po;
    }

    public MetricsPO doSave(MetricsAddDTO addDTO) {
        MetricsPO po = MetaChartSourceItemMapper.INSTANCE
                .fromMetricsAddDTO(addDTO);
        this.preparePO(po);
        metaChartSourceItemService.doSave(po);
        return po;
    }

    /**
     * 修改【图表数据源项】
     *
     * @param updateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public MetricsPO update(MetricsUpdateDTO updateDTO) {
        Integer projectId = updateDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        MetricsPO po = this.doUpdate(updateDTO);
        metaProjectService.updateProject(project);
        return po;
    }

    public MetricsPO doUpdate(MetricsUpdateDTO updateDTO) {
        Integer sourceItemId = updateDTO.getSourceItemId();
        MetricsPO po = metaChartSourceItemService.getMetaChartSourceItem(sourceItemId, true);
        MetaChartSourceItemMapper.INSTANCE.setMetricsUpdateDTO(po, updateDTO);
        this.preparePO(po);
        metaChartSourceItemService.doUpdate(po);
        return po;
    }
}
