package com.chinapost.devp.generate.pojo.dto;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import com.chinapost.devp.generate.constant.PatternConst;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.chinapost.devp.generate.pojo.example.MetaIndexExample.*;

/**
 * 新增索引入参
 *
 * @author: cpit
 * @date: 2017/5/12
 */
public class MetaIndexAddDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_INDEXNAME, example = E_INDEXNAME)
    @NotNull
    @Length(max = 40, message = "indexName最大长度不能超过{max}")
    @Pattern(regexp = PatternConst.FIELD_NAME, message = PatternConst.FIELD_NAME_MSG)
    private String indexName;

    @ApiModelProperty(notes = N_ENTITYID, example = E_ENTITYID)
    @NotNull
    private Integer entityId;

    @ApiModelProperty(notes = N_UNIQUE, example = E_UNIQUE)
    @NotNull
    private Boolean unique;

    @ApiModelProperty(notes = N_UNIQUECHECK, example = E_UNIQUECHECK)
    @NotNull
    private Boolean uniqueCheck;

    @ApiModelProperty(notes = N_FIELDIDS, example = E_FIELDIDS)
    @NotNull
    @Length(max = 100, message = "fieldIds最大长度不能超过{max}")
    @Pattern(regexp = PatternConst.FIELD_IDS, message = PatternConst.FIELD_IDS_MSG)
    private String fieldIds;

    public String getFieldIds() {
        return fieldIds;
    }

    public void setFieldIds(String fieldIds) {
        this.fieldIds = fieldIds;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Boolean getUniqueCheck() {
        return uniqueCheck;
    }

    public void setUniqueCheck(Boolean uniqueCheck) {
        this.uniqueCheck = uniqueCheck;
    }
}
