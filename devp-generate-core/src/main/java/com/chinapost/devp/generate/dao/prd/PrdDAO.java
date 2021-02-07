package com.chinapost.devp.generate.dao.prd;

import com.chinapost.devp.common.dao.DAO;
import com.chinapost.devp.common.pojo.qo.OptionQO;
import com.chinapost.devp.common.pojo.vo.OptionVO;
import com.chinapost.devp.generate.pojo.po.prd.PrdPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 【需求文档管理】数据库操作
 *
 * @author wn
 * @date 2021/01/22
 */
@Repository
@Mapper
public interface PrdDAO extends DAO<PrdPO> {

    List<OptionVO<String, String>> findOptions(OptionQO<String, String> qo);

    List<PrdPO> findByGroupId(String projectGroupId);
}



