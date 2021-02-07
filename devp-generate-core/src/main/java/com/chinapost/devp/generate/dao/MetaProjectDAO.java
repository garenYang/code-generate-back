package com.chinapost.devp.generate.dao;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【项目】数据库操作
 *
 * @author: cpit
 * @date: 2020/5/24
 */
@Repository
@Mapper
public interface MetaProjectDAO extends DAO<MetaProjectPO> {

    /**
     * 查询某项目的模块列表
     *
     * @param projectId 项目id
     * @return
     */
    List<String> findModules(Integer projectId);


}
