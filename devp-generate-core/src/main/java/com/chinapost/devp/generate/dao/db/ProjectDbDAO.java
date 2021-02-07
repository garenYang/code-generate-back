package com.chinapost.devp.generate.dao.db;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.db.ProjectDbPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 【数据源配置】数据库操作
 *
 * @author wn
 * @date 2021/01/22
 */
@Repository
@Mapper
public interface ProjectDbDAO extends DAO<ProjectDbPO> {


}



