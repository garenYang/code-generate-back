package com.chinapost.devp.generate.pojo.vo.prd;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.chinapost.devp.generate.excel.converter.LocalDateTimeConverter;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 【需求文档管理】excel导出对象
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
public class PrdExcelVO extends AbstractVO {

    @ExcelProperty("主键")
    @ColumnWidth(12)
    private String id;

    @ExcelProperty("项目ID")
    @ColumnWidth(15)
    private String projectGroupId;

    @ExcelProperty("父节点ID")
    @ColumnWidth(15)
    private String parentId;

    @ExcelProperty("父节点ID列表")
    @ColumnWidth(15)
    private String parentIds;

    @ExcelProperty("需求文档标题")
    @ColumnWidth(15)
    private String title;

    @ExcelProperty("节点类型")
    @ColumnWidth(15)
    private Integer leaf;

    @ExcelProperty("节点排序")
    @ColumnWidth(15)
    private Integer sort;

    @ExcelProperty(value = "创建时间", converter = LocalDateTimeConverter.class)
    @ColumnWidth(25)
    private LocalDateTime createdTime;

    @ExcelProperty(value = "修改时间", converter = LocalDateTimeConverter.class)
    @ColumnWidth(25)
    private LocalDateTime operatedTime;


}

