package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 抽象校验结果展示对象
 *
 * @author: cpit
 * @date: 2020/10/10
 */
public class MetaAbstractValidateVO extends AbstractVO {

    @ApiModelProperty(notes = "是否校验成功", example = "true")
    private Boolean success;

    public MetaAbstractValidateVO() {
        this.success = true;
    }

    public void error() {
        this.success = false;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
