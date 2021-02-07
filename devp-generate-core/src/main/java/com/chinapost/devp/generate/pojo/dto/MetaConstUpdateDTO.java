package com.chinapost.devp.generate.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.MetaConstExample.E_CONSTID;
import static com.chinapost.devp.generate.pojo.example.MetaConstExample.N_CONSTID;

/**
 * 修改常量类DTO
 *
 * @author: cpit
 * @date: 2017/5/12
 */
@ApiModel(description = "修改常量类参数")
public class MetaConstUpdateDTO extends MetaConstAddDTO {


    @ApiModelProperty(notes = N_CONSTID, example = E_CONSTID)
    @NotNull
    private Integer constId;

    public Integer getConstId() {
        return constId;
    }

    public void setConstId(Integer constId) {
        this.constId = constId;
    }
}
