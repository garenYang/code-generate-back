package com.chinapost.devp.generate.pojo.mapper.db;

import com.chinapost.devp.generate.pojo.dto.db.ProjectDbAddDTO;
import com.chinapost.devp.generate.pojo.dto.db.ProjectDbUpdateDTO;
import com.chinapost.devp.generate.pojo.po.db.ProjectDbPO;
import com.chinapost.devp.generate.pojo.vo.db.ProjectDbShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * 【数据源配置】映射
 *
 * @author wn
 * @date 2021/01/22
 */
@Mapper
public interface ProjectDbMapper {

    ProjectDbMapper INSTANCE = Mappers.getMapper(ProjectDbMapper.class);

    /**
     * addDTO映射po
     *
     * @param projectDbAddDTO
     * @return
     */
    ProjectDbPO fromAddDTO(ProjectDbAddDTO projectDbAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param projectDbPO
     * @param projectDbUpdateDTO
     */
    void setUpdateDTO(@MappingTarget ProjectDbPO projectDbPO, ProjectDbUpdateDTO projectDbUpdateDTO);

    /**
     * po映射showVO
     *
     * @param projectDbPO
     * @return
     */
    ProjectDbShowVO toShowVO(ProjectDbPO projectDbPO);


}

