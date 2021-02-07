package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.util.JsonUtil;
import com.chinapost.devp.generate.help.GenerateHelper;
import com.chinapost.devp.generate.help.MetaConstHelper;
import com.chinapost.devp.generate.pojo.dto.MetaConstAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaConstUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaConstPO;
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
public class MetaConstControllerTest extends AbstractWebTest {

    @Autowired
    private GenerateHelper generateHelper;

    private MetaProjectPO metaProject;

    @Before
    public void init() {
        this.metaProject = generateHelper.saveProjectExample();
    }

    @Test
    public void save() throws Exception {
        MetaConstAddDTO addDTO = MetaConstHelper.getAddDTO(metaProject.getProjectId());
        restMockMvc.perform(post(getApiPath() + "/meta_const/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void update() throws Exception {
        MetaConstPO metaConst = generateHelper.saveConstExample(metaProject.getProjectId());
        MetaConstUpdateDTO updateDTO = MetaConstHelper.getUpdateDTO(metaConst);
        restMockMvc.perform(put(getApiPath() + "/meta_const/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void list() throws Exception {
        generateHelper.saveConstExample(metaProject.getProjectId());
        restMockMvc.perform(get(getApiPath() + "/meta_const/list")
            .param("projectId", metaProject.getProjectId() + ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.length()").value(is(1)));
    }

    @Test
    public void show() throws Exception {
        MetaConstPO metaConst = generateHelper.saveConstExample(metaProject.getProjectId());
        restMockMvc.perform(get(getApiPath() + "/meta_const/{constId}", metaConst.getConstId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.constId").value(is(metaConst.getConstId())));
    }

    @Test
    public void del() throws Exception {
        MetaConstPO metaConst = generateHelper.saveConstExample(metaProject.getProjectId());
        restMockMvc.perform(delete(getApiPath() + "/meta_const/{constId}", metaConst.getConstId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }


}
