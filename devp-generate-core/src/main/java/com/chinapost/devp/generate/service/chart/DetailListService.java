package com.chinapost.devp.generate.service.chart;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.pojo.dto.chart.DetailListAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.DetailListUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.DetailListPO;
import com.chinapost.devp.generate.pojo.vo.chart.DetailListVO;
import com.chinapost.devp.generate.service.MetaProjectService;
import com.chinapost.devp.generate.util.ChartValidateUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 明细表服务类
 *
 * @author: cpit
 * @date: 2020-05-05
 */
@Service
public class DetailListService {

    @Autowired
    private MetaChartService metaChartService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 校验【明细表】数据合法性
     *
     * @param po
     */
    public void check(DetailListPO po) {
        if (CollectionUtils.isEmpty(po.getColumnList())) {
            throw new BusinessException(ErrorCode.INNER_DATA_ERROR, "未添加明细列");
        }
        ChartValidateUtil.checkItemAliasConflict(po.getColumnList());
    }

    /**
     * 新增【明细表】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public DetailListPO save(DetailListAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        DetailListPO po = MetaChartMapper.INSTANCE.fromDetailListAddDTO(addDTO);
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
    public DetailListPO update(DetailListUpdateDTO updateDTO) {
        Integer chartId = updateDTO.getChartId();
        DetailListPO po = metaChartService.getMetaChart(chartId, true);
        Integer projectId = po.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        MetaChartMapper.INSTANCE.setDetailListUpdateDTO(po, updateDTO);
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
    public DetailListVO show(Integer chartId) {
        DetailListPO po = metaChartService.getMetaChart(chartId, true);
        DetailListVO vo = MetaChartMapper.INSTANCE.toDetailListVO(po);
        return vo;
    }

}
