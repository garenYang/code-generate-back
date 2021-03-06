package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.MetaIndexAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaIndexUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.MetaIndexMapper;
import com.chinapost.devp.generate.pojo.po.MetaIndexPO;
import com.chinapost.devp.generate.pojo.qo.MetaIndexQO;
import com.chinapost.devp.generate.pojo.vo.MetaIndexListVO;
import com.chinapost.devp.generate.pojo.vo.MetaIndexShowVO;
import com.chinapost.devp.generate.service.MetaIndexService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.MetaIndexAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * 【索引】控制器
 * <p> 索引增删改查
 *
 * @author: cpit
 * @date: 2017/5/12
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/meta_index")
public class MetaIndexController extends AbstractController implements MetaIndexAPI {

    @Autowired
    private MetaIndexService metaIndexService;

    @Override
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MetaIndexShowVO> save(@Valid @RequestBody MetaIndexAddDTO metaIndexAddDTO) throws Exception {
        MetaIndexPO metaIndex = metaIndexService.save(metaIndexAddDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_index/" + metaIndex.getIndexId()))
            .body(MetaIndexMapper.INSTANCE.toShowVO(metaIndex));
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<MetaIndexShowVO> update(@Valid @RequestBody MetaIndexUpdateDTO metaIndexUpdateDTO) {
        MetaIndexPO metaIndex = metaIndexService.update(metaIndexUpdateDTO);
        return ResponseEntity.ok(MetaIndexMapper.INSTANCE.toShowVO(metaIndex));
    }

    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<MetaIndexListVO>> list(@Valid MetaIndexQO metaIndexQO) {
        List<MetaIndexListVO> list = metaIndexService.list(metaIndexQO);
        return ResponseEntity.ok(list);
    }

    @Override
    @GetMapping(value = "/{indexId}")
    public ResponseEntity<MetaIndexShowVO> show(@PathVariable Integer indexId) {
        MetaIndexShowVO metaIndexShowVO = metaIndexService.show(indexId);
        return ResponseEntity.ok(metaIndexShowVO);
    }

    @Override
    @DeleteMapping(value = "/{indexId}")
    public ResponseEntity<Integer> delete(@PathVariable Integer indexId) {
        int count = metaIndexService.delete(indexId);
        return ResponseEntity.ok(count);
    }

    @Override
    @PutMapping(value = "/delete_batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] indexId) {
        if (ArrayUtils.isEmpty(indexId)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = metaIndexService.delete(indexId);
        return ResponseEntity.ok(count);
    }

    @Override
    @PutMapping(value = "/{indexId}/remove_field")
    public ResponseEntity<Integer> removeField(@PathVariable Integer indexId, @RequestBody List<Integer> fieldIds) {
        int count = metaIndexService.removeField(indexId, fieldIds);
        return ResponseEntity.ok(count);
    }
}
