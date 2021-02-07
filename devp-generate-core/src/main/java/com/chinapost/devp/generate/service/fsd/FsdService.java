package com.chinapost.devp.generate.service.fsd;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.common.util.UUIDUtil;
import com.chinapost.devp.generate.dao.fsd.FsdDAO;
import com.chinapost.devp.generate.dao.prd.PrdDAO;
import com.chinapost.devp.generate.pojo.dto.fsd.FsdAddDTO;
import com.chinapost.devp.generate.pojo.dto.fsd.FsdUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.fsd.FsdMapper;
import com.chinapost.devp.generate.pojo.po.fsd.FsdPO;
import com.chinapost.devp.generate.pojo.qo.fsd.FsdQO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdListVO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdShowVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 【模块功能点】增删改查服务
 *
 * @author wn
 * @date 2021/01/22
 */
@Service
public class FsdService {

    @Autowired
    private FsdDAO fsdDAO;
    @Autowired
    private PrdDAO prdDAO;


    /**
     * 新增【模块功能点】
     *
     * @param fsdDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public FsdPO save(FsdAddDTO fsdDTO) {
        FsdPO fsd = FsdMapper.INSTANCE.fromAddDTO(fsdDTO);
        if (fsd.getPrdId() != null) {
            Assert.isTrue(prdDAO.exist(fsd.getPrdId()), "功能模块ID有误");
        }
        fsd.setId(UUIDUtil.getUUID());
        fsdDAO.save(fsd);
        return fsd;
    }

    /**
     * 批量新增【模块功能点】
     *
     * @param list
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int batchSave(List<FsdAddDTO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        for (FsdAddDTO addDTO : list) {
            this.save(addDTO);
        }
        return list.size();
    }

    /**
     * 修改【模块功能点】
     *
     * @param fsdUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public FsdPO update(FsdUpdateDTO fsdUpdateDTO) {
        String id = fsdUpdateDTO.getId();
        FsdPO fsd = this.getFsd(id, true);
        FsdMapper.INSTANCE.setUpdateDTO(fsd, fsdUpdateDTO);
        if (fsd.getPrdId() != null) {
            Assert.isTrue(prdDAO.exist(fsd.getPrdId()), "功能模块ID有误");
        }
        fsdDAO.update(fsd);
        return fsd;
    }

    /**
     * 查询分页列表
     *
     * @param fsdQO
     * @return
     */
    public PageVO<FsdListVO> list(FsdQO fsdQO) {
        PageVO<FsdListVO> page = fsdDAO.findByPage(fsdQO);
        return page;
    }

    /**
     * 根据主键获取【模块功能点】
     *
     * @param id    主键
     * @param force 是否强制获取
     * @return
     */
    public FsdPO getFsd(String id, boolean force) {
        FsdPO fsd = fsdDAO.findById(id);
        if (force && fsd == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return fsd;
    }


    /**
     * 查询【模块功能点】详情
     *
     * @param id
     * @return
     */
    public FsdShowVO show(String id) {
        FsdPO fsd = this.getFsd(id, true);
        FsdShowVO showVO = FsdMapper.INSTANCE.toShowVO(fsd);
        return showVO;
    }

    /**
     * 删除【模块功能点】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(String... ids) {
        int count = 0;
        for (String id : ids) {
            count += fsdDAO.delete(id);
        }
        return count;
    }


}


