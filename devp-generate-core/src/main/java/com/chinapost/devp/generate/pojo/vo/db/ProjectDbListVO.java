package com.chinapost.devp.generate.pojo.vo.db;

import com.chinapost.devp.common.constant.JsonFieldConst;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import static com.chinapost.devp.generate.pojo.example.db.ProjectDbExample.*;

/**
 * 【数据源配置】列表展示对象
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "【数据源配置】列表展示对象")
public class ProjectDbListVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private Long id;

    @ApiModelProperty(notes = N_PROJECT_ID, example = E_PROJECT_ID)
    private Integer projectId;

    @ApiModelProperty(notes = N_DB_CONNECT_NAME, example = E_DB_CONNECT_NAME)
    private String dbConnectName;

    @ApiModelProperty(notes = N_DIALECT_NAME, example = E_DIALECT_NAME)
    private String dialectName;

    @ApiModelProperty(notes = N_DB_HOST, example = E_DB_HOST)
    private String dbHost;

    @ApiModelProperty(notes = N_DB_PORT, example = E_DB_PORT)
    private Integer dbPort;

    @ApiModelProperty(notes = N_DB_NAME, example = E_DB_NAME)
    private String dbName;

    @ApiModelProperty(notes = N_DB_USER, example = E_DB_USER)
    private String dbUser;

    @ApiModelProperty(notes = N_DB_PASSWORD, example = E_DB_PASSWORD)
    private String dbPassword;

    @ApiModelProperty(notes = N_IS_SAVE_PASSWORD, example = E_IS_SAVE_PASSWORD)
    private Integer isSavePassword;

    @ApiModelProperty(notes = N_ORDER_NO, example = E_ORDER_NO)
    private Integer orderNo;

    @ApiModelProperty(notes = N_CREATED_TIME, example = E_CREATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(notes = N_OPERATED_TIME, example = E_OPERATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date operatedTime;


}

