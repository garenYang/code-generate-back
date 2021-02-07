package com.chinapost.devp.generate.pojo.dto.chart;

import com.chinapost.devp.generate.constant.ChartType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增【树】入参
 *
 * @author: cpit
 * @date: 2020-04-05
 */
@ApiModel(description = "新增【树】入参")
public class TreeAddDTO extends AbstractChartDTO {

    @ApiModelProperty(notes = "图表配置项模板")
    private String optionTemplate;

    @Override
    public Integer getChartType() {
        return ChartType.TREE.getValue();
    }

    public String getOptionTemplate() {
        return optionTemplate;
    }

    public void setOptionTemplate(String optionTemplate) {
        this.optionTemplate = optionTemplate;
    }

}
