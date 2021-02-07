package com.chinapost.devp.generate.excel.handler;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;
import org.apache.poi.ss.usermodel.*;

/**
 * excel模板单元格样式策略
 *
 * @author wn
 * @date 2021/01/22
 */
public class TemplateCellStyleStrategy extends AbstractCellStyleStrategy {

    private final WriteCellStyle headWriteCellStyle;
    private final WriteCellStyle contentWriteCellStyle;

    private CellStyle headCellStyle;
    private CellStyle contentCellStyle;

    public TemplateCellStyleStrategy() {
        // 表头的样式
        headWriteCellStyle = new WriteCellStyle();
        // 表头背景色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setBold(true);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // 内容的样式
        contentWriteCellStyle = new WriteCellStyle();
        contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 内容背景色
        contentWriteCellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
    }

    @Override
    protected void initCellStyle(Workbook workbook) {
        if (headWriteCellStyle != null) {
            headCellStyle = StyleUtil.buildHeadCellStyle(workbook, headWriteCellStyle);
        }
        if (contentWriteCellStyle != null) {
            contentCellStyle = StyleUtil.buildContentCellStyle(workbook, contentWriteCellStyle);
        }
    }

    @Override
    protected void setHeadCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
        if (headCellStyle == null) {
            return;
        }
        cell.setCellStyle(headCellStyle);
    }

    @Override
    protected void setContentCellStyle(Cell cell, Head head, Integer relativeRowIndex) {
        if (contentCellStyle == null) {
            return;
        }
        cell.setCellStyle(contentCellStyle);
    }


}

