package com.chinapost.devp.generate.service.prd;

import cn.hutool.core.util.ObjectUtil;
import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.pojo.qo.OptionQO;
import com.chinapost.devp.common.pojo.vo.OptionVO;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.common.util.UUIDUtil;
import com.chinapost.devp.generate.dao.fsd.FsdDAO;
import com.chinapost.devp.generate.dao.prd.PrdDAO;
import com.chinapost.devp.generate.pojo.dto.prd.PrdAddDTO;
import com.chinapost.devp.generate.pojo.dto.prd.PrdUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.prd.PrdMapper;
import com.chinapost.devp.generate.pojo.po.prd.PrdPO;
import com.chinapost.devp.generate.pojo.qo.prd.PrdQO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdListVO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdShowVO;
import com.chinapost.devp.generate.pojo.vo.tree.TreeNode;
import com.chinapost.devp.generate.pojo.vo.tree.TreeQuery;
import com.chinapost.devp.generate.service.tree.TreeListService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 【需求文档管理】增删改查服务
 *
 * @author wn
 * @date 2021/01/22
 */
@Service
public class PrdService extends TreeListService<PrdPO> {

    @Autowired
    private FsdDAO fsdDAO;
    @Autowired
    private PrdDAO prdDAO;


    /**
     * 新增【需求文档管理】
     *
     * @param prdDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public PrdPO save(PrdAddDTO prdDTO) {
        PrdPO parentPrdPO = prdDAO.findById(prdDTO.getParentId());
        if (ObjectUtil.isEmpty(parentPrdPO)) {
            throw new RuntimeException("父节点不存在");
        }
        PrdPO prd = PrdMapper.INSTANCE.fromAddDTO(prdDTO);
        prd.setId(UUIDUtil.getUUID());
        String parentIds = StringUtils.isNotEmpty(parentPrdPO.getParentIds()) ?
                parentPrdPO.getParentIds() + "," + parentPrdPO.getId() : parentPrdPO.getId();
        prd.setParentIds(parentIds);
        prd.setLeaf(1);
        prdDAO.save(prd);
        parentPrdPO.setLeaf(0);
        prdDAO.update(parentPrdPO);
        return prd;
    }

    /**
     * 批量新增【需求文档管理】
     *
     * @param list
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int batchSave(List<PrdAddDTO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        for (PrdAddDTO addDTO : list) {
            this.save(addDTO);
        }
        return list.size();
    }

    /**
     * 修改【需求文档管理】
     *
     * @param prdUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public PrdPO update(PrdUpdateDTO prdUpdateDTO) {
        String id = prdUpdateDTO.getId();
        PrdPO prd = this.getPrd(id, true);
        PrdMapper.INSTANCE.setUpdateDTO(prd, prdUpdateDTO);
        prdDAO.update(prd);
        return prd;
    }

    /**
     * 查询分页列表
     *
     * @param prdQO
     * @return
     */
    public PageVO<PrdListVO> list(PrdQO prdQO) {
        PageVO<PrdListVO> page = prdDAO.findByPage(prdQO);
        return page;
    }

    public List<TreeNode> listTrees(String projectGroupId) {
        Assert.notNull(projectGroupId, "项目ID不允许为空");
        List<PrdPO> prdPOS = prdDAO.findByGroupId(projectGroupId);
        return getNodeTree(new TreeQuery(), prdPOS, "-1");
    }

    /**
     * 查询【需求文档管理】选项列表
     *
     * @return
     */
    public List<OptionVO<String, String>> findOptions(OptionQO<String, String> qo) {
        List<OptionVO<String, String>> options = prdDAO.findOptions(qo);
        return options;
    }

    /**
     * 根据主键获取【需求文档管理】
     *
     * @param id    主键
     * @param force 是否强制获取
     * @return
     */
    public PrdPO getPrd(String id, boolean force) {
        PrdPO prd = prdDAO.findById(id);
        if (force && prd == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return prd;
    }


    /**
     * 查询【需求文档管理】详情
     *
     * @param id
     * @return
     */
    public PrdShowVO show(String id) {
        PrdPO prd = this.getPrd(id, true);
        PrdShowVO showVO = PrdMapper.INSTANCE.toShowVO(prd);
        return showVO;
    }

    /**
     * 删除【需求文档管理】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(String... ids) {
        int count = 0;
        for (String id : ids) {
            this.checkDeleteByFsd(id);
            count += prdDAO.delete(id);
        }
        return count;
    }

    /**
     * 校验是否存在【模块功能点】关联
     *
     * @param id
     */
    private void checkDeleteByFsd(String id) {
        int count = fsdDAO.getCountByPrdId(id);
        if (count > 0) {
            throw new BusinessException(ErrorCode.CASCADE_DELETE_ERROR);
        }
    }


}


