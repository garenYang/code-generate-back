package com.chinapost.devp.generate.dao;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.MetaIndexFieldPO;
import com.chinapost.devp.generate.pojo.vo.MetaFieldListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【索引字段关联表】操作
 *
 * @author: cpit
 * @date: 2020/5/12
 */
@Repository
@Mapper
public interface MetaIndexFieldDAO extends DAO<MetaIndexFieldPO> {


    /**
     * 根据索引id查询字段列表
     *
     * @param indexId
     * @return
     */
    List<MetaFieldListVO> findByIndexId(Integer indexId);

    /**
     * 根据索引id查询关联列表
     *
     * @param indexId
     * @return
     */
    List<Integer> findIdsByIndexId(Integer indexId);

    /**
     * 批量插入关联关系
     *
     * @param indexId
     * @param fieldIdList
     * @param projectId
     * @return
     */
    int saveBatch(@Param("indexId") Integer indexId,
                  @Param("fieldIdList") List<Integer> fieldIdList,
                  @Param("projectId") Integer projectId);


    int remove(@Param("indexId") Integer indexId, @Param("fieldIdList") List<Integer> fieldIdList);

}
