package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.util.JsonUtil;
import com.chinapost.devp.generate.help.GenerateHelper;
import com.chinapost.devp.generate.help.MetaFieldHelper;
import com.chinapost.devp.generate.pojo.dto.MetaFieldAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaFieldUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaEntityPO;
import com.chinapost.devp.generate.pojo.po.MetaFieldPO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.web.AbstractWebTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author: cpit
 * @date: 2020/5/12
 */
public class MetaFieldControllerTest extends AbstractWebTest {

    @Autowired
    private GenerateHelper generateHelper;

    private MetaProjectPO metaProject;
    private MetaEntityPO metaEntity;

    @Before
    public void init() {
        this.metaProject = generateHelper.saveProjectExample();
        this.metaEntity = generateHelper.saveEntityExample(metaProject.getProjectId(), 0);
    }

    @Test
    public void save() throws Exception {
        MetaFieldAddDTO addDTO = MetaFieldHelper.getAddDTO(metaEntity.getEntityId());
        restMockMvc.perform(post(getApiPath() + "/meta_field/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void update() throws Exception {
        MetaFieldPO metaField = generateHelper.saveFieldExample(metaEntity.getEntityId());
        MetaFieldUpdateDTO updateDTO = MetaFieldHelper.getUpdateDTO(metaField);
        restMockMvc.perform(put(getApiPath() + "/meta_field/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void list() throws Exception {
        generateHelper.saveFieldExample(metaEntity.getEntityId());
        restMockMvc.perform(get(getApiPath() + "/meta_field/list")
            .param("entityId", metaEntity.getEntityId() + ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.length()").value(is(1)));
    }

    @Test
    public void show() throws Exception {
        MetaFieldPO metaField = generateHelper.saveFieldExample(metaEntity.getEntityId());

        restMockMvc.perform(get(getApiPath() + "/meta_field/{fieldId}", metaField.getFieldId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.fieldId").value(is(metaField.getFieldId())));
    }

    @Test
    public void del() throws Exception {
        MetaFieldPO metaField = generateHelper.saveFieldExample(metaEntity.getEntityId());

        restMockMvc.perform(delete(getApiPath() + "/meta_field/{fieldId}", metaField.getFieldId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }


}
