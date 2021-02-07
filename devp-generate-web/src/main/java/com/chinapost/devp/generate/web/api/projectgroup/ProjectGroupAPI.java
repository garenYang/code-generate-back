package com.chinapost.devp.generate.web.api.projectgroup;

import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupAddDTO;
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupUpdateDTO;
import com.chinapost.devp.generate.pojo.qo.projectgroup.ProjectGroupQO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupListVO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupShowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 【项目集】API
 * <p>swagger接口文档
 *
 * @author wn
 * @date 2021/01/22
 */
@Api(tags = "【项目集】API")
public interface ProjectGroupAPI {

    /**
     * 新增【项目集】
     */
    @ApiOperation(value = "新增【项目集】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectGroupAddDTO", dataTypeClass = ProjectGroupAddDTO.class, value = "新增【项目集】参数", paramType = "body"),
    })
    ResponseEntity<ProjectGroupShowVO> save(ProjectGroupAddDTO projectGroupAddDTO) throws Exception;

    /**
     * 修改【项目集】
     */
    @ApiOperation(value = "修改【项目集】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectGroupUpdateDTO", dataTypeClass = ProjectGroupUpdateDTO.class, value = "修改【项目集】参数", paramType = "body"),
    })
    ResponseEntity<ProjectGroupShowVO> update(ProjectGroupUpdateDTO projectGroupUpdateDTO);

    /**
     * 分页查询【项目集】
     */
    @ApiOperation(value = "分页查询【项目集】")
    ResponseEntity<PageVO<ProjectGroupListVO>> list(ProjectGroupQO projectGroupQO);

    /**
     * 查看【项目集】详情
     */
    @ApiOperation(value = "查看【项目集】详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "【项目集】id", paramType = "path"),
    })
    ResponseEntity<ProjectGroupShowVO> show(String id);

    /**
     * 删除单个【项目集】
     */
    @ApiOperation(value = "删除单个【项目集】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "【项目集】id", paramType = "path"),
    })
    ResponseEntity<Integer> delete(String id);

    /**
     * 批量删除【项目集】
     */
    @ApiOperation(value = "批量删除【项目集】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "id数组", paramType = "body"),
    })
    ResponseEntity<Integer> deleteBatch(String[] id);

    /**
     * 导出【项目集】excel
     */
    @ApiOperation(value = "导出【项目集】excel")
    void exportExcel(ProjectGroupQO projectGroupQO, HttpServletResponse response) throws Exception;

    /**
     * 导入【项目集】excel
     */
    @ApiOperation(value = "导入【项目集】excel")
    ResponseEntity<Integer> importExcel(MultipartFile file) throws Exception;

    /**
     * 下载【项目集】excel模板
     */
    @ApiOperation(value = "下载【项目集】excel模板")
    void downloadExcelTemplate(HttpServletResponse response) throws Exception;

}

