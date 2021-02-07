package com.chinapost.devp.generate.web.rest.team;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.pojo.vo.OptionVO;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.dto.team.ProjectTeamAddDTO;
import com.chinapost.devp.generate.pojo.dto.team.ProjectTeamUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.team.ProjectTeamMapper;
import com.chinapost.devp.generate.pojo.po.team.ProjectTeamPO;
import com.chinapost.devp.generate.pojo.qo.team.ProjectTeamOptionQO;
import com.chinapost.devp.generate.pojo.qo.team.ProjectTeamQO;
import com.chinapost.devp.generate.pojo.vo.team.ProjectTeamListVO;
import com.chinapost.devp.generate.pojo.vo.team.ProjectTeamShowVO;
import com.chinapost.devp.generate.service.team.ProjectTeamMemberService;
import com.chinapost.devp.generate.service.team.ProjectTeamService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.team.ProjectTeamAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * 【项目组】控制器
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/project_team")
public class ProjectTeamController extends AbstractController implements ProjectTeamAPI {

    @Autowired
    private ProjectTeamService projectTeamService;
    @Autowired
    private ProjectTeamMemberService projectTeamMemberService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProjectTeamShowVO> save(@Valid @RequestBody ProjectTeamAddDTO projectTeamAddDTO) throws Exception {
        ProjectTeamPO projectTeam = projectTeamService.save(projectTeamAddDTO);
        return ResponseEntity.created(new URI(apiPath + "/project_team/" + projectTeam.getTeamId()))
            .body(ProjectTeamMapper.INSTANCE.toShowVO(projectTeam));
    }

    @Override
    @PutMapping
    public ResponseEntity<ProjectTeamShowVO> update(@Valid @RequestBody ProjectTeamUpdateDTO projectTeamUpdateDTO) {
        // 校验用户操作权限
        this.projectTeamService.checkTeamOperatePermissions(
            projectTeamUpdateDTO.getTeamId(), this.loginContext.getCurrentUser(), true);
        ProjectTeamPO projectTeam = projectTeamService.update(projectTeamUpdateDTO);
        return ResponseEntity.ok(ProjectTeamMapper.INSTANCE.toShowVO(projectTeam));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProjectTeamListVO>> list(@Valid ProjectTeamQO projectTeamQO) {
        String currentUser = loginContext.getCurrentUser();
        // 封装当前用户
        projectTeamQO.set_creator(currentUser);
        // 封装当前用户所在的项目组id
        List<Integer> teamIds = projectTeamMemberService.findUserTeamIds(currentUser);
        projectTeamQO.set_teamId(teamIds);
        List<ProjectTeamListVO> list = projectTeamService.list(projectTeamQO);
        return ResponseEntity.ok(list);
    }

    @Override
    @GetMapping(value = "/options")
    public ResponseEntity<List<OptionVO<Integer, String>>> findOptions(ProjectTeamOptionQO qo) {
        String currentUser = loginContext.getCurrentUser();
        // 封装当前用户
        qo.set_creator(currentUser);
        // 封装当前用户所在的项目组id
        List<Integer> teamIds = projectTeamMemberService.findUserTeamIds(currentUser);
        qo.set_teamId(teamIds);
        List<OptionVO<Integer, String>> options = projectTeamService.findOptions(qo);
        return ResponseEntity.ok(options);
    }

    @Override
    @GetMapping(value = "/{teamId}")
    public ResponseEntity<ProjectTeamShowVO> show(@PathVariable Integer teamId) {
        ProjectTeamShowVO projectTeamShowVO = projectTeamService.show(teamId);
        return ResponseEntity.ok(projectTeamShowVO);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] id) {
        if (ArrayUtils.isEmpty(id)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        for (Integer i : id) {
            // 校验用户操作权限
            this.projectTeamService.checkTeamOperatePermissions(
                i, this.loginContext.getCurrentUser(), false);
        }
        int count = projectTeamService.delete(id);
        return ResponseEntity.ok(count);
    }

}


