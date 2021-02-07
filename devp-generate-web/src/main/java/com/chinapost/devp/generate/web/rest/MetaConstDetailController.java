package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.MetaConstDetailAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaConstDetailUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.MetaConstDetailMapper;
import com.chinapost.devp.generate.pojo.po.MetaConstDetailPO;
import com.chinapost.devp.generate.pojo.qo.MetaConstDetailQO;
import com.chinapost.devp.generate.pojo.vo.MetaConstDetailListVO;
import com.chinapost.devp.generate.pojo.vo.MetaConstDetailShowVO;
import com.chinapost.devp.generate.service.MetaConstDetailService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.MetaConstDetailAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * 【常量值】控制器
 * <p> 常量值增删改查
 *
 * @author: cpit
 * @date: 2020/5/12
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/meta_const_detail")
public class MetaConstDetailController extends AbstractController implements MetaConstDetailAPI {

    @Autowired
    private MetaConstDetailService metaConstDetailService;

    @Override
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MetaConstDetailShowVO> save(@Valid @RequestBody MetaConstDetailAddDTO metaConstDetailAddDTO) throws Exception {
        MetaConstDetailPO metaConstDetailPO = metaConstDetailService.save(metaConstDetailAddDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_const_detail/" + metaConstDetailPO.getConstDetailId()))
            .body(MetaConstDetailMapper.INSTANCE.toShowVO(metaConstDetailPO));
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<MetaConstDetailShowVO> update(@Valid @RequestBody MetaConstDetailUpdateDTO metaConstDetailUpdateDTO) {
        MetaConstDetailPO metaConstDetailPO = metaConstDetailService.update(metaConstDetailUpdateDTO);
        return ResponseEntity.ok(MetaConstDetailMapper.INSTANCE.toShowVO(metaConstDetailPO));
    }

    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<MetaConstDetailListVO>> list(@Valid MetaConstDetailQO metaConstDetailQO) {
        List<MetaConstDetailListVO> list = metaConstDetailService.list(metaConstDetailQO);
        return ResponseEntity.ok(list);
    }

    @Override
    @GetMapping(value = "/lists")
    public ResponseEntity<Map<String,List<MetaConstDetailListVO>>> lists(@Valid MetaConstDetailQO metaConstDetailQO) {
        Map<String,List<MetaConstDetailListVO>> map = metaConstDetailService.lists(metaConstDetailQO);
        return ResponseEntity.ok(map);
    }

    @Override
    @GetMapping(value = "/{constDetailId}")
    public ResponseEntity<MetaConstDetailShowVO> show(@PathVariable Integer constDetailId) {
        MetaConstDetailShowVO metaConstDetailShowVO = metaConstDetailService.show(constDetailId);
        return ResponseEntity.ok(metaConstDetailShowVO);
    }

    @Override
    @DeleteMapping(value = "/{constDetailId}")
    public ResponseEntity<Integer> delete(@PathVariable Integer constDetailId) {
        int count = metaConstDetailService.delete(constDetailId);
        return ResponseEntity.ok(count);
    }

    @Override
    @PutMapping(value = "/delete_batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] constDetailId) {
        if (ArrayUtils.isEmpty(constDetailId)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = metaConstDetailService.delete(constDetailId);
        return ResponseEntity.ok(count);
    }
}
