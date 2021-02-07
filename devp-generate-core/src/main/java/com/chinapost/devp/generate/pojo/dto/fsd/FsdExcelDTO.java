package com.chinapost.devp.generate.pojo.dto.fsd;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.pojo.dto.AbstractExcelDTO;

import static com.chinapost.devp.generate.pojo.example.fsd.FsdExample.*;

/**
 * excel导入【模块功能点】的数据传输对象
 *
 * @author wn
 * @date 2021/01/22
 */
public class FsdExcelDTO extends AbstractExcelDTO {

    @ExcelProperty("功能模块ID*")
    @ColumnWidth(15)
    private String prdId;

    @ExcelProperty("功能名称*")
    @ColumnWidth(15)
    private String functionName;

    @ExcelProperty("功能描述*")
    @ColumnWidth(15)
    private String functionDesc;

    @ExcelProperty("功能点开发状态*")
    @ColumnWidth(15)
    private Integer status;


    /**
     * 创建模板示例
     *
     * @return
     */
    public static FsdExcelDTO example() {
        FsdExcelDTO example = new FsdExcelDTO();
        example.setPrdId(E_PRD_ID);
        example.setFunctionName(E_FUNCTION_NAME);
        example.setFunctionDesc(E_FUNCTION_DESC);
        example.setStatus(SafeUtil.getInteger(E_STATUS));
        return example;
    }

    public String getPrdId() {
        return this.prdId;
    }

    public void setPrdId(String prdId) {
        this.prdId = prdId;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionDesc() {
        return this.functionDesc;
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

}


