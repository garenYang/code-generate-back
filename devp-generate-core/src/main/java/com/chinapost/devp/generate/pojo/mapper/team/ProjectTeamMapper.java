package com.chinapost.devp.generate.pojo.mapper.team;

import com.chinapost.devp.generate.pojo.dto.team.ProjectTeamAddDTO;
import com.chinapost.devp.generate.pojo.dto.team.ProjectTeamUpdateDTO;
import com.chinapost.devp.generate.pojo.po.team.ProjectTeamPO;
import com.chinapost.devp.generate.pojo.vo.team.ProjectTeamShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * 【项目组】映射
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@Mapper
public interface ProjectTeamMapper {

    ProjectTeamMapper INSTANCE = Mappers.getMapper(ProjectTeamMapper.class);

    /**
     * addDTO映射po
     *
     * @param projectTeamAddDTO
     * @return
     */
    ProjectTeamPO fromAddDTO(ProjectTeamAddDTO projectTeamAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param projectTeamPO
     * @param projectTeamUpdateDTO
     */
    void setUpdateDTO(@MappingTarget ProjectTeamPO projectTeamPO, ProjectTeamUpdateDTO projectTeamUpdateDTO);

    /**
     * po映射showVO
     *
     * @param projectTeamPO
     * @return
     */
    ProjectTeamShowVO toShowVO(ProjectTeamPO projectTeamPO);


}

