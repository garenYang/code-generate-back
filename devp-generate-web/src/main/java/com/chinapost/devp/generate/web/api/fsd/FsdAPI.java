package com.chinapost.devp.generate.web.api.fsd;

import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.pojo.dto.fsd.FsdAddDTO;
import com.chinapost.devp.generate.pojo.dto.fsd.FsdUpdateDTO;
import com.chinapost.devp.generate.pojo.qo.fsd.FsdQO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdListVO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdShowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 【模块功能点】API
 * <p>swagger接口文档
 *
 * @author wn
 * @date 2021/01/22
 */
@Api(tags = "【模块功能点】API")
public interface FsdAPI {

    /**
     * 新增【模块功能点】
     */
    @ApiOperation(value = "新增【模块功能点】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fsdAddDTO", dataTypeClass = FsdAddDTO.class, value = "新增【模块功能点】参数", paramType = "body"),
    })
    ResponseEntity<FsdShowVO> save(FsdAddDTO fsdAddDTO) throws Exception;

    /**
     * 修改【模块功能点】
     */
    @ApiOperation(value = "修改【模块功能点】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fsdUpdateDTO", dataTypeClass = FsdUpdateDTO.class, value = "修改【模块功能点】参数", paramType = "body"),
    })
    ResponseEntity<FsdShowVO> update(FsdUpdateDTO fsdUpdateDTO);

    /**
     * 分页查询【模块功能点】
     */
    @ApiOperation(value = "分页查询【模块功能点】")
    ResponseEntity<PageVO<FsdListVO>> list(FsdQO fsdQO);

    /**
     * 查看【模块功能点】详情
     */
    @ApiOperation(value = "查看【模块功能点】详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "【模块功能点】id", paramType = "path"),
    })
    ResponseEntity<FsdShowVO> show(String id);

    /**
     * 删除单个【模块功能点】
     */
    @ApiOperation(value = "删除单个【模块功能点】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "【模块功能点】id", paramType = "path"),
    })
    ResponseEntity<Integer> delete(String id);

    /**
     * 批量删除【模块功能点】
     */
    @ApiOperation(value = "批量删除【模块功能点】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "id数组", paramType = "body"),
    })
    ResponseEntity<Integer> deleteBatch(String[] id);

    /**
     * 导出【模块功能点】excel
     */
    @ApiOperation(value = "导出【模块功能点】excel")
    void exportExcel(FsdQO fsdQO, HttpServletResponse response) throws Exception;

    /**
     * 导入【模块功能点】excel
     */
    @ApiOperation(value = "导入【模块功能点】excel")
    ResponseEntity<Integer> importExcel(MultipartFile file) throws Exception;

    /**
     * 下载【模块功能点】excel模板
     */
    @ApiOperation(value = "下载【模块功能点】excel模板")
    void downloadExcelTemplate(HttpServletResponse response) throws Exception;

}

