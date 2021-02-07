package com.chinapost.devp.generate.service.projectgroup;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.common.util.UUIDUtil;
import com.chinapost.devp.generate.dao.projectgroup.ProjectGroupDAO;
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupAddDTO;
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.projectgroup.ProjectGroupMapper;
import com.chinapost.devp.generate.pojo.po.projectgroup.ProjectGroupPO;
import com.chinapost.devp.generate.pojo.qo.projectgroup.ProjectGroupQO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupListVO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupShowVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 【项目集】增删改查服务
 *
 * @author wn
 * @date 2021/01/22
 */
@Service
public class ProjectGroupService {

    @Autowired
    private ProjectGroupDAO projectGroupDAO;


    /**
     * 新增【项目集】
     *
     * @param projectGroupDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public ProjectGroupPO save(ProjectGroupAddDTO projectGroupDTO) {
        ProjectGroupPO projectGroup = ProjectGroupMapper.INSTANCE.fromAddDTO(projectGroupDTO);
        projectGroup.setId(UUIDUtil.getUUID());
        projectGroupDAO.save(projectGroup);
        return projectGroup;
    }

    /**
     * 批量新增【项目集】
     *
     * @param list
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int batchSave(List<ProjectGroupAddDTO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        for (ProjectGroupAddDTO addDTO : list) {
            this.save(addDTO);
        }
        return list.size();
    }

    /**
     * 修改【项目集】
     *
     * @param projectGroupUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public ProjectGroupPO update(ProjectGroupUpdateDTO projectGroupUpdateDTO) {
        String id = projectGroupUpdateDTO.getId();
        ProjectGroupPO projectGroup = this.getProjectGroup(id, true);
        ProjectGroupMapper.INSTANCE.setUpdateDTO(projectGroup, projectGroupUpdateDTO);
        projectGroupDAO.update(projectGroup);
        return projectGroup;
    }

    /**
     * 查询分页列表
     *
     * @param projectGroupQO
     * @return
     */
    public PageVO<ProjectGroupListVO> list(ProjectGroupQO projectGroupQO) {
        PageVO<ProjectGroupListVO> page = projectGroupDAO.findByPage(projectGroupQO);
        return page;
    }

    /**
     * 根据主键获取【项目集】
     *
     * @param id 主键
     * @param force 是否强制获取
     * @return
     */
    public ProjectGroupPO getProjectGroup(String id, boolean force) {
        ProjectGroupPO projectGroup = projectGroupDAO.findById(id);
        if (force && projectGroup == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return projectGroup;
    }


    /**
     * 查询【项目集】详情
     *
     * @param id
     * @return
     */
    public ProjectGroupShowVO show(String id) {
        ProjectGroupPO projectGroup = this.getProjectGroup(id, true);
        ProjectGroupShowVO showVO = ProjectGroupMapper.INSTANCE.toShowVO(projectGroup);
        return showVO;
    }

    /**
     * 删除【项目集】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(String... ids) {
        int count = 0;
        for (String id : ids) {
            count += projectGroupDAO.delete(id);
        }
        return count;
    }


}


