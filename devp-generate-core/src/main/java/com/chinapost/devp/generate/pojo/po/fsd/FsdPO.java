package com.chinapost.devp.generate.pojo.po.fsd;

import com.chinapost.devp.common.pojo.po.AbstractPO;
import com.chinapost.devp.common.pojo.po.Jsr310CreatedOperatedDeleted;

import java.time.LocalDateTime;

/**
 * 模块功能点
 * <p>模块功能点管理
 *
 * @author wn
 * @date 2021/01/22
 */
public class FsdPO extends AbstractPO implements Jsr310CreatedOperatedDeleted {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 功能模块ID，对应PrdManage中的module类型节点的ID
     */
    private String prdId;

    /**
     * 功能名称
     */
    private String functionName;

    /**
     * 功能点描述
     */
    private String functionDesc;

    /**
     * 功能点开发状态（0：未开始；1：开发中；2：测试中；3：已完成）
     */
    private Integer status;

    /**
     * 创建时间【yyyy-MM-dd HH:mm:ss】
     */
    private LocalDateTime createdTime;

    /**
     * 创建人【最大长度20】
     */
    private String createdBy;

    /**
     * 修改时间【yyyy-MM-dd HH:mm:ss】
     */
    private LocalDateTime operatedTime;

    /**
     * 修改人【最大长度20】
     */
    private String operatedBy;

    /**
     * 逻辑删除标识【0-未删除，1-已删除】
     */
    private Boolean deleted;

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

    @Override
    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    @Override
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public LocalDateTime getOperatedTime() {
        return this.operatedTime;
    }

    @Override
    public void setOperatedTime(LocalDateTime operatedTime) {
        this.operatedTime = operatedTime;
    }

    @Override
    public String getOperatedBy() {
        return this.operatedBy;
    }

    @Override
    public void setOperatedBy(String operatedBy) {
        this.operatedBy = operatedBy;
    }

    @Override
    public Boolean getDeleted() {
        return this.deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}

