package com.chinapost.devp.generate.web.api;

import com.chinapost.devp.generate.pojo.dto.ReverseEngineeringDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 【反向工程】API
 *
 * @author: cpit
 */
@Api(tags = "【反向工程】API")
public interface ReverseEngineeringAPI {

    /**
     * 校验语法
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "校验语法")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", dataType = "ReverseEngineeringDTO", value = "反向工程参数", paramType = "body"),
    })
    void check(ReverseEngineeringDTO dto);

    /**
     * 执行DDL反向工程
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "执行DDL反向工程")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", dataType = "ReverseEngineeringDTO", value = "反向工程参数", paramType = "body"),
    })
    void execute(ReverseEngineeringDTO dto);


}
