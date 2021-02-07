package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.util.JsonUtil;
import com.chinapost.devp.generate.help.GenerateHelper;
import com.chinapost.devp.generate.help.MetaCascadeExtHelper;
import com.chinapost.devp.generate.pojo.dto.MetaCascadeExtAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaCascadeExtUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaCascadeExtPO;
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
public class MetaCascadeExtControllerTest extends AbstractWebTest {

    @Autowired
    private GenerateHelper generateHelper;

    private MetaProjectPO metaProject;
    private MetaEntityPO metaEntity1;
    private MetaEntityPO metaEntity2;
    private MetaFieldPO metaField1;
    private MetaFieldPO metaField2;

    @Before
    public void init() {
        this.metaProject = generateHelper.saveProjectExample();
        this.metaEntity1 = generateHelper.saveEntityExample(metaProject.getProjectId(), 1);
        this.metaEntity2 = generateHelper.saveEntityExample(metaProject.getProjectId(), 2);
        this.metaField1 = generateHelper.saveFieldExample(this.metaEntity1.getEntityId());
        this.metaField2 = generateHelper.saveFieldExample(this.metaEntity2.getEntityId());
    }

    @Test
    public void save() throws Exception {
        MetaCascadeExtAddDTO addDTO = MetaCascadeExtHelper.getAddDTO(metaField1.getFieldId(), metaEntity1.getEntityId(),
            metaField2.getFieldId(), metaEntity2.getEntityId());
        restMockMvc.perform(post(getApiPath() + "/meta_cascade_ext/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void update() throws Exception {
        MetaCascadeExtPO metaCascadeExt = generateHelper.saveCascadeExtExample(metaField1.getFieldId(), metaEntity1.getEntityId(),
            metaField2.getFieldId(), metaEntity2.getEntityId());
        MetaCascadeExtUpdateDTO updateDTO = MetaCascadeExtHelper.getUpdateDTO(metaCascadeExt);
        restMockMvc.perform(put(getApiPath() + "/meta_cascade_ext/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void list() throws Exception {
        generateHelper.saveCascadeExtExample(metaField1.getFieldId(), metaEntity1.getEntityId(),
            metaField2.getFieldId(), metaEntity2.getEntityId());
        restMockMvc.perform(get(getApiPath() + "/meta_cascade_ext/list")
            .param("fieldId", metaField1.getFieldId() + ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.length()").value(is(1)));
    }

    @Test
    public void show() throws Exception {
        MetaCascadeExtPO metaCascadeExt = generateHelper.saveCascadeExtExample(metaField1.getFieldId(), metaEntity1.getEntityId(),
            metaField2.getFieldId(), metaEntity2.getEntityId());
        restMockMvc.perform(get(getApiPath() + "/meta_cascade_ext/{cascadeExtId}", metaCascadeExt.getCascadeExtId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.cascadeExtId").value(is(metaCascadeExt.getCascadeExtId())));
    }

    @Test
    public void del() throws Exception {
        MetaCascadeExtPO metaCascadeExt = generateHelper.saveCascadeExtExample(metaField1.getFieldId(), metaEntity1.getEntityId(),
            metaField2.getFieldId(), metaEntity2.getEntityId());
        restMockMvc.perform(delete(getApiPath() + "/meta_cascade_ext/{cascadeExtId}", metaCascadeExt.getCascadeExtId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }


}
