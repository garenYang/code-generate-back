package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.LabelType;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.MetaLabelDTO;
import com.chinapost.devp.generate.service.MetaLabelService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.MetaLabelAPI;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 【标签元数据】控制器
 *
 * @author: cpit
 * @date: 2020-09-13
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/meta_label")
public class MetaLabelController extends AbstractController implements MetaLabelAPI {

    @Autowired
    private MetaLabelService metaLabelService;

    @Override
    @GetMapping
    public ResponseEntity<List<MetaLabelDTO>> getMetaLabel(@RequestParam(required = false) Integer projectId,
                                                           @RequestParam(required = false) List<Integer> templateId,
                                                           @RequestParam String labelType) {
        if (!LabelType.check(labelType)) {
            throw new BusinessException(ErrorCode.BAD_REQUEST, "标签类型不存在");
        }
        List<MetaLabelDTO> list = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(templateId)){
            list = metaLabelService.getMetaLabelByTemplateId(templateId, labelType);
        } else if (projectId != null) {
            list = metaLabelService.getMetaLabelByProjectId(projectId, labelType);
        }
        return ResponseEntity.ok(list);
    }

}
