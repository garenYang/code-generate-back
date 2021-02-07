package com.chinapost.devp.generate.service;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.optimistic.OptimisticLock;
import com.chinapost.devp.generate.dao.MetaFieldDAO;
import com.chinapost.devp.generate.pojo.dto.MetaFieldAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaFieldUpdateDTO;
import com.chinapost.devp.generate.pojo.dto.MetaFieldUpdateOrderNoDTO;
import com.chinapost.devp.generate.pojo.mapper.MetaFieldMapper;
import com.chinapost.devp.generate.pojo.po.MetaFieldPO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.qo.MetaFieldQO;
import com.chinapost.devp.generate.pojo.vo.MetaFieldListVO;
import com.chinapost.devp.generate.pojo.vo.MetaFieldShowVO;
import com.chinapost.devp.generate.util.MetadataUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 字段增删改查服务
 *
 * @author: cpit
 * @date: 2017/5/12
 */
@Service
public class MetaFieldService {

    @Autowired
    private MetaFieldDAO metaFieldDAO;
    @Autowired
    private MetaProjectService metaProjectService;
    @Autowired
    private MetaCascadeExtService metaCascadeExtService;
    @Autowired
    private MetaMtmCascadeExtService metaMtmCascadeExtService;

    /**
     * 新增字段
     *
     * @param metaFieldDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public MetaFieldPO save(MetaFieldAddDTO metaFieldDTO) {
        // 校验字段名
        MetadataUtil.jfieldNameCheck(metaFieldDTO.getJfieldName());
        Integer entityId = metaFieldDTO.getEntityId();
        // 获取项目，并校验操作人
        MetaProjectPO project = metaProjectService.getProjectByEntityId(entityId, true);
        MetaFieldPO field = MetaFieldMapper.INSTANCE.fromAddDTO(metaFieldDTO);
        field.setProjectId(project.getProjectId());

        this.doSave(field);
        metaProjectService.updateProject(project);
        return field;
    }


    public void doSave(MetaFieldPO field) {
        // 校验字段属性
        MetadataUtil.checkAndRepairFieldPO(field);
        metaFieldDAO.save(field);
    }

    /**
     * 修改字段
     *
     * @param updateDTO
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public MetaFieldPO update(MetaFieldUpdateDTO updateDTO) {
        // 校验字段名
        MetadataUtil.jfieldNameCheck(updateDTO.getJfieldName());
        Integer fieldId = updateDTO.getFieldId();
        MetaFieldPO metaField = this.getField(fieldId, true);
        Integer entityId = metaField.getEntityId();
        // 查询项目,同时校验用户权限
        MetaProjectPO project = metaProjectService.getAndCheckProject(metaField.getProjectId());
        MetaFieldMapper.INSTANCE.setPO(metaField, updateDTO);
        // 校验字段属性
        MetadataUtil.checkAndRepairFieldPO(metaField);
        metaFieldDAO.update(metaField);
        metaProjectService.updateProject(project);
        return metaField;
    }

    /**
     * 获取字段对象
     *
     * @param fieldId
     * @param force
     * @return
     */
    public MetaFieldPO getField(Integer fieldId, boolean force) {
        MetaFieldPO fieldPO = metaFieldDAO.findById(fieldId);
        if (force && fieldPO == null) {
            throw new BusinessException(ErrorCode.RECORD_NOT_FIND, "字段未找到");
        }
        return fieldPO;
    }

    /**
     * 查询列表
     *
     * @param metaFieldQO
     * @return
     */
    public List<MetaFieldListVO> list(MetaFieldQO metaFieldQO) {
        List<MetaFieldListVO> list = metaFieldDAO.findListByQuery(metaFieldQO);
        return list;
    }

    /**
     * 查询字段详情
     *
     * @param fieldId
     * @return
     */
    public MetaFieldShowVO show(Integer fieldId) {
        MetaFieldPO metaField = this.getField(fieldId, true);
        MetaFieldShowVO showVO = MetaFieldMapper.INSTANCE.toShowVO(metaField);
        return showVO;
    }

    /**
     * 删除字段
     *
     * @param fieldId
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public int delete(Integer... fieldId) {
        int count = 0;
        for (Integer id : fieldId) {
            MetaFieldPO metaField = this.getField(id, false);
            if (metaField == null) {
                continue;
            }
            // 查询项目,同时校验用户权限
            MetaProjectPO project = metaProjectService.getAndCheckProject(metaField.getProjectId());
            count += metaFieldDAO.delete(id);

            // 删除外键级联扩展
            List<Integer> cascadeFieldIds = metaCascadeExtService.findPkByCascadeFieldId(id);
            if (CollectionUtils.isNotEmpty(cascadeFieldIds)) {
                metaCascadeExtService.delete(cascadeFieldIds.toArray(new Integer[0]));
            }
            // 删除多对多级联扩展
            List<Integer> mtmCascadeFieldIds = metaMtmCascadeExtService.findPkByCascadeFieldId(id);
            if (CollectionUtils.isNotEmpty(mtmCascadeFieldIds)) {
                metaMtmCascadeExtService.delete(mtmCascadeFieldIds.toArray(new Integer[0]));
            }
            metaProjectService.updateProject(project);
        }
        return count;
    }

    /**
     * 根据实体id查询字段列表
     *
     * @param entityId
     * @return
     */
    public List<MetaFieldPO> findByEntityId(Integer entityId) {
        return metaFieldDAO.findByEntityId(entityId);

    }

    /**
     * 修改字段序号
     *
     * @param dto
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @OptimisticLock
    public Integer updateOrderNo(MetaFieldUpdateOrderNoDTO dto) {
        MetaFieldPO field = this.getField(dto.getFieldId(), true);
        // 查询项目,同时校验用户权限
        MetaProjectPO project = metaProjectService.getAndCheckProject(field.getProjectId());
        field.setOrderNo(dto.getOrderNo());
        metaFieldDAO.update(field);
        metaProjectService.updateProject(project);
        return field.getOrderNo();
    }


    /**
     * 修改字段内容
     *
     * @param field
     */
    public void doUpdate(MetaFieldPO field) {
        metaFieldDAO.update(field);
    }


}
