package com.chinapost.devp.generate.dao;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.MetaConstDetailPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【常量值】数据库操作
 *
 * @author: cpit
 * @date: 2020/5/12
 */
@Repository
@Mapper
public interface MetaConstDetailDAO extends DAO<MetaConstDetailPO> {

    /**
     * 根据常量id查询常量值列表
     *
     * @param constId
     * @return
     */
    List<MetaConstDetailPO> findByConstId(Integer constId);

}
