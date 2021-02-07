package com.chinapost.devp.generate.template.renderer;

import com.chinapost.devp.generate.pojo.po.CodeTemplatePO;

/**
 * 模板渲染器建造者
 *
 * @author: cpit
 * @date: 2020/10/30
 */
public interface TemplateRendererBuilder {

    /**
     * 构建模板渲染器
     *
     * @param templatePO
     * @return
     */
    TemplateRenderer buildRenderer(CodeTemplatePO templatePO);

}
