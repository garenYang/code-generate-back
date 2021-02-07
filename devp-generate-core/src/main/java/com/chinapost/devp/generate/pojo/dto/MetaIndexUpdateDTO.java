package com.chinapost.devp.generate.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.MetaIndexExample.E_INDEXID;
import static com.chinapost.devp.generate.pojo.example.MetaIndexExample.N_INDEXID;

/**
 * 修改索引入参
 *
 * @author: cpit
 * @date: 2017/5/12
 */
public class MetaIndexUpdateDTO extends MetaIndexAddDTO {

    @ApiModelProperty(notes = N_INDEXID, example = E_INDEXID)
    @NotNull
    private Integer indexId;

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }
}
