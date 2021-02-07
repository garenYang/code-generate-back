package com.chinapost.devp.generate.pojo.qo;

import com.chinapost.devp.common.pojo.qo.AbstractQO;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;

import static com.chinapost.devp.generate.pojo.example.CodeTemplateExample.*;

/**
 * 查询【代码模板】的参数
 *
 * @author: cpit
 * @date: 2020/10/24
 */
public class CodeTemplateQO extends AbstractQO {

    @ApiParam(value = N_CODE, example = E_CODE)
    @Length(max = 32, message = "code最大长度不能超过{max}")
    private String code;

    @ApiParam(value = N_NAME, example = E_NAME)
    @Length(max = 32, message = "name最大长度不能超过{max}")
    private String name;

    @ApiParam(value = N_SYS_DEFAULT, example = E_SYS_DEFAULT)
    private Boolean sysDefault;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer operatedTimeSortSign;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSysDefault() {
        return this.sysDefault;
    }

    public void setSysDefault(Boolean sysDefault) {
        this.sysDefault = sysDefault;
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

