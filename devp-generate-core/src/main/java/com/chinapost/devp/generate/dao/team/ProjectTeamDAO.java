package com.chinapost.devp.generate.dao.team;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.common.pojo.vo.OptionVO;
import com.chinapost.devp.generate.pojo.po.team.ProjectTeamPO;
import com.chinapost.devp.generate.pojo.qo.team.ProjectTeamOptionQO;
import com.chinapost.devp.generate.pojo.qo.team.ProjectTeamQO;
import com.chinapost.devp.generate.pojo.vo.team.ProjectTeamListVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【项目组】数据库操作
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@Repository
@Mapper
public interface ProjectTeamDAO extends DAO<ProjectTeamPO> {

    /**
     * 根据条件查询【项目组】列表
     *
     * @param projectTeamQO
     * @return
     */
    List<ProjectTeamListVO> findListByQuery(ProjectTeamQO projectTeamQO);

    List<OptionVO<Integer, String>> findOptions(ProjectTeamOptionQO qo);


}



