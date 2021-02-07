package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.constant.JsonFieldConst;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

import static com.chinapost.devp.generate.pojo.example.CodeTemplateExample.*;

/**
 * 【代码模板】列表展示对象
 *
 * @author: cpit
 * @date: 2020/10/24
 */

@Data
@ApiModel(description = "【代码模板】列表展示对象")
public class CodeTemplateListVO extends AbstractVO {

    @ApiModelProperty(notes = N_TEMPLATE_ID, example = E_TEMPLATE_ID)
    private Integer templateId;

    @ApiModelProperty(notes = N_CODE, example = E_CODE)
    private String code;

    @ApiModelProperty(notes = N_NAME, example = E_NAME)
    private String name;

    @ApiModelProperty(notes = N_TEMPLATE_VERSION, example = E_TEMPLATE_VERSION)
    private String templateVersion;

    @ApiModelProperty(notes = N_SYS_LOW_VERSION, example = E_SYS_LOW_VERSION)
    private String sysLowVersion;

    @ApiModelProperty(notes = N_SYS_DEFAULT, example = E_SYS_DEFAULT)
    private Boolean sysDefault;

    @ApiModelProperty(notes = N_REMARK, example = E_REMARK)
    private String remark;

    @ApiModelProperty(notes = N_OPERATEDBY, example = E_OPERATEDBY)
    private String operatedBy;

    @ApiModelProperty(notes = N_OPERATEDTIME, example = E_OPERATEDTIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date operatedTime;

}

