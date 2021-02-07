package com.chinapost.devp.generate.pojo.dto.db;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.db.ProjectDbExample.*;

/**
 * 修改【数据源配置】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "修改【数据源配置】的参数")
public class ProjectDbUpdateDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_ID, example = E_ID, required = true)
    @NotNull
    private Long id;

    @ApiModelProperty(notes = N_PROJECT_ID, example = E_PROJECT_ID, required = true)
    @NotNull
    private Integer projectId;

    @ApiModelProperty(notes = N_DB_CONNECT_NAME, example = E_DB_CONNECT_NAME, required = true)
    @NotNull
    @Length(max = 32)
    private String dbConnectName;

    @ApiModelProperty(notes = N_DIALECT_NAME, example = E_DIALECT_NAME, required = true)
    @NotNull
    @Length(max = 16)
    private String dialectName;

    @ApiModelProperty(notes = N_DB_HOST, example = E_DB_HOST, required = true)
    @NotNull
    @Length(max = 128)
    private String dbHost;

    @ApiModelProperty(notes = N_DB_PORT, example = E_DB_PORT, required = true)
    @NotNull
    private Integer dbPort;

    @ApiModelProperty(notes = N_DB_NAME, example = E_DB_NAME, required = true)
    @NotNull
    @Length(max = 32)
    private String dbName;

    @ApiModelProperty(notes = N_DB_USER, example = E_DB_USER, required = true)
    @NotNull
    @Length(max = 32)
    private String dbUser;

    @ApiModelProperty(notes = N_DB_PASSWORD, example = E_DB_PASSWORD, required = true)
    @NotNull
    @Length(max = 32)
    private String dbPassword;

    @ApiModelProperty(notes = N_IS_SAVE_PASSWORD, example = E_IS_SAVE_PASSWORD, required = true)
    @NotNull
    private Integer isSavePassword;

    @ApiModelProperty(notes = N_ORDER_NO, example = E_ORDER_NO, required = true)
    @NotNull
    private Integer orderNo;


}

