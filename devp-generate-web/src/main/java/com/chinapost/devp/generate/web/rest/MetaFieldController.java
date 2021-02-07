package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.GenerateConst;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.MetaFieldAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaFieldUpdateDTO;
import com.chinapost.devp.generate.pojo.dto.MetaFieldUpdateOrderNoDTO;
import com.chinapost.devp.generate.pojo.mapper.MetaFieldMapper;
import com.chinapost.devp.generate.pojo.po.MetaFieldPO;
import com.chinapost.devp.generate.pojo.qo.MetaFieldQO;
import com.chinapost.devp.generate.pojo.vo.MetaFieldListVO;
import com.chinapost.devp.generate.pojo.vo.MetaFieldShowVO;
import com.chinapost.devp.generate.service.MetaFieldService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.MetaFieldAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * 【字段】控制器
 * <p> 字段增删改查
 *
 * @author: cpit
 * @date: 2017/5/12
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/meta_field")
public class MetaFieldController extends AbstractController implements MetaFieldAPI {

    @Autowired
    private MetaFieldService metaFieldService;

    @Override
    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MetaFieldShowVO> save(@Valid @RequestBody MetaFieldAddDTO metaFieldAddDTO) throws Exception {
        if (metaFieldAddDTO.getDefaultValue() == null) {
            metaFieldAddDTO.setDefaultValue(GenerateConst.METAFIELD_NULL_VALUE);
        }
        MetaFieldPO metaFieldPO = metaFieldService.save(metaFieldAddDTO);
        return ResponseEntity.created(new URI(apiPath + "/meta_field/" + metaFieldPO.getFieldId()))
            .body(MetaFieldMapper.INSTANCE.toShowVO(metaFieldPO));
    }

    @Override
    @PutMapping(value = "/update")
    public ResponseEntity<MetaFieldShowVO> update(@Valid @RequestBody MetaFieldUpdateDTO metaFieldUpdateDTO) {
        if (metaFieldUpdateDTO.getDefaultValue() == null) {
            metaFieldUpdateDTO.setDefaultValue(GenerateConst.METAFIELD_NULL_VALUE);
        }
        MetaFieldPO metaFieldPO = metaFieldService.update(metaFieldUpdateDTO);
        return ResponseEntity.ok(MetaFieldMapper.INSTANCE.toShowVO(metaFieldPO));
    }

    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<MetaFieldListVO>> list(@Valid MetaFieldQO metaFieldQO) {
        List<MetaFieldListVO> list = metaFieldService.list(metaFieldQO);
        return ResponseEntity.ok(list);
    }

    @Override
    @GetMapping(value = "/{fieldId}")
    public ResponseEntity<MetaFieldShowVO> show(@PathVariable Integer fieldId) {
        MetaFieldShowVO metaFieldShowVO = metaFieldService.show(fieldId);
        return ResponseEntity.ok(metaFieldShowVO);
    }

    @Override
    @DeleteMapping(value = "/{fieldId}")
    public ResponseEntity<Integer> delete(@PathVariable Integer fieldId) {
        int count = metaFieldService.delete(fieldId);
        return ResponseEntity.ok(count);
    }


    @Override
    @PutMapping(value = "/delete_batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] fieldId) {
        if (ArrayUtils.isEmpty(fieldId)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = metaFieldService.delete(fieldId);
        return ResponseEntity.ok(count);
    }

    @Override
    @PutMapping(value = "/update_order_no")
    public ResponseEntity<Integer> updateOrderNo(@Valid @RequestBody MetaFieldUpdateOrderNoDTO dto) {
        Integer orderNo = metaFieldService.updateOrderNo(dto);
        return ResponseEntity.ok(orderNo);
    }

}
