package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * er图返回结果
 *
 * @author: cpit
 * @date: 2020/7/17
 */
public class EntityDiagramVO extends AbstractVO {

    /**
     * 实体名称
     */
    private String key;

    /**
     * 字段列表
     */
    private List<FieldDiagramVO> fields;

    public void addField(String name, String type, String desc) {
        if (fields == null) {
            fields = new ArrayList<>();
        }
        fields.add(new FieldDiagramVO(name, type, desc));
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<FieldDiagramVO> getFields() {
        return fields;
    }

    public void setFields(List<FieldDiagramVO> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("key", key)
                .append("fields", fields)
                .toString();
    }
}
