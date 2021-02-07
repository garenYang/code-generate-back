package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.generate.config.GenerateProperties;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.UserSettingUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.UserSettingMapper;
import com.chinapost.devp.generate.pojo.po.UserSettingPO;
import com.chinapost.devp.generate.pojo.vo.SystemUserInfoVO;
import com.chinapost.devp.generate.pojo.vo.UserSettingShowVO;
import com.chinapost.devp.generate.service.CodeTemplateService;
import com.chinapost.devp.generate.service.UserSettingService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.SystemUserAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统用户信息控制器
 *
 * @author: cpit
 * @date: 2020/10/23
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/system_user")
public class SystemUserController extends AbstractController implements SystemUserAPI {

    @Autowired
    private GenerateProperties generateProperties;
    @Autowired
    private CodeTemplateService codeTemplateService;
    @Autowired
    private UserSettingService userSettingService;

    @Override
    @PutMapping(value = "/setting")
    public ResponseEntity<UserSettingShowVO> updateSetting(@Valid @RequestBody UserSettingUpdateDTO userSettingUpdateDTO) {
        String currentUser = loginContext.getCurrentUser();
        userSettingUpdateDTO.setUsername(currentUser);
        UserSettingPO userSetting = userSettingService.update(userSettingUpdateDTO);
        return ResponseEntity.ok(UserSettingMapper.INSTANCE.toShowVO(userSetting));
    }

    @Override
    @GetMapping(value = "/info")
    public ResponseEntity<SystemUserInfoVO> info() {
        String currentUser = loginContext.getCurrentUser();
        UserSettingPO userSetting = userSettingService.getUserSettingByUsername(currentUser, true);
        SystemUserInfoVO vo = new SystemUserInfoVO();
        vo.setId(userSetting.getId());
        vo.setUsername(currentUser);
        vo.setTemplateEnabled(userSetting.getTemplateEnabled());
        vo.setSysVersion(generateProperties.getVersion());
        vo.setTemplateExists(codeTemplateService.exists());
        vo.setTeamEnabled(generateProperties.isTeamEnabled());
        return ResponseEntity.ok(vo);
    }

}
