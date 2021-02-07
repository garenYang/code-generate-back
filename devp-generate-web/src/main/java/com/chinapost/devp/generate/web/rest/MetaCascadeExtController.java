package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.MetaCascadeExtAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaCascadeExtUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.MetaCascadeExtMapper;
import com.chinapost.devp.generate.pojo.po.MetaCascadeExtPO;
import com.chinapost.devp.generate.pojo.qo.MetaCascadeExtQO;
import com.chinapost.devp.generate.pojo.vo.MetaCascadeExtListVO;
import com.chinapost.devp.generate.pojo.vo.MetaCascadeExtShowVO;
import com.chinapost.devp.generate.service.MetaCascadeExtService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.MetaCascadeExtAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * 【级联扩展】控制器
 * <p> 级联扩展增删改查
 *
 * @author: cpit
 * @date: 2017/5/12
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/meta_cascade_ext")
public class MetaCascadeExtController extends AbstractController implements MetaCascadeExtAPI {

    @Autowired
    private MetaCascadeExtService metaCascadeExtService;

    @Override
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MetaCascadeExtShowVO> save(@Valid @RequestBody MetaCascadeExtAddDTO metaCascadeExtAddDTO) throws Exception {
        MetaCascadeExtPO metaCascadeExtPO = metaCascadeExtService.save(metaCascadeExtAddDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_cascade_ext/" + metaCascadeExtPO.getCascadeExtId()))
            .body(MetaCascadeExtMapper.INSTANCE.toShowVO(metaCascadeExtPO));
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<MetaCascadeExtShowVO> update(@Valid @RequestBody MetaCascadeExtUpdateDTO metaCascadeExtUpdateDTO) {
        MetaCascadeExtPO metaCascadeExtPO = metaCascadeExtService.update(metaCascadeExtUpdateDTO);
        return ResponseEntity.ok(MetaCascadeExtMapper.INSTANCE.toShowVO(metaCascadeExtPO));
    }

    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<MetaCascadeExtListVO>> list(@Valid MetaCascadeExtQO metaCascadeExtQO) {
        List<MetaCascadeExtListVO> list = metaCascadeExtService.list(metaCascadeExtQO);
        return ResponseEntity.ok(list);
    }

    @Override
    @GetMapping(value = "/{cascadeExtId}")
    public ResponseEntity<MetaCascadeExtShowVO> show(@PathVariable Integer cascadeExtId) {
        MetaCascadeExtShowVO metaCascadeExtShowVO = metaCascadeExtService.show(cascadeExtId);
        return ResponseEntity.ok(metaCascadeExtShowVO);
    }

    @Override
    @DeleteMapping(value = "/{cascadeExtId}")
    public ResponseEntity<Integer> delete(@PathVariable Integer cascadeExtId) {
        int count = metaCascadeExtService.delete(cascadeExtId);
        return ResponseEntity.ok(count);
    }

    @Override
    @PutMapping(value = "/delete_batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] cascadeExtId) {
        if (ArrayUtils.isEmpty(cascadeExtId)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = metaCascadeExtService.delete(cascadeExtId);
        return ResponseEntity.ok(count);
    }
}
