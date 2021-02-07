package com.chinapost.devp.generate.dao.fsd;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.fsd.FsdPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 【模块功能点】数据库操作
 *
 * @author wn
 * @date 2021/01/22
 */
@Repository
@Mapper
public interface FsdDAO extends DAO<FsdPO> {

    int getCountByPrdId(String prdId);


}



