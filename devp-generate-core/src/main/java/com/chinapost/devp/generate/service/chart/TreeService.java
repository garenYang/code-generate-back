package com.chinapost.devp.generate.service.chart;

import com.chinapost.devp.generate.pojo.dto.chart.TreeAddDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.PiePO;
import com.chinapost.devp.generate.pojo.po.chart.TreePO;
import com.chinapost.devp.generate.pojo.vo.chart.PieVO;
import com.chinapost.devp.generate.pojo.vo.chart.TreeVO;
import com.chinapost.devp.generate.service.MetaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanglong
 * date 2021-02-01
 */
@Service
public class TreeService {

    @Autowired
    private MetaChartService metaChartService;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 新增【树表】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public TreePO save(TreeAddDTO addDTO) {
        Integer projectId = addDTO.getProjectId();
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        TreePO po = MetaChartMapper.INSTANCE.fromTreeAddDTO(addDTO);
        metaChartService.doSave(po);
        metaProjectService.updateProject(project);
        return po;
    }

    /**
     * 查询【树表】详情
     *
     * @param chartId
     * @return
     */
    public TreeVO show(Integer chartId) {
        TreePO po = metaChartService.getMetaChart(chartId, true);
        TreeVO vo = MetaChartMapper.INSTANCE.toTreeVO(po);
        return vo;
    }
}
