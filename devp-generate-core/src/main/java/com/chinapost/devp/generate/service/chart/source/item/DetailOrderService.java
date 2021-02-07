package com.chinapost.devp.generate.service.chart.source.item;

import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.pojo.dto.chart.source.item.DetailOrderAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.item.DetailOrderUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartSourceItemMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.DetailOrderPO;
import com.chinapost.devp.generate.service.MetaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【明细排序】服务类
 *
 * @author: cpit
 * @date: 2020-05-10
 */
@Service
public class DetailOrderService {

    @Autowired
    private MetaChartSourceItemService metaChartSourceItemService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 【明细排序】数据预处理
     *
     * @param po
     */
    public void preparePO(DetailOrderPO po) {
        po.featureSerialize();
        metaChartSourceItemService.preparePO(po);
    }

    /**
     * 新增【明细排序】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public DetailOrderPO save(DetailOrderAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        DetailOrderPO po = this.doSave(addDTO);
        metaProjectService.updateProject(project);
        return po;
    }

    public DetailOrderPO doSave(DetailOrderAddDTO addDTO) {
        DetailOrderPO po = MetaChartSourceItemMapper.INSTANCE
                .fromDetailOrderAddDTO(addDTO);
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
    public DetailOrderPO update(DetailOrderUpdateDTO updateDTO) {
        Integer projectId = updateDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        DetailOrderPO po = this.doUpdate(updateDTO);
        metaProjectService.updateProject(project);
        return po;
    }

    public DetailOrderPO doUpdate(DetailOrderUpdateDTO updateDTO) {
        Integer sourceItemId = updateDTO.getSourceItemId();
        DetailOrderPO po = metaChartSourceItemService.getMetaChartSourceItem(sourceItemId, true);
        MetaChartSourceItemMapper.INSTANCE.setDetailOrderUpdateDTO(po, updateDTO);
        this.preparePO(po);
        metaChartSourceItemService.doUpdate(po);
        return po;
    }


}
