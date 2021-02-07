package com.chinapost.devp.generate.web.api;

import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.pojo.dto.DemandsAddDTO;
import com.chinapost.devp.generate.pojo.dto.DemandsUpdateDTO;
import com.chinapost.devp.generate.pojo.qo.DemandsQO;
import com.chinapost.devp.generate.pojo.vo.DemandsListVO;
import com.chinapost.devp.generate.pojo.vo.DemandsShowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 【需求列表】API
 * <p>swagger接口文档
 *
 * @author wn
 * @date 2021/01/22
 */
@Api(tags = "【需求列表】API")
public interface DemandsAPI {

    /**
     * 新增【需求列表】
     */
    @ApiOperation(value = "新增【需求列表】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demandsAddDTO", dataTypeClass = DemandsAddDTO.class, value = "新增【需求列表】参数", paramType = "body"),
    })
    ResponseEntity<DemandsShowVO> save(DemandsAddDTO demandsAddDTO) throws Exception;

    /**
     * 修改【需求列表】
     */
    @ApiOperation(value = "修改【需求列表】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "demandsUpdateDTO", dataTypeClass = DemandsUpdateDTO.class, value = "修改【需求列表】参数", paramType = "body"),
    })
    ResponseEntity<DemandsShowVO> update(DemandsUpdateDTO demandsUpdateDTO);

    /**
     * 分页查询【需求列表】
     */
    @ApiOperation(value = "分页查询【需求列表】")
    ResponseEntity<PageVO<DemandsListVO>> list(DemandsQO demandsQO);

    /**
     * 查看【需求列表】详情
     */
    @ApiOperation(value = "查看【需求列表】详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = Long.class, value = "【需求列表】id", paramType = "path"),
    })
    ResponseEntity<DemandsShowVO> show(Long id);

    /**
     * 删除单个【需求列表】
     */
    @ApiOperation(value = "删除单个【需求列表】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = Long.class, value = "【需求列表】id", paramType = "path"),
    })
    ResponseEntity<Integer> delete(Long id);

    /**
     * 批量删除【需求列表】
     */
    @ApiOperation(value = "批量删除【需求列表】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = Long.class, value = "id数组", paramType = "body"),
    })
    ResponseEntity<Integer> deleteBatch(Long[] id);

    /**
     * 导出【需求列表】excel
     */
    @ApiOperation(value = "导出【需求列表】excel")
    void exportExcel(DemandsQO demandsQO, HttpServletResponse response) throws Exception;

    /**
     * 导入【需求列表】excel
     */
    @ApiOperation(value = "导入【需求列表】excel")
    ResponseEntity<Integer> importExcel(MultipartFile file) throws Exception;

    /**
     * 下载【需求列表】excel模板
     */
    @ApiOperation(value = "下载【需求列表】excel模板")
    void downloadExcelTemplate(HttpServletResponse response) throws Exception;

}

