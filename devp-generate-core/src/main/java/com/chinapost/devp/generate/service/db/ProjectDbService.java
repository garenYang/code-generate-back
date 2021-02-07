package com.chinapost.devp.generate.service.db;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.RuntimeMsgException;
import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.dao.db.ProjectDbDAO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbAddDTO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbConnectionDTO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.db.ProjectDbMapper;
import com.chinapost.devp.generate.pojo.po.db.ProjectDbPO;
import com.chinapost.devp.generate.pojo.qo.db.ProjectDbQO;
import com.chinapost.devp.generate.pojo.vo.db.ProjectDbListVO;
import com.chinapost.devp.generate.pojo.vo.db.ProjectDbShowVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 【数据源配置】增删改查服务
 *
 * @author wn
 * @date 2021/01/22
 */
@Slf4j
@Service
public class ProjectDbService {

    @Autowired
    private ProjectDbDAO projectDbDAO;


    /**
     * 新增【数据源配置】
     *
     * @param projectDbDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public ProjectDbPO save(ProjectDbAddDTO projectDbDTO) {
        ProjectDbPO projectDb = ProjectDbMapper.INSTANCE.fromAddDTO(projectDbDTO);
        projectDbDAO.save(projectDb);
        return projectDb;
    }

    /**
     * 修改【数据源配置】
     *
     * @param projectDbUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public ProjectDbPO update(ProjectDbUpdateDTO projectDbUpdateDTO) {
        Long id = projectDbUpdateDTO.getId();
        ProjectDbPO projectDb = this.getProjectDb(id, true);
        ProjectDbMapper.INSTANCE.setUpdateDTO(projectDb, projectDbUpdateDTO);
        projectDbDAO.update(projectDb);
        return projectDb;
    }

    /**
     * 查询分页列表
     *
     * @param projectDbQO
     * @return
     */
    public PageVO<ProjectDbListVO> list(ProjectDbQO projectDbQO) {
        PageVO<ProjectDbListVO> page = projectDbDAO.findByPage(projectDbQO);
        return page;
    }

    /**
     * 根据主键获取【数据源配置】
     *
     * @param id    主键
     * @param force 是否强制获取
     * @return
     */
    public ProjectDbPO getProjectDb(Long id, boolean force) {
        ProjectDbPO projectDb = projectDbDAO.findById(id);
        if (force && projectDb == null) {
            throw new RuntimeMsgException(ErrorCode.RECORD_NOT_FIND.getDesc());
        }
        return projectDb;
    }


    /**
     * 查询【数据源配置】详情
     *
     * @param id
     * @return
     */
    public ProjectDbShowVO show(Long id) {
        ProjectDbPO projectDb = this.getProjectDb(id, true);
        ProjectDbShowVO showVO = ProjectDbMapper.INSTANCE.toShowVO(projectDb);
        return showVO;
    }

    /**
     * 删除【数据源配置】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Long... ids) {
        int count = 0;
        for (Long id : ids) {
            count += projectDbDAO.delete(id);
        }
        return count;
    }

    /**
     * 测试连接【数据源配置】
     *
     * @param dbConnectionDTO
     * @return
     */
    public int testConnection(ProjectDbConnectionDTO dbConnectionDTO) {
        DataSourceContext context = new DataSourceContext();
        return context.testConnection(dbConnectionDTO);
    }

    /**
     * 获取数据库表【数据源配置】
     *
     * @param dbConnectionDTO
     * @return
     */
    public List<String> allTable(ProjectDbConnectionDTO dbConnectionDTO) {
        DataSourceContext context = new DataSourceContext();
        return context.allTable(dbConnectionDTO);
    }

    /**
     * 生成ddl语句【数据源配置】
     *
     * @param dbConnectionDTO
     * @return
     */
    public String generateDdl(ProjectDbConnectionDTO dbConnectionDTO) {
        DataSourceContext context = new DataSourceContext();
        return context.generateDdl(dbConnectionDTO);
    }

}


