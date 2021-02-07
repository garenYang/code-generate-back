package com.chinapost.devp.generate.dao;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.DemandsPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 【需求列表】数据库操作
 *
 * @author wn
 * @date 2021/01/22
 */
@Repository
@Mapper
public interface DemandsDAO extends DAO<DemandsPO> {


}



