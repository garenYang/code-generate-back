package com.chinapost.devp.generate.web.api.db;

import com.chinapost.devp.common.pojo.resp.R;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbAddDTO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbConnectionDTO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbUpdateDTO;
import com.chinapost.devp.generate.pojo.qo.db.ProjectDbQO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 【数据源配置】API
 * <p>swagger接口文档
 *
 * @author wn
 * @date 2021/01/22
 */
@Api(tags = "【数据源配置】API")
public interface ProjectDbAPI {

    /**
     * 新增【数据源配置】
     * @return
     */
    @ApiOperation(value = "新增【数据源配置】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectDbAddDTO", dataTypeClass = ProjectDbAddDTO.class, value = "新增【数据源配置】参数", paramType = "body"),
    })
    R save(ProjectDbAddDTO projectDbAddDTO) throws Exception;

    /**
     * 修改【数据源配置】
     * @return
     */
    @ApiOperation(value = "修改【数据源配置】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectDbUpdateDTO", dataTypeClass = ProjectDbUpdateDTO.class, value = "修改【数据源配置】参数", paramType = "body"),
    })
    R update(ProjectDbUpdateDTO projectDbUpdateDTO);

    /**
     * 分页查询【数据源配置】
     * @return
     */
    @ApiOperation(value = "分页查询【数据源配置】")
    R list(ProjectDbQO projectDbQO);

    /**
     * 查看【数据源配置】详情
     * @return
     */
    @ApiOperation(value = "查看【数据源配置】详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = Long.class, value = "【数据源配置】id", paramType = "path"),
    })
    R show(Long id);

    /**
     * 删除单个【数据源配置】
     * @return
     */
    @ApiOperation(value = "删除单个【数据源配置】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = Long.class, value = "【数据源配置】id", paramType = "path"),
    })
    R delete(Long id);

    /**
     * 批量删除【数据源配置】
     * @return
     */
    @ApiOperation(value = "批量删除【数据源配置】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = Long.class, value = "id数组", paramType = "body"),
    })
    R deleteBatch(Long[] id);


    /**
     * 测试连接【数据源配置】
     * @return
     */
    @ApiOperation(value = "测试连接【数据源配置】")
    R testConnection(ProjectDbConnectionDTO dbConnectionDTO);


    /**
     * 获取数据库表【数据源配置】
     * @return
     */
    @ApiOperation(value = "获取数据库表【数据源配置】")
    R allTable(ProjectDbConnectionDTO dbConnectionDTO);


    /**
     * 生成ddl语句【数据源配置】
     * @return
     */
    @ApiOperation(value = "生成ddl语句【数据源配置】")
    R generateDdl(ProjectDbConnectionDTO dbConnectionDTO);

}

