package com.chinapost.devp.generate.template.context.chart;

import com.chinapost.devp.generate.pojo.dto.chart.ChartItemDTO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.DetailListPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.DetailColumnPO;

import java.util.List;

/**
 * 明细表上下文对象
 *
 * @author: cpit
 * @date: 2020-04-12
 */
public class DetailListContext extends AbstractChartContext<DetailListPO> {

    /**
     * 明细列
     */
    private final List<ChartItemDTO<DetailColumnPO>> columnList;
    /**
     * 默认每页记录数
     */
    private final Integer defaultPageSize;
    /**
     * 是否支持excel导出
     */
    private final Boolean excelExport;

    public DetailListContext(MetaProjectPO project, DetailListPO detailList) {
        super(project, detailList);
        this.columnList = detailList.getColumnList();
        this.defaultPageSize = detailList.getDefaultPageSize();
        this.excelExport = detailList.getExcelExport();
    }

    public List<ChartItemDTO<DetailColumnPO>> getColumnList() {
        return columnList;
    }

    public Integer getDefaultPageSize() {
        return defaultPageSize;
    }

    public Boolean getExcelExport() {
        return excelExport;
    }
}
