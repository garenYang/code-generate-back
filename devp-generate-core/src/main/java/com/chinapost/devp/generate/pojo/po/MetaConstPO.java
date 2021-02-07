package com.chinapost.devp.generate.pojo.po;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量类
 *
 * @author: cpit
 * @date: 2020/6/13
 */
public class MetaConstPO extends BasePO {

    /**
     * 常量id
     */
    private Integer constId;

    /**
     * 所属项目id
     */
    private Integer projectId;

    /**
     * 常量名
     */
    private String constName;

    /**
     * 常量备注
     */
    private String constRemark;

    /**
     * 常量值字段类型：整型或字符串
     */
    private Integer constType;

    /**
     * 常量值列表
     */
    @JsonIgnore
    private transient List<MetaConstDetailPO> detailList;

    public void addDetail(MetaConstDetailPO metaConstDetailPO) {
        if (detailList == null) {
            detailList = new ArrayList<>();
        }
        detailList.add(metaConstDetailPO);
    }

    public List<MetaConstDetailPO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<MetaConstDetailPO> detailList) {
        this.detailList = detailList;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getConstType() {
        return constType;
    }

    public void setConstType(Integer constType) {
        this.constType = constType;
    }

    public String getConstRemark() {
        return constRemark;
    }

    public void setConstRemark(String constRemark) {
        this.constRemark = constRemark;
    }

    public Integer getConstId() {
        return constId;
    }

    public void setConstId(Integer constId) {
        this.constId = constId;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName = constName;
    }

}
