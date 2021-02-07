package com.chinapost.devp.generate.pojo.dto;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.DemandsExample.E_ID;
import static com.chinapost.devp.generate.pojo.example.DemandsExample.N_ID;

/**
 * 修改【需求列表】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@ApiModel(description = "修改【需求列表】的参数")
public class DemandsUpdateDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_ID, example = E_ID, required = true)
    @NotNull
    private Long id;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

