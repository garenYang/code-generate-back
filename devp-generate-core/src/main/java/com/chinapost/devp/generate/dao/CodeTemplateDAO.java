package com.chinapost.devp.generate.dao;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.generate.pojo.po.CodeTemplatePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 【代码模板】数据库操作
 *
 * @author: cpit
 * @date: 2020/10/24
 */
@Repository
@Mapper
public interface CodeTemplateDAO extends DAO<CodeTemplatePO> {

    boolean notUnique(@Param("code") String code,
                      @Param("templateVersion") String templateVersion,
                      @Param("templateId") Integer templateId);

    boolean exists();

}



