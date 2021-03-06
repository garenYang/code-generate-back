package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.util.JsonUtil;
import com.chinapost.devp.generate.help.GenerateHelper;
import com.chinapost.devp.generate.help.MetaIndexHelper;
import com.chinapost.devp.generate.pojo.dto.MetaIndexAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaIndexUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaEntityPO;
import com.chinapost.devp.generate.pojo.po.MetaFieldPO;
import com.chinapost.devp.generate.pojo.po.MetaIndexPO;
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
public class MetaIndexControllerTest extends AbstractWebTest {

    @Autowired
    private GenerateHelper generateHelper;

    private MetaProjectPO metaProject;
    private MetaEntityPO metaEntity;
    private MetaFieldPO metaField;

    @Before
    public void init() {
        this.metaProject = generateHelper.saveProjectExample();
        this.metaEntity = generateHelper.saveEntityExample(metaProject.getProjectId(), 0);
        this.metaField = generateHelper.saveFieldExample(metaEntity.getEntityId());
    }

    @Test
    public void save() throws Exception {
        MetaFieldPO metaField2 = generateHelper.saveFieldExample(metaEntity.getEntityId());
        MetaIndexAddDTO addDTO = MetaIndexHelper.getAddDTO(metaField.getFieldId(), metaField2.getFieldId());
        restMockMvc.perform(post(getApiPath() + "/meta_index/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void update() throws Exception {
        MetaFieldPO metaField2 = generateHelper.saveFieldExample(metaEntity.getEntityId());
        MetaIndexPO metaIndex = generateHelper.saveIndexExample(metaField.getFieldId(), metaField2.getFieldId());
        MetaIndexUpdateDTO updateDTO = MetaIndexHelper.getUpdateDTO(metaIndex, metaField.getFieldId());
        restMockMvc.perform(put(getApiPath() + "/meta_index/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void list() throws Exception {
        generateHelper.saveIndexExample(metaField.getFieldId());
        restMockMvc.perform(get(getApiPath() + "/meta_index/list")
            .param("entityId", metaEntity.getEntityId() + ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.length()").value(is(1)));
    }

    @Test
    public void show() throws Exception {
        MetaIndexPO metaIndex = generateHelper.saveIndexExample(metaField.getFieldId());

        restMockMvc.perform(get(getApiPath() + "/meta_index/{indexId}", metaIndex.getIndexId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.indexId").value(is(metaIndex.getIndexId())));
    }

    @Test
    public void del() throws Exception {
        MetaIndexPO metaIndex = generateHelper.saveIndexExample(metaField.getFieldId());

        restMockMvc.perform(delete(getApiPath() + "/meta_index/{indexId}", metaIndex.getIndexId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }


}
