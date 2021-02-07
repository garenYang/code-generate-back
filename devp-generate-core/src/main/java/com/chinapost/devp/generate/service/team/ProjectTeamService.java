package com.chinapost.devp.generate.service.team;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.common.pojo.vo.OptionVO;
import com.chinapost.devp.generate.dao.team.ProjectTeamDAO;
import com.chinapost.devp.generate.dao.team.ProjectTeamMemberDAO;
import com.chinapost.devp.generate.pojo.dto.team.ProjectTeamAddDTO;
import com.chinapost.devp.generate.pojo.dto.team.ProjectTeamUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.team.ProjectTeamMapper;
import com.chinapost.devp.generate.pojo.po.team.ProjectTeamPO;
import com.chinapost.devp.generate.pojo.qo.team.ProjectTeamOptionQO;
import com.chinapost.devp.generate.pojo.qo.team.ProjectTeamQO;
import com.chinapost.devp.generate.pojo.vo.team.ProjectTeamListVO;
import com.chinapost.devp.generate.pojo.vo.team.ProjectTeamShowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 【项目组】增删改查服务
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@Service
public class ProjectTeamService {

    @Autowired
    private ProjectTeamDAO projectTeamDAO;
    @Autowired
    private ProjectTeamMemberDAO projectTeamMemberDAO;


    /**
     * 新增【项目组】
     *
     * @param projectTeamDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public ProjectTeamPO save(ProjectTeamAddDTO projectTeamDTO) {
        ProjectTeamPO projectTeam = ProjectTeamMapper.INSTANCE.fromAddDTO(projectTeamDTO);
        projectTeamDAO.save(projectTeam);
        return projectTeam;
    }

    /**
     * 修改【项目组】
     *
     * @param projectTeamUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public ProjectTeamPO update(ProjectTeamUpdateDTO projectTeamUpdateDTO) {
        Integer teamId = projectTeamUpdateDTO.getTeamId();
        ProjectTeamPO projectTeam = this.getProjectTeam(teamId, true);
        ProjectTeamMapper.INSTANCE.setUpdateDTO(projectTeam, projectTeamUpdateDTO);
        projectTeamDAO.update(projectTeam);
        return projectTeam;
    }

    /**
     * 查询列表
     *
     * @param projectTeamQO
     * @return
     */
    public List<ProjectTeamListVO> list(ProjectTeamQO projectTeamQO) {
        List<ProjectTeamListVO> list = projectTeamDAO.findListByQuery(projectTeamQO);
        return list;
    }

    /**
     * 查询【项目组】选项列表
     *
     * @return
     */
    public List<OptionVO<Integer, String>> findOptions(ProjectTeamOptionQO qo) {
        List<OptionVO<Integer, String>> options = projectTeamDAO.findOptions(qo);
        return options;
    }

    /**
     * 根据主键获取【项目组】
     *
     * @param teamId 主键
     * @param force  是否强制获取
     * @return
     */
    public ProjectTeamPO getProjectTeam(Integer teamId, boolean force) {
        ProjectTeamPO projectTeam = projectTeamDAO.findById(teamId);
        if (force && projectTeam == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return projectTeam;
    }


    /**
     * 查询【项目组】详情
     *
     * @param teamId
     * @return
     */
    public ProjectTeamShowVO show(Integer teamId) {
        ProjectTeamPO projectTeam = this.getProjectTeam(teamId, true);
        ProjectTeamShowVO showVO = ProjectTeamMapper.INSTANCE.toShowVO(projectTeam);
        return showVO;
    }

    /**
     * 删除【项目组】
     *
     * @param teamIds
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Integer... teamIds) {
        int count = 0;
        for (Integer teamId : teamIds) {
            this.checkDeleteByProjectTeamMember(teamId);
            count += projectTeamDAO.delete(teamId);
        }
        return count;
    }

    /**
     * 校验是否存在【项目组成员】关联
     *
     * @param teamId
     */
    private void checkDeleteByProjectTeamMember(Integer teamId) {
        int count = projectTeamMemberDAO.getCountByTeamId(teamId);
        if (count > 0) {
            throw new BusinessException(ErrorCode.CASCADE_DELETE_ERROR);
        }
    }

    /**
     * 校验项目组操作权限
     *
     * @param teamId
     * @param username
     * @param allowMember 是否允许成员操作
     */
    public void checkTeamOperatePermissions(Integer teamId, String username, boolean allowMember) {
        ProjectTeamPO po = this.getProjectTeam(teamId, true);
        // 创建人有操作权限
        if (Objects.equals(po.getCreatedBy(), username)) {
            return;
        }
        if (!allowMember) {
            throw new BusinessException("您无此操作权限");
        }
        if (!projectTeamMemberDAO.checkExist(teamId, username)) {
            throw new BusinessException("您无此操作权限");
        }
    }

}


