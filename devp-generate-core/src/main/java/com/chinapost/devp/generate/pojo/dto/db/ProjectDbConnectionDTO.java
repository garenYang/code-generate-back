package com.chinapost.devp.generate.pojo.dto.db;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.chinapost.devp.generate.pojo.example.db.ProjectDbExample.*;

/**
 * 新增【数据源配置】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "新增【数据源配置】的参数")
public class ProjectDbConnectionDTO extends AbstractDTO {

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

    private List<String> tableNames;

    /**
     * 是否全选 1是  0否
     */
    private Integer selectAll;
}


