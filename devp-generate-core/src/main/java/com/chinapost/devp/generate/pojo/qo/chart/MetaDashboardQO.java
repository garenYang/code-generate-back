package com.chinapost.devp.generate.pojo.qo.chart;

import com.chinapost.devp.common.pojo.qo.AbstractQO;
import io.swagger.annotations.ApiParam;

import static com.chinapost.devp.generate.pojo.example.chart.MetaDashboardExample.E_PROJECT_ID;
import static com.chinapost.devp.generate.pojo.example.chart.MetaDashboardExample.N_PROJECT_ID;

/**
 * 查询【看板】的参数
 *
 * @author: cpit
 * @date: 2020/06/13
 */
public class MetaDashboardQO extends AbstractQO {

    @ApiParam(value = N_PROJECT_ID, example = E_PROJECT_ID)
    private Integer projectId;

    @ApiParam(value = "模块排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer moduleSortSign;

    public Integer getModuleSortSign() {
        return moduleSortSign;
    }

    public void setModuleSortSign(Integer moduleSortSign) {
        this.moduleSortSign = moduleSortSign;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

}

