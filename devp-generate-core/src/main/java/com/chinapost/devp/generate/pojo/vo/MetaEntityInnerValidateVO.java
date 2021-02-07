package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.pojo.vo.AbstractVO;

import java.util.List;

/**
 * 实体内部校验结果展示对象
 *
 * @author: cpit
 * @date: 2020/10/10
 */
public class MetaEntityInnerValidateVO extends AbstractVO {

    /**
     * 字段校验信息
     */
    private List<MetaFieldValidateVO> fields;

    public List<MetaFieldValidateVO> getFields() {
        return fields;
    }

    public void setFields(List<MetaFieldValidateVO> fields) {
        this.fields = fields;
    }
}
