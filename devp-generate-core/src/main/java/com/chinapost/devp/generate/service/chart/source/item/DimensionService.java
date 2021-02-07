package com.chinapost.devp.generate.service.chart.source.item;

import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.pojo.dto.chart.source.item.DimensionAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.item.DimensionUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartSourceItemMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.DimensionPO;
import com.chinapost.devp.generate.service.MetaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【维度】服务类
 *
 * @author: cpit
 * @date: 2020-05-10
 */
@Service
public class DimensionService {

    @Autowired
    private MetaChartSourceItemService metaChartSourceItemService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 【维度】数据预处理
     *
     * @param po
     */
    public void preparePO(DimensionPO po) {
        po.featureSerialize();
        metaChartSourceItemService.preparePO(po);
    }

    /**
     * 新增【维度】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public DimensionPO save(DimensionAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        DimensionPO po = this.doSave(addDTO);
        metaProjectService.updateProject(project);
        return po;
    }

    public DimensionPO doSave(DimensionAddDTO addDTO) {
        DimensionPO po = MetaChartSourceItemMapper.INSTANCE
                .fromDimensionAddDTO(addDTO);
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
    public DimensionPO update(DimensionUpdateDTO updateDTO) {
        Integer projectId = updateDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        DimensionPO po = this.doUpdate(updateDTO);
        metaProjectService.updateProject(project);
        return po;
    }

    public DimensionPO doUpdate(DimensionUpdateDTO updateDTO) {
        Integer sourceItemId = updateDTO.getSourceItemId();
        DimensionPO po = metaChartSourceItemService.getMetaChartSourceItem(sourceItemId, true);
        MetaChartSourceItemMapper.INSTANCE.setDimensionUpdateDTO(po, updateDTO);
        this.preparePO(po);
        metaChartSourceItemService.doUpdate(po);
        return po;
    }

}
