package com.chinapost.devp.generate.template.renderer;

import com.chinapost.devp.generate.pojo.po.TemplateFilePO;
import com.chinapost.devp.generate.template.context.BaseContext;

/**
 * 模板渲染器
 *
 * @author: cpit
 * @date: 2020/11/26
 */
public interface TemplateRenderer {

    /**
     * 渲染模板路径
     *
     * @param templateFilePO
     * @param context
     * @return
     */
    String renderPath(TemplateFilePO templateFilePO, BaseContext context);

    /**
     * 渲染模板内容
     *
     * @param templateFilePO
     * @param context
     * @return
     */
    Object renderContent(TemplateFilePO templateFilePO, BaseContext context);

}
