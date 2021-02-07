package com.chinapost.devp.generate.pojo.vo.projectgroup;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.chinapost.devp.generate.pojo.example.projectgroup.ProjectGroupExample.*;

/**
 * 【项目集】详情展示对象
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(description = "【项目集】详情展示对象")
public class ProjectGroupShowVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private String id;

    @ApiModelProperty(notes = N_PROJECT_GROUP_NAME, example = E_PROJECT_GROUP_NAME)
    private String projectGroupName;

    @ApiModelProperty(notes = N_ORDER_NO, example = E_ORDER_NO)
    private Integer orderNo;



}

