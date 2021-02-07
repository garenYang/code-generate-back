package com.chinapost.devp.generate.pojo.dto.chart.source.item;

import com.chinapost.devp.common.validator.Const;
import com.chinapost.devp.generate.constant.AggFunction;
import com.chinapost.devp.generate.constant.CustomFieldType;
import com.chinapost.devp.generate.constant.SourceItemType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 新增【指标】入参
 *
 * @author: cpit
 * @date: 2020-04-04
 */
@ApiModel(description = "新增【指标】入参")
public class MetricsAddDTO extends AbstractSourceItemDTO {

    @ApiModelProperty(notes = "字段id", example = "1")
    private Integer fieldId;

    @ApiModelProperty(notes = "聚合函数", example = "1", allowableValues = AggFunction.VALUES_STR)
    @Const(constClass = AggFunction.class)
    private Integer aggFunction;

    @ApiModelProperty(notes = "是否自定义", example = "true", required = true)
    @NotNull
    private Boolean custom;

    @ApiModelProperty(notes = "自定义内容")
    private String customContent;

    @ApiModelProperty(notes = "自定义字段类型", example = "1", allowableValues = CustomFieldType.VALUES_STR)
    @Const(constClass = CustomFieldType.class)
    private Integer customFieldType;


    @Override
    public Integer getType() {
        return SourceItemType.METRICS.getValue();
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getAggFunction() {
        return aggFunction;
    }

    public void setAggFunction(Integer aggFunction) {
        this.aggFunction = aggFunction;
    }

    public Boolean getCustom() {
        return custom;
    }

    public void setCustom(Boolean custom) {
        this.custom = custom;
    }

    public String getCustomContent() {
        return customContent;
    }

    public void setCustomContent(String customContent) {
        this.customContent = customContent;
    }

    public Integer getCustomFieldType() {
        return customFieldType;
    }

    public void setCustomFieldType(Integer customFieldType) {
        this.customFieldType = customFieldType;
    }
}
