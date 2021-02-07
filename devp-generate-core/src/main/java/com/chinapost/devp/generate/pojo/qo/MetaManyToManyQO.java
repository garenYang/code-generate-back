package com.chinapost.devp.generate.pojo.qo;

import com.chinapost.devp.common.pojo.qo.AbstractQO;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.MetaManyToManyExample.E_PROJECTID;
import static com.chinapost.devp.generate.pojo.example.MetaManyToManyExample.N_PROJECTID;


/**
 * 多对多查询参数
 *
 * @author: cpit
 */
public class MetaManyToManyQO extends AbstractQO {

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
