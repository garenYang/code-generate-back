package com.chinapost.devp.generate.pojo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.chinapost.devp.common.pojo.vo.AbstractVO;

/**
 * 【需求列表】excel导出对象
 *
 * @author wn
 * @date 2021/01/22
 */
public class DemandsExcelVO extends AbstractVO {

    @ExcelProperty("主键")
    @ColumnWidth(12)
    private Long id;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

