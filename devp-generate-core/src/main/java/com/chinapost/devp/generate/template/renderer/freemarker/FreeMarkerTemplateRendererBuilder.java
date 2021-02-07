package com.chinapost.devp.generate.template.renderer.freemarker;

import com.chinapost.devp.generate.pojo.po.CodeTemplatePO;
import com.chinapost.devp.generate.template.renderer.TemplateRenderer;
import com.chinapost.devp.generate.template.renderer.TemplateRendererBuilder;
import freemarker.template.Configuration;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * freeMarker模板渲染器建造者
 *
 * @author: cpit
 * @date: 2020/10/30
 */
@Component
public class FreeMarkerTemplateRendererBuilder implements TemplateRendererBuilder {


    @Autowired
    private FreeMarkerConfigFactory freeMarkerConfigFactory;

    @Override
    public TemplateRenderer buildRenderer(CodeTemplatePO templatePO) {
        Triple<Configuration, Integer, String> triple = freeMarkerConfigFactory.getConfigurationTriple(templatePO);
        FreeMarkerRenderer renderer = new FreeMarkerRenderer(triple.getLeft(), triple.getRight());
        return renderer;
    }


}
