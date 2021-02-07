package com.chinapost.devp.generate.pojo.qo.db;

import com.chinapost.devp.common.pojo.qo.PageQO;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import static com.chinapost.devp.generate.pojo.example.db.ProjectDbExample.*;

/**
 * 查询【数据源配置】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectDbQO extends PageQO {

    @ApiParam(value = N_PROJECT_ID, example = E_PROJECT_ID)
    private Integer projectId;

    @ApiParam(value = N_DB_CONNECT_NAME, example = E_DB_CONNECT_NAME)
    @Length(max = 32, message = "dbConnectName最大长度不能超过{max}")
    private String dbConnectName;

    @ApiParam(value = N_DIALECT_NAME, example = E_DIALECT_NAME)
    @Length(max = 16, message = "dialectName最大长度不能超过{max}")
    private String dialectName;

    @ApiParam(value = N_DB_HOST, example = E_DB_HOST)
    @Length(max = 128, message = "dbHost最大长度不能超过{max}")
    private String dbHost;

    @ApiParam(value = N_DB_PORT, example = E_DB_PORT)
    private Integer dbPort;

    @ApiParam(value = N_DB_NAME, example = E_DB_NAME)
    @Length(max = 32, message = "dbName最大长度不能超过{max}")
    private String dbName;

    @ApiParam(value = N_DB_USER, example = E_DB_USER)
    @Length(max = 32, message = "dbUser最大长度不能超过{max}")
    private String dbUser;

    @ApiParam(value = N_DB_PASSWORD, example = E_DB_PASSWORD)
    @Length(max = 32, message = "dbPassword最大长度不能超过{max}")
    private String dbPassword;

    @ApiParam(value = N_IS_SAVE_PASSWORD, example = E_IS_SAVE_PASSWORD)
    private Integer isSavePassword;

    @ApiParam(value = "排序号排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer orderNoSortSign;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer operatedTimeSortSign;


}

