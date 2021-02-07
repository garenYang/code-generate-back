package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.generate.pojo.dto.CodeTemplateAddDTO;
import com.chinapost.devp.generate.pojo.dto.CodeTemplateUpdateDTO;
import com.chinapost.devp.generate.pojo.po.CodeTemplatePO;
import com.chinapost.devp.generate.pojo.vo.CodeTemplateShowVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 【代码模板】映射
 *
 * @author: cpit
 * @date: 2020/10/24
 */
@Mapper
public interface CodeTemplateMapper {

    CodeTemplateMapper INSTANCE = Mappers.getMapper(CodeTemplateMapper.class);

    /**
     * addDTO映射po
     *
     * @param codeTemplateAddDTO
     * @return
     */
    CodeTemplatePO fromAddDTO(CodeTemplateAddDTO codeTemplateAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param codeTemplatePO
     * @param codeTemplateUpdateDTO
     */
    void setUpdateDTO(@MappingTarget CodeTemplatePO codeTemplatePO, CodeTemplateUpdateDTO codeTemplateUpdateDTO);

    /**
     * po映射showVO
     *
     * @param codeTemplatePO
     * @return
     */
    CodeTemplateShowVO toShowVO(CodeTemplatePO codeTemplatePO);


    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "code"),
            @Mapping(target = "name"),
            @Mapping(target = "templateVersion"),
            @Mapping(target = "sysLowVersion"),
            @Mapping(target = "sysDefault"),
            @Mapping(target = "remark"),
            @Mapping(target = "metaLabel"),
    })
    CodeTemplatePO copy(CodeTemplatePO project);

}

