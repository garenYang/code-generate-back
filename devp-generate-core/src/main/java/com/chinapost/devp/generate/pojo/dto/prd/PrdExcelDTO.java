package com.chinapost.devp.generate.pojo.dto.prd;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.pojo.dto.AbstractExcelDTO;
import lombok.Data;

import static com.chinapost.devp.generate.pojo.example.prd.PrdExample.*;

/**
 * excel导入【需求文档管理】的数据传输对象
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
public class PrdExcelDTO extends AbstractExcelDTO {

    @ExcelProperty("项目ID*")
    @ColumnWidth(15)
    private String projectGroupId;

    @ExcelProperty("父节点ID*")
    @ColumnWidth(15)
    private String parentId;

    @ExcelProperty("父节点ID列表")
    @ColumnWidth(15)
    private String parentIds;

    @ExcelProperty("需求文档标题*")
    @ColumnWidth(15)
    private String title;

    @ExcelProperty("节点类型*")
    @ColumnWidth(15)
    private Integer leaf;

    @ExcelProperty("节点排序*")
    @ColumnWidth(15)
    private Integer sort;

    @ExcelProperty("需求详情")
    @ColumnWidth(15)
    private String content;


    /**
     * 创建模板示例
     *
     * @return
     */
    public static PrdExcelDTO example() {
        PrdExcelDTO example = new PrdExcelDTO();
        example.setProjectGroupId(N_PROJECT_GROUP_ID);
        example.setParentId(E_PARENT_ID);
        example.setParentIds(E_PARENT_IDS);
        example.setTitle(E_TITLE);
        example.setLeaf(SafeUtil.getInteger(E_LEAF));
        example.setSort(SafeUtil.getInteger(E_SORT));
        example.setContent(E_CONTENT);
        return example;
    }

}


