package com.chinapost.devp.generate.pojo.po.prd;

import com.chinapost.devp.common.pojo.po.Jsr310CreatedOperatedDeleted;
import com.chinapost.devp.generate.pojo.vo.tree.TreeEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 需求文档管理
 * <p>需求文档管理实体类
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
public class PrdPO extends TreeEntity<PrdPO> implements Jsr310CreatedOperatedDeleted {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 项目ID
     */
    private String projectGroupId;

    /**
     * 父节点ID
     */
    private String parentId;

    /**
     * 父节点ID列表以,隔开
     */
    private String parentIds;

    /**
     * 需求标题
     */
    private String title;

    /**
     * 是否叶子节点（1 叶子节点 0 非叶子节点）
     */
    private Integer leaf;

    /**
     * 节点排序
     */
    private Integer sort;

    /**
     * 需求详情，富文本存储，用来介绍需求的详细内容
     */
    private String content;

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

}

