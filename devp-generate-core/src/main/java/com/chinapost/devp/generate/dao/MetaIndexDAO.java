package com.chinapost.devp.generate.dao;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.MetaIndexPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【索引】数据库操作
 *
 * @author: cpit
 */

@Repository
@Mapper
public interface MetaIndexDAO extends DAO<MetaIndexPO> {


    /**
     * 根据实体id查询索引列表
     *
     * @param entityId
     * @return
     */
    List<MetaIndexPO> findByEntityId(Integer entityId);
}
