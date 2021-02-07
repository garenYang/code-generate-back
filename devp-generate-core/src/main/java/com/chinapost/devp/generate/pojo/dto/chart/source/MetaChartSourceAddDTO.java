package com.chinapost.devp.generate.pojo.dto.chart.source;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 新增【图表数据源】的参数
 *
 * @author: cpit
 * @date: 2020/04/04
 */
@ApiModel(description = "新增【图表数据源】的参数")
public class MetaChartSourceAddDTO extends AbstractDTO {

    @ApiModelProperty(notes = "项目id", example = "1", required = true)
    @NotNull
    private Integer projectId;

    @ApiModelProperty(notes = "是否聚合", example = "true", required = true)
    @NotNull
    private Boolean aggregation;

    @ApiModelProperty(notes = "主实体id", example = "1", required = true)
    @NotNull
    private Integer entityId;

    @ApiModelProperty(notes = "关联")
    private List<JoinDTO> joins;


    @ApiModelProperty(notes = "数量限制", example = "1000")
    private Integer limit;


    public Boolean getAggregation() {
        return this.aggregation;
    }

    public void setAggregation(Boolean aggregation) {
        this.aggregation = aggregation;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public List<JoinDTO> getJoins() {
        return joins;
    }

    public void setJoins(List<JoinDTO> joins) {
        this.joins = joins;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}


