package com.chinapost.devp.generate.service;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.generate.dao.DemandsDAO;
import com.chinapost.devp.generate.pojo.dto.DemandsAddDTO;
import com.chinapost.devp.generate.pojo.dto.DemandsUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.DemandsMapper;
import com.chinapost.devp.generate.pojo.po.DemandsPO;
import com.chinapost.devp.generate.pojo.qo.DemandsQO;
import com.chinapost.devp.generate.pojo.vo.DemandsListVO;
import com.chinapost.devp.generate.pojo.vo.DemandsShowVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 【需求列表】增删改查服务
 *
 * @author wn
 * @date 2021/01/22
 */
@Service
public class DemandsService {

    @Autowired
    private DemandsDAO demandsDAO;


    /**
     * 新增【需求列表】
     *
     * @param demandsDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public DemandsPO save(DemandsAddDTO demandsDTO) {
        DemandsPO demands = DemandsMapper.INSTANCE.fromAddDTO(demandsDTO);
        demandsDAO.save(demands);
        return demands;
    }

    /**
     * 批量新增【需求列表】
     *
     * @param list
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int batchSave(List<DemandsAddDTO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        for (DemandsAddDTO addDTO : list) {
            this.save(addDTO);
        }
        return list.size();
    }

    /**
     * 修改【需求列表】
     *
     * @param demandsUpdateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public DemandsPO update(DemandsUpdateDTO demandsUpdateDTO) {
        Long id = demandsUpdateDTO.getId();
        DemandsPO demands = this.getDemands(id, true);
        DemandsMapper.INSTANCE.setUpdateDTO(demands, demandsUpdateDTO);
        demandsDAO.update(demands);
        return demands;
    }

    /**
     * 查询分页列表
     *
     * @param demandsQO
     * @return
     */
    public PageVO<DemandsListVO> list(DemandsQO demandsQO) {
        PageVO<DemandsListVO> page = demandsDAO.findByPage(demandsQO);
        return page;
    }

    /**
     * 根据主键获取【需求列表】
     *
     * @param id    主键
     * @param force 是否强制获取
     * @return
     */
    public DemandsPO getDemands(Long id, boolean force) {
        DemandsPO demands = demandsDAO.findById(id);
        if (force && demands == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND);
        }
        return demands;
    }


    /**
     * 查询【需求列表】详情
     *
     * @param id
     * @return
     */
    public DemandsShowVO show(Long id) {
        DemandsPO demands = this.getDemands(id, true);
        DemandsShowVO showVO = DemandsMapper.INSTANCE.toShowVO(demands);
        return showVO;
    }

    /**
     * 删除【需求列表】
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Long... ids) {
        int count = 0;
        for (Long id : ids) {
            count += demandsDAO.delete(id);
        }
        return count;
    }


}


