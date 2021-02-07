package com.chinapost.devp.generate.service.chart;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.pojo.dto.chart.BarLineAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.BarLineUpdateDTO;
import com.chinapost.devp.generate.pojo.dto.chart.ChartItemDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.BarLinePO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.DimensionPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.MetricsPO;
import com.chinapost.devp.generate.pojo.vo.chart.BarLineVO;
import com.chinapost.devp.generate.service.MetaProjectService;
import com.chinapost.devp.generate.util.ChartValidateUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 柱线图服务类
 *
 * @author: cpit
 * @date: 2020-06-05
 */
@Service
public class BarLineService {

    @Autowired
    private MetaChartService metaChartService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 校验【柱线图】数据合法性
     *
     * @param po
     */
    public void check(BarLinePO po) {
        ChartItemDTO<DimensionPO> axisX = po.getAxisX();
        if (axisX == null) {
            throw new BusinessException(ErrorCode.INNER_DATA_ERROR, "缺少x轴");
        }
        List<ChartItemDTO<MetricsPO>> axisYList = po.getAxisYList();
        if (CollectionUtils.isEmpty(axisYList)) {
            throw new BusinessException(ErrorCode.INNER_DATA_ERROR, "缺少y轴");
        }
        List<ChartItemDTO> list = new ArrayList<>();
        list.add(axisX);
        if (po.getAxisX2() != null) {
            list.add(po.getAxisX2());
        }
        list.addAll(axisYList);
        ChartValidateUtil.checkItemAliasConflict(list);
    }

    /**
     * 新增【柱线图】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public BarLinePO save(BarLineAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        BarLinePO po = MetaChartMapper.INSTANCE.fromBarLineAddDTO(addDTO);
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
    public BarLinePO update(BarLineUpdateDTO updateDTO) {
        Integer chartId = updateDTO.getChartId();
        BarLinePO po = metaChartService.getMetaChart(chartId, true);
        Integer projectId = po.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        MetaChartMapper.INSTANCE.setBarLineUpdateDTO(po, updateDTO);
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
    public BarLineVO show(Integer chartId) {
        BarLinePO po = metaChartService.getMetaChart(chartId, true);
        BarLineVO vo = MetaChartMapper.INSTANCE.toBarLineVO(po);
        return vo;
    }

}
