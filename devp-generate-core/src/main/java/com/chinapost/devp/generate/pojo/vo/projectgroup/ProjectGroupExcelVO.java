package com.chinapost.devp.generate.pojo.vo.projectgroup;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.chinapost.devp.common.constant.JsonFieldConst;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 【项目集】excel导出对象
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ProjectGroupExcelVO extends AbstractVO {

    @ExcelProperty("主键")
    @ColumnWidth(19)
    private String id;

    @ExcelProperty("立项项目集名称")
    @ColumnWidth(15)
    private String projectGroupName;

    @ExcelProperty("排序号")
    @ColumnWidth(12)
    private Integer orderNo;

    @ExcelProperty("创建时间")
    @DateTimeFormat(JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    @ColumnWidth(25)
    private Date createdTime;

    @ExcelProperty("修改时间")
    @DateTimeFormat(JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    @ColumnWidth(25)
    private Date operatedTime;



}

