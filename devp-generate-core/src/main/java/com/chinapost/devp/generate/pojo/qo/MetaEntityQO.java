package com.chinapost.devp.generate.pojo.qo;

import com.chinapost.devp.common.pojo.qo.AbstractQO;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.MetaEntityExample.E_PROJECTID;
import static com.chinapost.devp.generate.pojo.example.MetaEntityExample.N_PROJECTID;

/**
 * 分页查询参数
 *
 * @author: cpit
 * @date: 2020/5/12
 */
public class MetaEntityQO extends AbstractQO {

    @ApiParam(value = N_PROJECTID, example = E_PROJECTID)
    @NotNull
    private Integer projectId;

    @ApiParam(value = "模块排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer moduleSortSign;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getModuleSortSign() {
        return moduleSortSign;
    }

    public void setModuleSortSign(Integer moduleSortSign) {
        this.moduleSortSign = moduleSortSign;
    }
}
