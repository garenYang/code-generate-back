package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.util.JsonUtil;
import com.chinapost.devp.generate.help.GenerateHelper;
import com.chinapost.devp.generate.help.MetaConstDetailHelper;
import com.chinapost.devp.generate.pojo.dto.MetaConstDetailAddDTO;
import com.chinapost.devp.generate.pojo.dto.MetaConstDetailUpdateDTO;
import com.chinapost.devp.generate.pojo.po.MetaConstDetailPO;
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
public class MetaConstDetailControllerTest extends AbstractWebTest {

    @Autowired
    private GenerateHelper generateHelper;

    private MetaProjectPO metaProject;
    private MetaConstPO metaConst;

    @Before
    public void init() {
        this.metaProject = generateHelper.saveProjectExample();
        this.metaConst = generateHelper.saveConstExample(this.metaProject.getProjectId());
    }

    @Test
    public void save() throws Exception {
        MetaConstDetailAddDTO addDTO = MetaConstDetailHelper.getAddDTO(metaConst.getConstId());
        restMockMvc.perform(post(getApiPath() + "/meta_const_detail/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(addDTO)))
            .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void update() throws Exception {
        MetaConstDetailPO metaConstDetail = generateHelper.saveConstDetailExample(metaConst.getConstId());
        MetaConstDetailUpdateDTO updateDTO = MetaConstDetailHelper.getUpdateDTO(metaConstDetail);
        restMockMvc.perform(put(getApiPath() + "/meta_const_detail/update")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JsonUtil.toJSONString(updateDTO)))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void list() throws Exception {
        generateHelper.saveConstDetailExample(metaConst.getConstId());
        restMockMvc.perform(get(getApiPath() + "/meta_const_detail/list")
            .param("constId", metaConst.getConstId() + ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.length()").value(is(1)));
    }

    @Test
    public void show() throws Exception {
        MetaConstDetailPO metaConstDetail = generateHelper.saveConstDetailExample(metaConst.getConstId());
        restMockMvc.perform(get(getApiPath() + "/meta_const_detail/{constId}", metaConstDetail.getConstId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.constId").value(is(metaConstDetail.getConstId())));
    }

    @Test
    public void del() throws Exception {
        MetaConstDetailPO metaConstDetail = generateHelper.saveConstDetailExample(metaConst.getConstId());
        restMockMvc.perform(delete(getApiPath() + "/meta_const_detail/{constId}", metaConstDetail.getConstId()))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$").value(is(1)));
    }


}
