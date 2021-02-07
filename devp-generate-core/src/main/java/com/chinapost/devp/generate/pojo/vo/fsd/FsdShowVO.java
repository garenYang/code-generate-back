package com.chinapost.devp.generate.pojo.vo.fsd;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.chinapost.devp.generate.pojo.example.fsd.FsdExample.*;

/**
 * 【模块功能点】详情展示对象
 *
 * @author wn
 * @date 2021/01/22
 */
@ApiModel(description = "【模块功能点】详情展示对象")
public class FsdShowVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private String id;

    @ApiModelProperty(notes = N_PRD_ID, example = E_PRD_ID)
    private String prdId;

    @ApiModelProperty(notes = N_FUNCTION_NAME, example = E_FUNCTION_NAME)
    private String functionName;

    @ApiModelProperty(notes = N_FUNCTION_DESC, example = E_FUNCTION_DESC)
    private String functionDesc;

    @ApiModelProperty(notes = N_STATUS, example = E_STATUS)
    private Integer status;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrdId() {
        return this.prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionDesc() {
        return this.functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}

