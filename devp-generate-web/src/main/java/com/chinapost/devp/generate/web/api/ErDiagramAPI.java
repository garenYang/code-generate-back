package com.chinapost.devp.generate.web.api;

import com.chinapost.devp.generate.pojo.vo.ErDiagramVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 实体关系图
 *
 * @author: cpit
 */
@Api(tags = "【实体关系图】API")
public interface ErDiagramAPI {

    /**
     * ER图查看
     *
     * @param projectId 项目id
     * @param entityIds 实体id
     * @return
     */
    @ApiOperation(value = "ER图查看")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "projectId", dataType = "int", value = "项目id", paramType = "query"),
        @ApiImplicitParam(name = "entityIds", dataType = "int", value = "实体id", paramType = "query"),
    })
    ResponseEntity<ErDiagramVO> show(Integer projectId, List<Integer> entityIds);


}
