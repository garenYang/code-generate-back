package com.chinapost.devp.generate.web.rest;

import com.google.common.collect.Lists;
import com.chinapost.devp.common.util.JsonUtil;
import com.chinapost.devp.generate.help.GenerateHelper;
import com.chinapost.devp.generate.help.MetaProjectHelper;
import com.chinapost.devp.generate.pojo.dto.MetaProjectAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaProjectUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.web.AbstractWebTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author: cpit
 * @date: 2020/5/24
 */
public class MetaProjectControllerTest extends AbstractWebTest {

    @Autowired
    private GenerateHelper generateHelper;

    @Test
    public void save() throws Exception {
        MetaProjectAddDTO addDTO = MetaProjectHelper.getAddDTO();
        restMockMvc.perform(post(getApiPath() + "/meta_project/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void update() throws Exception {
        MetaProjectPO metaProject = generateHelper.saveProjectExample();
        MetaProjectUpdateDTO updateDTO = MetaProjectHelper.getUpdateDTO(metaProject);
        restMockMvc.perform(put(getApiPath() + "/meta_project/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void list() throws Exception {
        generateHelper.saveProjectExample();
        restMockMvc.perform(get(getApiPath() + "/meta_project/list"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.length()").value(is(1)));
    }

    @Test
    public void show() throws Exception {
        MetaProjectPO metaProject = generateHelper.saveProjectExample();
        restMockMvc.perform(get(getApiPath() + "/meta_project/{projectId}", metaProject.getProjectId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.projectId").value(is(metaProject.getProjectId())));
    }

    @Test
    public void del() throws Exception {
        MetaProjectPO metaProject = generateHelper.saveProjectExample();
        restMockMvc.perform(delete(getApiPath() + "/meta_project/{projectId}", metaProject.getProjectId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }

    @Test
    public void deleteBatch() throws Exception {
        MetaProjectPO metaProject = generateHelper.saveProjectExample();
        restMockMvc.perform(put(getApiPath() + "/meta_project/delete_batch")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(Lists.newArrayList(metaProject.getProjectId()))))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }


}
