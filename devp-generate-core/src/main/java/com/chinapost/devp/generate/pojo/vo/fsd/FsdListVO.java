package com.chinapost.devp.generate.pojo.vo.fsd;

import com.chinapost.devp.common.constant.JsonFieldConst;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

import static com.chinapost.devp.generate.pojo.example.fsd.FsdExample.*;

/**
 * 【模块功能点】列表展示对象
 *
 * @author wn
 * @date 2021/01/22
 */
@ApiModel(description = "【模块功能点】列表展示对象")
public class FsdListVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private String id;

    @ApiModelProperty(notes = N_PRD_ID, example = N_PRD_ID)
    private String prdId;

    @ApiModelProperty(notes = N_FUNCTION_NAME, example = E_FUNCTION_NAME)
    private String functionName;

    @ApiModelProperty(notes = N_FUNCTION_DESC, example = N_FUNCTION_DESC)
    private String functionDesc;

    @ApiModelProperty(notes = N_STATUS, example = E_STATUS)
    private Integer status;

    @ApiModelProperty(notes = N_CREATED_TIME, example = E_CREATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private LocalDateTime createdTime;

    @ApiModelProperty(notes = N_OPERATED_TIME, example = E_OPERATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private LocalDateTime operatedTime;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrdId() {
        return prdId;
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
        return functionDesc;
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

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getOperatedTime() {
        return this.operatedTime;
    }

    public void setOperatedTime(LocalDateTime operatedTime) {
        this.operatedTime = operatedTime;
    }


}

