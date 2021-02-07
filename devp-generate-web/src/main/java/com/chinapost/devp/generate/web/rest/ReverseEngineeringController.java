package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.ReverseEngineeringDTO;
import com.chinapost.devp.generate.service.ReverseEngineeringService;
import com.chinapost.devp.generate.web.api.ReverseEngineeringAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * 【反向工程】控制器
 * <p> 通过SQL生成实体及字段
 *
 * @author: cpit
 * @date: 2020/03/17
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/reverse_engineering")
public class ReverseEngineeringController implements ReverseEngineeringAPI {

    @Autowired
    private ReverseEngineeringService reverseEngineeringService;


    @Override
    @PostMapping(value = "/check")
    public void check(@Valid @RequestBody ReverseEngineeringDTO dto) {
        reverseEngineeringService.parse(dto);
    }

    @Override
    @PostMapping(value = "/execute")
    public void execute(@Valid @RequestBody ReverseEngineeringDTO dto) {
        reverseEngineeringService.execute(dto);
    }
}


