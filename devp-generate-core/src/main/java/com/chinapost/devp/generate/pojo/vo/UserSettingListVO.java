package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.chinapost.devp.generate.pojo.example.UserSettingExample.*;

/**
 * 【用户配置】列表展示对象
 *
 * @author: cpit
 * @date: 2020/11/08
 */
@ApiModel(description = "【用户配置】列表展示对象")
public class UserSettingListVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private Integer id;

    @ApiModelProperty(notes = N_USERNAME, example = E_USERNAME)
    private String username;

    @ApiModelProperty(notes = N_TEMPLATE_ENABLED, example = E_TEMPLATE_ENABLED)
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

