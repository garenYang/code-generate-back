package com.chinapost.devp.generate.service.team;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.dao.team.ProjectTeamDAO;
import com.chinapost.devp.generate.dao.team.ProjectTeamMemberDAO;
import com.chinapost.devp.generate.pojo.dto.team.ProjectTeamMemberAddDTO;
import com.chinapost.devp.generate.pojo.mapper.team.ProjectTeamMemberMapper;
import com.chinapost.devp.generate.pojo.po.team.ProjectTeamMemberPO;
import com.chinapost.devp.generate.pojo.qo.team.ProjectTeamMemberQO;
import com.chinapost.devp.generate.pojo.vo.team.ProjectTeamMemberListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 【项目组成员】增删改查服务
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@Service
public class ProjectTeamMemberService {

    @Autowired
    private ProjectTeamDAO projectTeamDAO;
    @Autowired
    private ProjectTeamMemberDAO projectTeamMemberDAO;


    /**
     * 批量新增【项目组成员】
     *
     * @param addDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int saveBatch(ProjectTeamMemberAddDTO addDTO) {
        if (addDTO.getTeamId() != null) {
            Assert.isTrue(projectTeamDAO.exist(addDTO.getTeamId()), "项目组id有误");
        }
        List<ProjectTeamMemberPO> list = ProjectTeamMemberMapper.INSTANCE.fromAddDTO(addDTO);
        int count = 0;
        for (ProjectTeamMemberPO po : list) {
            if (projectTeamMemberDAO.checkExist(po.getTeamId(), po.getUsername())) {
                continue;
            }
            projectTeamMemberDAO.save(po);
            count++;
        }
        return count;
    }

    /**
     * 新增单个【项目组成员】
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public ProjectTeamMemberPO save(Integer teamId, String username) {
        ProjectTeamMemberPO po = new ProjectTeamMemberPO();
        po.setTeamId(teamId);
        po.setUsername(username);
        projectTeamMemberDAO.save(po);
        return po;
    }

    /**
     * 查询列表
     *
     * @param projectTeamMemberQO
     * @return
     */
    public List<ProjectTeamMemberListVO> list(ProjectTeamMemberQO projectTeamMemberQO) {
        List<ProjectTeamMemberListVO> list = projectTeamMemberDAO.findListByQuery(projectTeamMemberQO);
        return list;
    }

    /**
     * 根据主键获取【项目组成员】
     *
     * @param id    主键
     * @param force 是否强制获取
     * @return
     */
    public ProjectTeamMemberPO getProjectTeamMember(Integer id, boolean force) {
        ProjectTeamMemberPO projectTeamMember = projectTeamMemberDAO.findById(id);
        if (force && projectTeamMember == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return projectTeamMember;
    }

    /**
     * 删除【项目组成员】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Integer... ids) {
        int count = 0;
        for (Integer id : ids) {
            count += projectTeamMemberDAO.delete(id);
        }
        return count;
    }


    /**
     * 校验用户是否在项目组中
     *
     * @param teamId
     * @param username
     * @return
     */
    public boolean checkMemberInTeam(Integer teamId, String username) {
        if (teamId == null) {
            return false;
        }
        return projectTeamMemberDAO.checkExist(teamId, username);
    }

    /**
     * 查询用户所在的项目组
     *
     * @param username
     * @return
     */
    public List<Integer> findUserTeamIds(String username) {
        return projectTeamMemberDAO.findTeamIdsByUsername(username);
    }
}


