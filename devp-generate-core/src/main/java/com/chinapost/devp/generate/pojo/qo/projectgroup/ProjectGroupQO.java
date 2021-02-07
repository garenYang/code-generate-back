package com.chinapost.devp.generate.pojo.qo.projectgroup;

import com.chinapost.devp.common.pojo.qo.PageQO;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import static com.chinapost.devp.generate.pojo.example.projectgroup.ProjectGroupExample.*;

/**
 * 查询【项目集】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ProjectGroupQO extends PageQO {

    @ApiParam(value = N_PROJECT_GROUP_NAME, example = E_PROJECT_GROUP_NAME)
    @Length(max = 255, message = "projectGroupName最大长度不能超过{max}")
    private String projectGroupName;

    @ApiParam(value = "立项项目集名称排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer projectGroupNameSortSign;

    @ApiParam(value = "排序号排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer orderNoSortSign;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer createdTimeSortSign;

    @ApiParam(value = "修改时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer operatedTimeSortSign;


}

