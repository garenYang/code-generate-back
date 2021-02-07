package com.chinapost.devp.generate.dao;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.GenHistoryPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 【生成历史记录】数据库操作
 *
 * @author: cpit
 * @date: 2020/3/17
 */
@Repository
@Mapper
public interface GenHistoryDAO extends DAO<GenHistoryPO> {


    GenHistoryPO findByProjectIdAndRemoteUrl(@Param("projectId") Integer projectId,
                                             @Param("remoteUrl") String remoteUrl);


}
