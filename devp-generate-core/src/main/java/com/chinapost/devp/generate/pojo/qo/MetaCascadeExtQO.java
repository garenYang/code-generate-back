package com.chinapost.devp.generate.pojo.qo;

import com.chinapost.devp.common.pojo.qo.AbstractQO;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.MetaCascadeExtExample.E_FIELDID;
import static com.chinapost.devp.generate.pojo.example.MetaCascadeExtExample.N_FIELDID;

/**
 * 查询参数
 *
 * @author: cpit
 * @date: 2020/6/14
 */
public class MetaCascadeExtQO extends AbstractQO {

    @ApiParam(value = N_FIELDID, example = E_FIELDID)
    @NotNull
    private Integer fieldId;

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }
}
