package com.chinapost.devp.generate.web.rest.chart;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.chart.*;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartMapper;
import com.chinapost.devp.generate.pojo.po.chart.*;
import com.chinapost.devp.generate.pojo.qo.chart.MetaChartQO;
import com.chinapost.devp.generate.pojo.vo.chart.*;
import com.chinapost.devp.generate.pojo.vo.chart.TreeVO;
import com.chinapost.devp.generate.service.chart.*;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.chart.MetaChartAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * 【图表】控制器
 *
 * @author: cpit
 * @date: 2020/04/04
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/meta_chart")
public class MetaChartController extends AbstractController implements MetaChartAPI {


    @Autowired
    private MetaChartService metaChartService;
    @Autowired
    private AggTableService aggTableService;
    @Autowired
    private DetailListService detailListService;
    @Autowired
    private BarLineService barLineService;
    @Autowired
    private PieService pieService;
    @Autowired
    private TreeService treeService;

    @Override
    @PostMapping("/agg_table")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AggTableVO> saveAggTable(@Valid @RequestBody AggTableAddDTO addDTO) throws Exception {
        AggTablePO po = aggTableService.save(addDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_chart/agg_table/" + po.getChartId()))
            .body(MetaChartMapper.INSTANCE.toAggTableVO(po));
    }

    @Override
    @PutMapping("/agg_table")
    public ResponseEntity<AggTableVO> updateAggTable(@Valid @RequestBody AggTableUpdateDTO updateDTO) {
        AggTablePO po = aggTableService.update(updateDTO);
        return ResponseEntity.ok(MetaChartMapper.INSTANCE.toAggTableVO(po));
    }

    @Override
    @GetMapping("/agg_table/{chartId}")
    public ResponseEntity<AggTableVO> showAggTable(@PathVariable Integer chartId) {
        AggTableVO vo = aggTableService.show(chartId);
        return ResponseEntity.ok(vo);
    }

    @Override
    @PostMapping("/detail_list")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DetailListVO> saveDetailList(@Valid @RequestBody DetailListAddDTO addDTO) throws Exception {
        DetailListPO po = detailListService.save(addDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_chart/detail_list/" + po.getChartId()))
            .body(MetaChartMapper.INSTANCE.toDetailListVO(po));
    }

    @Override
    @PutMapping("/detail_list")
    public ResponseEntity<DetailListVO> updateDetailList(@Valid @RequestBody DetailListUpdateDTO updateDTO) {
        DetailListPO po = detailListService.update(updateDTO);
        return ResponseEntity.ok(MetaChartMapper.INSTANCE.toDetailListVO(po));
    }

    @Override
    @GetMapping("/detail_list/{chartId}")
    public ResponseEntity<DetailListVO> showDetailList(@PathVariable Integer chartId) {
        DetailListVO vo = detailListService.show(chartId);
        return ResponseEntity.ok(vo);
    }


    @Override
    @PostMapping("/bar_line")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BarLineVO> saveBarLine(@Valid @RequestBody BarLineAddDTO addDTO) throws Exception {
        BarLinePO po = barLineService.save(addDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_chart/bar_line/" + po.getChartId()))
            .body(MetaChartMapper.INSTANCE.toBarLineVO(po));
    }

    @Override
    @PutMapping("/bar_line")
    public ResponseEntity<BarLineVO> updateBarLine(@Valid @RequestBody BarLineUpdateDTO updateDTO) {
        BarLinePO po = barLineService.update(updateDTO);
        return ResponseEntity.ok(MetaChartMapper.INSTANCE.toBarLineVO(po));
    }

    @Override
    @GetMapping("/bar_line/{chartId}")
    public ResponseEntity<BarLineVO> showBarLine(@PathVariable Integer chartId) {
        BarLineVO vo = barLineService.show(chartId);
        return ResponseEntity.ok(vo);
    }

    @Override
    @PostMapping("/pie")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PieVO> savePie(@Valid @RequestBody PieAddDTO addDTO) throws Exception {
        PiePO po = pieService.save(addDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_chart/pie/" + po.getChartId()))
            .body(MetaChartMapper.INSTANCE.toPieVO(po));
    }

    @Override
    @PutMapping("/pie")
    public ResponseEntity<PieVO> updatePie(@Valid @RequestBody PieUpdateDTO updateDTO) {
        PiePO po = pieService.update(updateDTO);
        return ResponseEntity.ok(MetaChartMapper.INSTANCE.toPieVO(po));
    }

    @Override
    @GetMapping("/pie/{chartId}")
    public ResponseEntity<PieVO> showPie(@PathVariable Integer chartId) {
        PieVO vo = pieService.show(chartId);
        return ResponseEntity.ok(vo);
    }

    @Override
    @PostMapping("/tree")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TreeVO> saveTree(@Valid @RequestBody TreeAddDTO addDTO) throws Exception {
        TreePO po = treeService.save(addDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_chart/tree/" + po.getChartId()))
                .body(MetaChartMapper.INSTANCE.toTreeVO(po));
    }

    @Override
    @GetMapping("/tree/{chartId}")
    public ResponseEntity<TreeVO> showTree(Integer chartId) {
        TreeVO vo = treeService.show(chartId);
        return ResponseEntity.ok(vo);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MetaChartListVO>> list(@Valid MetaChartQO metaChartQO) {
        List<MetaChartListVO> list = metaChartService.list(metaChartQO);
        return ResponseEntity.ok(list);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] id) {
        if(ArrayUtils.isEmpty(id)){
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = metaChartService.delete(id);
        return ResponseEntity.ok(count);
    }


}
