package com.chinapost.devp.generate.service;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.config.GenerateProperties;
import com.chinapost.devp.generate.dao.GenHistoryDAO;
import com.chinapost.devp.generate.pojo.po.CodeTemplatePO;
import com.chinapost.devp.generate.pojo.po.GenHistoryPO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.qo.GenHistoryQO;
import com.chinapost.devp.generate.pojo.vo.GenHistoryListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


/**
 * 【生成历史】删改查服务
 *
 * @author: cpit
 * @date: 2020/03/17
 */
@Service
public class GenHistoryService {

    @Autowired
    private GenHistoryDAO genHistoryDAO;
    @Autowired
    private GenerateProperties generateProperties;

    /**
     * 新增【生成历史】
     *
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public GenHistoryPO save(MetaProjectPO project, CodeTemplatePO codeTemplate,
                             String remoteUrl, String commit, String branch) {
        GenHistoryPO genHistory = new GenHistoryPO();
        genHistory.setProjectId(project.getProjectId());
        genHistory.setRemoteUrl(remoteUrl);
        genHistory.setCommit(commit);
        genHistory.setBranch(branch);
        genHistory.setSysVersion(generateProperties.getVersion());
        genHistory.setProjectVersion(project.getProjectVersion());
        genHistory.setTemplateId(codeTemplate.getTemplateId());
        genHistory.setTemplateInnerVersion(codeTemplate.getInnerVersion());
        genHistoryDAO.save(genHistory);
        return genHistory;
    }

    /**
     * 查询分页列表
     *
     * @param genHistoryQO
     * @return
     */
    public PageVO<GenHistoryListVO> list(GenHistoryQO genHistoryQO) {
        PageVO<GenHistoryListVO> page = genHistoryDAO.findByPage(genHistoryQO);
        return page;
    }


    /**
     * 根据主键获取【生成历史】
     *
     * @param historyId
     * @param force
     * @return
     */
    public GenHistoryPO getGenHistory(Integer historyId, boolean force) {
        GenHistoryPO genHistory = genHistoryDAO.findById(historyId);
        if (force && genHistory == null) {
            throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR, "未查询到记录");
        }
        return genHistory;
    }

    /**
     * 查找最后一次提交记录
     *
     * @param projectId
     * @param remoteUrl
     * @return
     */
    public GenHistoryPO findLastGenHistory(Integer projectId, String remoteUrl) {
        return genHistoryDAO.findByProjectIdAndRemoteUrl(projectId, remoteUrl);
    }

    /**
     * 删除【生成历史】
     *
     * @param historyIds
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Integer... historyIds) {
        int count = 0;
        for (Integer historyId : historyIds) {
            count += genHistoryDAO.delete(historyId);
        }
        return count;
    }


    /**
     * 校验提交版本
     *
     * @param project      项目
     * @param codeTemplate 代码模板
     * @param genHistory   上一次生成历史
     */
    public boolean checkVersion(MetaProjectPO project, CodeTemplatePO codeTemplate, GenHistoryPO genHistory) {
        if (Objects.equals(genHistory.getProjectVersion(), project.getProjectVersion())
                && Objects.equals(genHistory.getSysVersion(), generateProperties.getVersion())
                && Objects.equals(codeTemplate.getTemplateId(), genHistory.getTemplateId())
                && Objects.equals(codeTemplate.getInnerVersion(), genHistory.getTemplateInnerVersion())
        ) {
            return false;
        }
        return true;
    }

}


