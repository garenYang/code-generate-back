package com.chinapost.devp.generate.pojo.dto.fsd;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.fsd.FsdExample.*;

/**
 * 修改【模块功能点】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@ApiModel(description = "修改【模块功能点】的参数")
public class FsdUpdateDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_ID, example = E_ID, required = true)
    @NotNull
    private String id;

    @ApiModelProperty(notes = N_PRD_ID, example = E_PRD_ID, required = true)
    @NotNull
    @Length(max = 32)
    private String prdId;

    @ApiModelProperty(notes = N_FUNCTION_NAME, example = E_FUNCTION_NAME, required = true)
    @NotNull
    @Length(max = 20)
    private String functionName;

    @ApiModelProperty(notes = N_FUNCTION_DESC, example = E_FUNCTION_DESC, required = true)
    @NotNull
    @Length(max = 2000)
    private String functionDesc;

    @ApiModelProperty(notes = N_STATUS, example = E_STATUS, required = true)
    @NotNull
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

