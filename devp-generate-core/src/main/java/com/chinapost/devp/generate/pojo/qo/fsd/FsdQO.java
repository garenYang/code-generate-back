package com.chinapost.devp.generate.pojo.qo.fsd;

import com.chinapost.devp.common.pojo.qo.PageQO;
import io.swagger.annotations.ApiParam;

import static com.chinapost.devp.generate.pojo.example.fsd.FsdExample.E_STATUS;
import static com.chinapost.devp.generate.pojo.example.fsd.FsdExample.N_STATUS;

/**
 * 查询【模块功能点】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
public class FsdQO extends PageQO {

    @ApiParam(value = N_STATUS, example = E_STATUS)
    private Integer status;

    private String prdId;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer operatedTimeSortSign;


    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPrdId() {
        return prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
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

