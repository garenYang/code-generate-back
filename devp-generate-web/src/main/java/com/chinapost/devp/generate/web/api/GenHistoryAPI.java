package com.chinapost.devp.generate.web.api;

import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.pojo.qo.GenHistoryQO;
import com.chinapost.devp.generate.pojo.vo.GenHistoryListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;


/**
 * 【生成历史】API
 * <p>swagger接口文档
 *
 * @author: cpit
 */
@Api(tags = "【生成历史】API")
public interface GenHistoryAPI {

    /**
     * 分页查询【生成历史】
     *
     * @param genHistoryQO
     * @return
     */
    @ApiOperation(value = "分页查询【生成历史】")
    ResponseEntity<PageVO<GenHistoryListVO>> list(GenHistoryQO genHistoryQO);

}

