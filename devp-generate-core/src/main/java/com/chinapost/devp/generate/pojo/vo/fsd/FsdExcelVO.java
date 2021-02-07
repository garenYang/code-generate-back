package com.chinapost.devp.generate.pojo.vo.fsd;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.chinapost.devp.generate.excel.converter.LocalDateTimeConverter;

import java.time.LocalDateTime;

/**
 * 【模块功能点】excel导出对象
 *
 * @author wn
 * @date 2021/01/22
 */
public class FsdExcelVO extends AbstractVO {

    @ExcelProperty("主键")
    @ColumnWidth(12)
    private String id;

    @ExcelProperty("功能名称")
    @ColumnWidth(15)
    private String functionName;

    @ExcelProperty("功能描述")
    @ColumnWidth(15)
    private String functionDesc;

    @ExcelProperty("功能点开发状态")
    @ColumnWidth(15)
    private Integer status;

    @ExcelProperty(value = "创建时间", converter = LocalDateTimeConverter.class)
    @ColumnWidth(25)
    private LocalDateTime createdTime;

    @ExcelProperty(value = "修改时间", converter = LocalDateTimeConverter.class)
    @ColumnWidth(25)
    private LocalDateTime operatedTime;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionDesc() {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getOperatedTime() {
        return this.operatedTime;
    }

    public void setOperatedTime(LocalDateTime operatedTime) {
        this.operatedTime = operatedTime;
    }


}

