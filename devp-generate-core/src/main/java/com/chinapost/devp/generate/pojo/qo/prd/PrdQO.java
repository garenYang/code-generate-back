package com.chinapost.devp.generate.pojo.qo.prd;

import com.chinapost.devp.common.pojo.qo.PageQO;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.List;

import static com.chinapost.devp.generate.pojo.example.prd.PrdExample.*;

/**
 * 查询【需求文档管理】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
public class PrdQO extends PageQO {

    @ApiParam(value = N_PROJECT_GROUP_ID, example = N_PROJECT_GROUP_ID)
    private String projectGroupId;

    @ApiParam(value = N_TITLE)
    private List<String> title;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer operatedTimeSortSign;

}

