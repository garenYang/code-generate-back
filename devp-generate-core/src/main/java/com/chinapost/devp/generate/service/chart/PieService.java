package com.chinapost.devp.generate.service.chart;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.pojo.dto.chart.ChartItemDTO;
import com.chinapost.devp.generate.pojo.dto.chart.PieAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.PieUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.PiePO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.DimensionPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.MetricsPO;
import com.chinapost.devp.generate.pojo.vo.chart.PieVO;
import com.chinapost.devp.generate.service.MetaProjectService;
import com.chinapost.devp.generate.util.ChartValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * 饼图服务类
 *
 * @author: cpit
 * @date: 2020-06-05
 */
@Service
public class PieService {

    @Autowired
    private MetaChartService metaChartService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 校验【饼图】数据合法性
     *
     * @param po
     */
    public void check(PiePO po) {
        ChartItemDTO<DimensionPO> dimension = po.getDimension();
        ChartItemDTO<MetricsPO> metrics = po.getMetrics();
        if (dimension == null) {
            throw new BusinessException(ErrorCode.INNER_DATA_ERROR, "未指定维度");
        }
        if (metrics == null) {
            throw new BusinessException(ErrorCode.INNER_DATA_ERROR, "未指定指标");
        }
        ChartValidateUtil.checkItemAliasConflict(Arrays.asList(dimension, metrics));
    }

    /**
     * 新增【饼图】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public PiePO save(PieAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        PiePO po = MetaChartMapper.INSTANCE.fromPieAddDTO(addDTO);
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
    public PiePO update(PieUpdateDTO updateDTO) {
        Integer chartId = updateDTO.getChartId();
        PiePO po = metaChartService.getMetaChart(chartId, true);
        Integer projectId = po.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        MetaChartMapper.INSTANCE.setPieUpdateDTO(po, updateDTO);
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
    public PieVO show(Integer chartId) {
        PiePO po = metaChartService.getMetaChart(chartId, true);
        PieVO vo = MetaChartMapper.INSTANCE.toPieVO(po);
        return vo;
    }

}
