package com.chinapost.devp.generate.web.api.prd;

import com.chinapost.devp.common.pojo.qo.OptionQO;
import com.chinapost.devp.common.pojo.vo.OptionVO;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.pojo.dto.prd.PrdAddDTO;
import com.chinapost.devp.generate.pojo.dto.prd.PrdUpdateDTO;
import com.chinapost.devp.generate.pojo.qo.prd.PrdQO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdListVO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdShowVO;
import com.chinapost.devp.generate.pojo.vo.tree.TreeNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 【需求文档管理】API
 * <p>swagger接口文档
 *
 * @author wn
 * @date 2021/01/22
 */
@Api(tags = "【需求文档管理】API")
public interface PrdAPI {

    /**
     * 新增【需求文档管理】
     */
    @ApiOperation(value = "新增【需求文档管理】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "prdAddDTO", dataTypeClass = PrdAddDTO.class, value = "新增【需求文档管理】参数", paramType = "body"),
    })
    ResponseEntity<PrdShowVO> save(PrdAddDTO prdAddDTO) throws Exception;

    /**
     * 修改【需求文档管理】
     */
    @ApiOperation(value = "修改【需求文档管理】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "prdUpdateDTO", dataTypeClass = PrdUpdateDTO.class, value = "修改【需求文档管理】参数", paramType = "body"),
    })
    ResponseEntity<PrdShowVO> update(PrdUpdateDTO prdUpdateDTO);

    /**
     * 分页查询【需求文档管理】
     */
    @ApiOperation(value = "分页查询【需求文档管理】")
    ResponseEntity<PageVO<PrdListVO>> list(PrdQO prdQO);

    @ApiOperation(value = "查询【需求文档管理】树")
    ResponseEntity<List<TreeNode>> listTrees(String projectGroupId);

    /**
     * 查询【需求文档管理】选项列表
     */
    @ApiOperation(value = "查询【需求文档管理】选项列表")
    ResponseEntity<List<OptionVO<String, String>>> findOptions(OptionQO<String, String> qo);

    /**
     * 查看【需求文档管理】详情
     */
    @ApiOperation(value = "查看【需求文档管理】详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "【需求文档管理】id", paramType = "path"),
    })
    ResponseEntity<PrdShowVO> show(String id);

    /**
     * 删除单个【需求文档管理】
     */
    @ApiOperation(value = "删除单个【需求文档管理】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "【需求文档管理】id", paramType = "path"),
    })
    ResponseEntity<Integer> delete(String id);

    /**
     * 批量删除【需求文档管理】
     */
    @ApiOperation(value = "批量删除【需求文档管理】")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataTypeClass = String.class, value = "id数组", paramType = "body"),
    })
    ResponseEntity<Integer> deleteBatch(String[] id);

    /**
     * 导出【需求文档管理】excel
     */
    @ApiOperation(value = "导出【需求文档管理】excel")
    void exportExcel(PrdQO prdQO, HttpServletResponse response) throws Exception;

    /**
     * 导入【需求文档管理】excel
     */
    @ApiOperation(value = "导入【需求文档管理】excel")
    ResponseEntity<Integer> importExcel(MultipartFile file) throws Exception;

    /**
     * 下载【需求文档管理】excel模板
     */
    @ApiOperation(value = "下载【需求文档管理】excel模板")
    void downloadExcelTemplate(HttpServletResponse response) throws Exception;

}

