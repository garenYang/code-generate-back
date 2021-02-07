package com.chinapost.devp.generate.pojo.po.projectgroup;

import com.chinapost.devp.common.pojo.po.AbstractPO;
import com.chinapost.devp.common.pojo.po.CreatedOperatedDeletedVersion;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 项目集
 * <p>项目集信息表
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ProjectGroupPO extends AbstractPO implements CreatedOperatedDeletedVersion {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 立项项目集名称
     */
    private String projectGroupName;

    /**
     * 排序号【整型】
     */
    private Integer orderNo;

    /**
     * 创建时间【yyyy-MM-dd HH:mm:ss】
     */
    private Date createdTime;

    /**
     * 创建人【最大长度20】
     */
    private String createdBy;

    /**
     * 修改时间【yyyy-MM-dd HH:mm:ss】
     */
    private Date operatedTime;

    /**
     * 修改人【最大长度20】
     */
    private String operatedBy;

    /**
     * 乐观锁版本号【整型】
     */
    private Integer version;

    /**
     * 逻辑删除标识【0-未删除，1-已删除】
     */
    private Boolean deleted;


}

