package com.chinapost.devp.generate.pojo.dto.projectgroup;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.pojo.dto.AbstractExcelDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.chinapost.devp.generate.pojo.example.projectgroup.ProjectGroupExample.*;

/**
 * excel导入【项目集】的数据传输对象
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ProjectGroupExcelDTO extends AbstractExcelDTO {

    @ExcelProperty("立项项目集名称*")
    @ColumnWidth(15)
    private String projectGroupName;

    @ExcelProperty("排序号*")
    @ColumnWidth(12)
    private Integer orderNo;


    /**
     * 创建模板示例
     *
     * @return
     */
    public static ProjectGroupExcelDTO example() {
        ProjectGroupExcelDTO example = new ProjectGroupExcelDTO();
        example.setProjectGroupName(E_PROJECT_GROUP_NAME);
        example.setOrderNo(SafeUtil.getInteger(E_ORDER_NO));
        return example;
    }

}


