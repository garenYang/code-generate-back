package com.chinapost.devp.generate.pojo.qo;

import com.chinapost.devp.common.pojo.qo.AbstractQO;
import io.swagger.annotations.ApiParam;

import static com.chinapost.devp.generate.pojo.example.MetaMtmCascadeExtExample.*;

/**
 * 查询【多对多级联扩展】的参数
 *
 * @author: cpit
 * @date: 2020/09/21
 */
public class MetaMtmCascadeExtQO extends AbstractQO {

    @ApiParam(value = N_MTM_ID, example = E_MTM_ID)
    private Integer mtmId;

    @ApiParam(value = N_ENTITY_ID, example = E_ENTITY_ID)
    private Integer entityId;

    @ApiParam(value = N_CASCADE_ENTITY_ID, example = E_CASCADE_ENTITY_ID)
    private Integer cascadeEntityId;

    @ApiParam(value = N_CASCADE_FIELD_ID, example = E_CASCADE_FIELD_ID)
    private Integer cascadeFieldId;


    public Integer getMtmId() {
        return this.mtmId;
    }

    public void setMtmId(Integer mtmId) {
        this.mtmId = mtmId;
    }

    public Integer getEntityId() {
        return this.entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getCascadeEntityId() {
        return this.cascadeEntityId;
    }

    public void setCascadeEntityId(Integer cascadeEntityId) {
        this.cascadeEntityId = cascadeEntityId;
    }

    public Integer getCascadeFieldId() {
        return this.cascadeFieldId;
    }

    public void setCascadeFieldId(Integer cascadeFieldId) {
        this.cascadeFieldId = cascadeFieldId;
    }

}

