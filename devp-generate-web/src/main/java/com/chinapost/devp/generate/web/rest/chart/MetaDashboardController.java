package com.chinapost.devp.generate.web.rest.chart;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.chart.MetaDashboardAddDTO;
import com.chinapost.devp.generate.pojo.dto.chart.MetaDashboardUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaDashboardMapper;
import com.chinapost.devp.generate.pojo.po.chart.MetaDashboardPO;
import com.chinapost.devp.generate.pojo.qo.chart.MetaDashboardQO;
import com.chinapost.devp.generate.pojo.vo.chart.MetaDashboardListVO;
import com.chinapost.devp.generate.pojo.vo.chart.MetaDashboardShowVO;
import com.chinapost.devp.generate.service.chart.MetaDashboardService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.chart.MetaDashboardAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * 【看板】控制器
 *
 * @author: cpit
 * @date: 2020/06/13
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/meta_dashboard")
public class MetaDashboardController extends AbstractController implements MetaDashboardAPI {

    @Autowired
    private MetaDashboardService metaDashboardService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MetaDashboardShowVO> save(@Valid @RequestBody MetaDashboardAddDTO metaDashboardAddDTO) throws Exception {
        MetaDashboardPO metaDashboard = metaDashboardService.save(metaDashboardAddDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_dashboard/" + metaDashboard.getDashboardId()))
            .body(MetaDashboardMapper.INSTANCE.toShowVO(metaDashboard));
    }

    @Override
    @PutMapping
    public ResponseEntity<MetaDashboardShowVO> update(@Valid @RequestBody MetaDashboardUpdateDTO metaDashboardUpdateDTO) {
        MetaDashboardPO metaDashboard = metaDashboardService.update(metaDashboardUpdateDTO);
        return ResponseEntity.ok(MetaDashboardMapper.INSTANCE.toShowVO(metaDashboard));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MetaDashboardListVO>> list(@Valid MetaDashboardQO metaDashboardQO) {
        List<MetaDashboardListVO> list = metaDashboardService.list(metaDashboardQO);
        return ResponseEntity.ok(list);
    }

    @Override
    @GetMapping(value = "/{dashboardId}")
    public ResponseEntity<MetaDashboardShowVO> show(@PathVariable Integer dashboardId) {
        MetaDashboardShowVO metaDashboardShowVO = metaDashboardService.show(dashboardId);
        return ResponseEntity.ok(metaDashboardShowVO);
    }

    @Override
    @DeleteMapping(value = "/{dashboardId}")
    public ResponseEntity<Integer> delete(@PathVariable Integer dashboardId) {
        int count = metaDashboardService.delete(dashboardId);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] id) {
        if(ArrayUtils.isEmpty(id)){
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = metaDashboardService.delete(id);
        return ResponseEntity.ok(count);
    }

}


