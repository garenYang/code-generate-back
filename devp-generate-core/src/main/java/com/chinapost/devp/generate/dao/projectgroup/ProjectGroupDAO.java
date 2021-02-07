package com.chinapost.devp.generate.dao.projectgroup;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.projectgroup.ProjectGroupPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 【项目集】数据库操作
 *
 * @author wn
 * @date 2021/01/22
 */
@Repository
@Mapper
public interface ProjectGroupDAO extends DAO<ProjectGroupPO> {


}



