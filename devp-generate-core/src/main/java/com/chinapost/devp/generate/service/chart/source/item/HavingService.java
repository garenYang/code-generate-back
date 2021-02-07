package com.chinapost.devp.generate.service.chart.source.item;

import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.pojo.dto.chart.source.item.HavingAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.item.HavingUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartSourceItemMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.HavingPO;
import com.chinapost.devp.generate.service.MetaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【having条件】服务类
 *
 * @author: cpit
 * @date: 2020-05-10
 */
@Service
public class HavingService {

    @Autowired
    private MetaChartSourceItemService metaChartSourceItemService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 【having条件】数据预处理
     *
     * @param po
     */
    public void preparePO(HavingPO po) {
        po.featureSerialize();
        metaChartSourceItemService.preparePO(po);
    }

    /**
     * 新增【having条件】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public HavingPO save(HavingAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        HavingPO po = this.doSave(addDTO);
        metaProjectService.updateProject(project);
        return po;
    }

    public HavingPO doSave(HavingAddDTO addDTO) {
        HavingPO po = MetaChartSourceItemMapper.INSTANCE
                .fromHavingAddDTO(addDTO);
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
    public HavingPO update(HavingUpdateDTO updateDTO) {
        Integer projectId = updateDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        HavingPO po = this.doUpdate(updateDTO);
        metaProjectService.updateProject(project);
        return po;
    }

    public HavingPO doUpdate(HavingUpdateDTO updateDTO) {
        Integer sourceItemId = updateDTO.getSourceItemId();
        HavingPO po = metaChartSourceItemService.getMetaChartSourceItem(sourceItemId, true);
        MetaChartSourceItemMapper.INSTANCE.setHavingUpdateDTO(po, updateDTO);
        this.preparePO(po);
        metaChartSourceItemService.doUpdate(po);
        return po;
    }
}
