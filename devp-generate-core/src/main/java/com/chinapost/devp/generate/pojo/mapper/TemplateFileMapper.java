package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.generate.pojo.dto.TemplateFileAddDTO;
import com.chinapost.devp.generate.pojo.dto.TemplateFileUpdateDTO;
import com.chinapost.devp.generate.pojo.po.TemplateFilePO;
import com.chinapost.devp.generate.pojo.vo.TemplateFileShowVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 【模板文件】映射
 *
 * @author: cpit
 * @date: 2020/10/24
 */
@Mapper
public interface TemplateFileMapper {

    TemplateFileMapper INSTANCE = Mappers.getMapper(TemplateFileMapper.class);

    /**
     * addDTO映射po
     *
     * @param templateFileAddDTO
     * @return
     */
    TemplateFilePO fromAddDTO(TemplateFileAddDTO templateFileAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param templateFilePO
     * @param templateFileUpdateDTO
     */
    void setUpdateDTO(@MappingTarget TemplateFilePO templateFilePO, TemplateFileUpdateDTO templateFileUpdateDTO);

    /**
     * po映射showVO
     *
     * @param templateFilePO
     * @return
     */
    TemplateFileShowVO toShowVO(TemplateFilePO templateFilePO);

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "fileName"),
            @Mapping(target = "fileDir"),
            @Mapping(target = "contextType"),
            @Mapping(target = "fileType"),
            @Mapping(target = "content"),
    })
    TemplateFilePO copy(TemplateFilePO po);

}

