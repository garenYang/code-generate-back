
package com.chinapost.devp.generate.web.rest.chart;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.chart.source.MetaChartSourceAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.MetaChartSourceUpdateDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.MetaChartSourceWithItemsAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.MetaChartSourceWithItemsUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartSourceMapper;
import com.chinapost.devp.generate.pojo.po.chart.source.MetaChartSourcePO;
import com.chinapost.devp.generate.pojo.vo.chart.source.MetaChartSourceShowVO;
import com.chinapost.devp.generate.pojo.vo.chart.source.MetaChartSourceWithItemsShowVO;
import com.chinapost.devp.generate.service.chart.source.MetaChartSourceService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.chart.MetaChartSourceAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

/**
 * 【图表数据源】控制器
 *
 * @author: cpit
 * @date: 2020/04/04
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/meta_chart_source")
public class MetaChartSourceController extends AbstractController implements MetaChartSourceAPI {

    @Autowired
    private MetaChartSourceService metaChartSourceService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MetaChartSourceShowVO> save(@Valid @RequestBody MetaChartSourceAddDTO metaChartSourceAddDTO) throws Exception {
        MetaChartSourcePO metaChartSource = metaChartSourceService.save(metaChartSourceAddDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_chart_source/" + metaChartSource.getSourceId()))
            .body(MetaChartSourceMapper.INSTANCE.toShowVO(metaChartSource));
    }

    @Override
    @PutMapping
    public ResponseEntity<MetaChartSourceShowVO> update(@Valid @RequestBody MetaChartSourceUpdateDTO metaChartSourceUpdateDTO) {
        MetaChartSourcePO metaChartSource = metaChartSourceService.update(metaChartSourceUpdateDTO);
        return ResponseEntity.ok(MetaChartSourceMapper.INSTANCE.toShowVO(metaChartSource));
    }

    @Override
    @PostMapping(value = "/with_items")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MetaChartSourceShowVO> saveWithItems(@Valid @RequestBody MetaChartSourceWithItemsAddDTO addDTO) throws Exception {
        MetaChartSourcePO metaChartSource = metaChartSourceService.saveWithItems(addDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_chart_source/" + metaChartSource.getSourceId()))
            .body(MetaChartSourceMapper.INSTANCE.toShowVO(metaChartSource));
    }

    @Override
    @PutMapping(value = "/with_items")
    public ResponseEntity<MetaChartSourceShowVO> updateWithItems(@Valid @RequestBody MetaChartSourceWithItemsUpdateDTO updateDTO) {
        MetaChartSourcePO metaChartSource = metaChartSourceService.updateWithItems(updateDTO);
        return ResponseEntity.ok(MetaChartSourceMapper.INSTANCE.toShowVO(metaChartSource));
    }

    @Override
    @GetMapping(value = "/{sourceId}")
    public ResponseEntity<MetaChartSourceShowVO> show(@PathVariable Integer sourceId) {
        MetaChartSourceShowVO metaChartSourceShowVO = metaChartSourceService.show(sourceId);
        return ResponseEntity.ok(metaChartSourceShowVO);
    }

    @Override
    @GetMapping(value = "/{sourceId}/with_items")
    public ResponseEntity<MetaChartSourceWithItemsShowVO> showWithItems(@PathVariable Integer sourceId) {
        MetaChartSourceWithItemsShowVO vo = metaChartSourceService.showWithItems(sourceId);
        return ResponseEntity.ok(vo);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] id) {
        if(ArrayUtils.isEmpty(id)){
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = metaChartSourceService.delete(id);
        return ResponseEntity.ok(count);
    }

}


