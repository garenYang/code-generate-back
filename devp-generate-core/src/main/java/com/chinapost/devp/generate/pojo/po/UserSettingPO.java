package com.chinapost.devp.generate.pojo.po;

/**
 * 用户配置
 * <p>用户配置
 *
 * @author: cpit
 * @date: 2020/11/08
 */
public class UserSettingPO extends BasePO {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 启用自定义模板
     */
    private Boolean templateEnabled;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getTemplateEnabled() {
        return this.templateEnabled;
    }

    public void setTemplateEnabled(Boolean templateEnabled) {
        this.templateEnabled = templateEnabled;
    }

}

