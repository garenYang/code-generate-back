package com.chinapost.devp.generate.service.chart;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.dao.chart.MetaChartDAO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.MetaChartPO;
import com.chinapost.devp.generate.pojo.qo.chart.MetaChartQO;
import com.chinapost.devp.generate.pojo.vo.chart.MetaChartListVO;
import com.chinapost.devp.generate.service.MetaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 【图表】增删改查服务
 *
 * @author: cpit
 * @date: 2020/04/04
 */
@Service
public class MetaChartService {

    @Autowired
    private MetaChartDAO metaChartDAO;
    @Autowired
    private MetaProjectService metaProjectService;

    /**
     * 查询列表
     *
     * @param metaChartQO
     * @return
     */
    public List<MetaChartListVO> list(MetaChartQO metaChartQO) {
        List<MetaChartListVO> list = metaChartDAO.findListByQuery(metaChartQO);
        return list;
    }

    /**
     * 根据主键获取【图表】
     *
     * @param chartId 主键
     * @param force   是否强制获取
     * @return
     */
    public <T extends MetaChartPO> T getMetaChart(Integer chartId, boolean force) {
        MetaChartPO metaChart = metaChartDAO.findById(chartId);
        if (force && metaChart == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return metaChart.castSubType(true);
    }


    /**
     * 删除【图表】
     *
     * @param chartIds
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Integer... chartIds) {
        int count = 0;
        for (Integer chartId : chartIds) {
            MetaChartPO po = metaChartDAO.findById(chartId);
            if (po == null) {
                continue;
            }
            Integer projectId = po.getProjectId();
            //校验操作人
            MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
            count += metaChartDAO.delete(chartId);
            metaProjectService.updateProject(project);
        }
        return count;
    }


    /**
     * 根据项目id查询所有图表实体
     *
     * @param projectId
     * @param cast
     * @return
     */
    public List<MetaChartPO> findByProjectId(Integer projectId, boolean cast) {
        List<MetaChartPO> list = metaChartDAO.findByProjectId(projectId);
        if (!cast) {
            return list;
        }
        return list.stream()
                .<MetaChartPO>map(po -> po.castSubType(true))
                .collect(Collectors.toList());
    }

    public void doSave(MetaChartPO metaChartPO) {
        metaChartDAO.save(metaChartPO);
    }

    public int doUpdate(MetaChartPO po) {
        return metaChartDAO.update(po);
    }
}


