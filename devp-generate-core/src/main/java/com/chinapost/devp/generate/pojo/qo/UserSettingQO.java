package com.chinapost.devp.generate.pojo.qo;

import com.chinapost.devp.common.pojo.qo.PageQO;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;

import static com.chinapost.devp.generate.pojo.example.UserSettingExample.*;

/**
 * 查询【用户配置】的参数
 *
 * @author: cpit
 * @date: 2020/11/08
 */
public class UserSettingQO extends PageQO {

    @ApiParam(value = N_USERNAME, example = E_USERNAME)
    @Length(max = 32, message = "username最大长度不能超过{max}")
    private String username;

    @ApiParam(value = N_TEMPLATE_ENABLED, example = E_TEMPLATE_ENABLED)
    private Boolean templateEnabled;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer operatedTimeSortSign;


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


    public Integer getCreatedTimeSortSign() {
        return this.createdTimeSortSign;
    }

    public void setCreatedTimeSortSign(Integer createdTimeSortSign) {
        this.createdTimeSortSign = createdTimeSortSign;
    }

    public Integer getOperatedTimeSortSign() {
        return this.operatedTimeSortSign;
    }

    public void setOperatedTimeSortSign(Integer operatedTimeSortSign) {
        this.operatedTimeSortSign = operatedTimeSortSign;
    }

}

