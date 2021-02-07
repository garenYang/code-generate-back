package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.chinapost.devp.generate.pojo.example.DemandsExample.E_ID;
import static com.chinapost.devp.generate.pojo.example.DemandsExample.N_ID;

/**
 * 【需求列表】列表展示对象
 *
 * @author wn
 * @date 2021/01/22
 */
@ApiModel(description = "【需求列表】列表展示对象")
public class DemandsListVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private Long id;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

