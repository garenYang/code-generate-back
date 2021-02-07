package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModelProperty;

import static com.chinapost.devp.generate.pojo.example.UserSettingExample.*;

/**
 * 系统及用户信息展示对象
 *
 * @author: cpit
 * @date: 2020/10/24
 */
public class SystemUserInfoVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private Integer id;

    @ApiModelProperty(notes = N_TEMPLATE_ENABLED, example = E_TEMPLATE_ENABLED)
    private Boolean templateEnabled;

    @ApiModelProperty(notes = "当前用户", example = "admin")
    private String username;

    @ApiModelProperty(notes = "系统版本", example = "3.0.0")
    private String sysVersion;

    @ApiModelProperty(notes = "系统中存在模板", example = "false")
    private Boolean templateExists;

    @ApiModelProperty(notes = "启用项目组共享功能", example = "false")
    private Boolean teamEnabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTemplateEnabled() {
        return templateEnabled;
    }

    public void setTemplateEnabled(Boolean templateEnabled) {
        this.templateEnabled = templateEnabled;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public Boolean getTemplateExists() {
        return templateExists;
    }

    public void setTemplateExists(Boolean templateExists) {
        this.templateExists = templateExists;
    }

    public Boolean getTeamEnabled() {
        return teamEnabled;
    }

    public void setTeamEnabled(Boolean teamEnabled) {
        this.teamEnabled = teamEnabled;
    }
}
