package com.chinapost.devp.generate.pojo.qo;

import com.chinapost.devp.common.pojo.qo.PageQO;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.GenHistoryExample.E_PROJECTID;
import static com.chinapost.devp.generate.pojo.example.GenHistoryExample.N_PROJECTID;

/**
 * 分页查询参数
 *
 * @author: cpit
 * @date: 2020/5/12
 */
public class GenHistoryQO extends PageQO {

    @ApiParam(value = N_PROJECTID, example = E_PROJECTID)
    @NotNull
    private Integer projectId;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

}
