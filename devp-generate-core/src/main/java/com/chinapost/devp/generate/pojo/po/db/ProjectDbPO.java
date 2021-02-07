package com.chinapost.devp.generate.pojo.po.db;

import com.chinapost.devp.common.pojo.po.AbstractPO;
import com.chinapost.devp.common.pojo.po.CreatedOperatedDeletedVersion;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 数据源配置
 * <p>数据源配置信息表
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectDbPO extends AbstractPO implements CreatedOperatedDeletedVersion {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 项目id
     */
    private Integer projectId;

    /**
     * 数据库连接名
     */
    private String dbConnectName;

    /**
     * 数据库类型
     */
    private String dialectName;

    /**
     * 数据库主机地址
     */
    private String dbHost;

    /**
     * 数据库主机端口
     */
    private Integer dbPort;

    /**
     * 数据库名
     */
    private String dbName;

    /**
     * 数据库登录账号
     */
    private String dbUser;

    /**
     * 数据库登录账号密码
     */
    private String dbPassword;

    /**
     * 是否保存数据登录账号密码
     */
    private Integer isSavePassword;

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

