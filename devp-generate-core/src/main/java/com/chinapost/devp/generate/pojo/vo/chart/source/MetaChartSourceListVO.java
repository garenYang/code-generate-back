package com.chinapost.devp.generate.pojo.vo.chart.source;

import com.chinapost.devp.common.constant.JsonFieldConst;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import static com.chinapost.devp.generate.pojo.example.chart.MetaChartSourceExample.*;

/**
 * 【图表数据源】列表展示对象
 *
 * @author: cpit
 * @date: 2020/04/04
 */
@ApiModel(description = "【图表数据源】列表展示对象")
public class MetaChartSourceListVO extends AbstractVO {

    @ApiModelProperty(notes = N_SOURCE_ID, example = E_SOURCE_ID)
    private Integer sourceId;

    @ApiModelProperty(notes = N_PROJECT_ID, example = E_PROJECT_ID)
    private Integer projectId;

    @ApiModelProperty(notes = N_FEATURE, example = E_FEATURE)
    private String feature;

    @ApiModelProperty(notes = N_AGGREGATION, example = E_AGGREGATION)
    private Boolean aggregation;

    @ApiModelProperty(notes = N_CREATED_TIME, example = E_CREATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(notes = N_OPERATED_TIME, example = E_OPERATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date operatedTime;


    public Integer getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getFeature() {
        return this.feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Boolean getAggregation() {
        return this.aggregation;
    }

    public void setAggregation(Boolean aggregation) {
        this.aggregation = aggregation;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getOperatedTime() {
        return this.operatedTime;
    }

    public void setOperatedTime(Date operatedTime) {
        this.operatedTime = operatedTime;
    }


}

