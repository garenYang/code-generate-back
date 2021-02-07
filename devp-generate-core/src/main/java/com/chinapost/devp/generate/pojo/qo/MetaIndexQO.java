package com.chinapost.devp.generate.pojo.qo;

import com.chinapost.devp.common.pojo.qo.AbstractQO;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.MetaIndexExample.E_ENTITYID;
import static com.chinapost.devp.generate.pojo.example.MetaIndexExample.N_ENTITYID;


/**
 * 查询参数
 *
 * @author: cpit
 * @date: 2020/5/12
 */
public class MetaIndexQO extends AbstractQO {

    @ApiParam(value = N_ENTITYID, example = E_ENTITYID)
    @NotNull
    private Integer entityId;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }
}
