package com.chinapost.devp.generate.pojo.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.chinapost.devp.common.pojo.dto.AbstractDTO;

/**
 * 抽象excel数据传输对象
 *
 * @author wn
 * @date 2021/01/22
 */
public abstract class AbstractExcelDTO extends AbstractDTO {

    /**
     * 行号
     */
    @ExcelIgnore
    private Integer rowIndex;

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

}

