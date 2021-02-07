package com.chinapost.devp.generate.pojo.mapper.projectgroup;

import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupAddDTO;
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupExcelDTO;
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupUpdateDTO;
import com.chinapost.devp.generate.pojo.po.projectgroup.ProjectGroupPO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupExcelVO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupListVO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 【项目集】映射
 *
 * @author wn
 * @date 2021/01/22
 */
@Mapper
public interface ProjectGroupMapper {

    ProjectGroupMapper INSTANCE = Mappers.getMapper(ProjectGroupMapper.class);

    /**
     * addDTO映射po
     *
     * @param projectGroupAddDTO
     * @return
     */
    ProjectGroupPO fromAddDTO(ProjectGroupAddDTO projectGroupAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param projectGroupPO
     * @param projectGroupUpdateDTO
     */
    void setUpdateDTO(@MappingTarget ProjectGroupPO projectGroupPO, ProjectGroupUpdateDTO projectGroupUpdateDTO);

    /**
     * po映射showVO
     *
     * @param projectGroupPO
     * @return
     */
    ProjectGroupShowVO toShowVO(ProjectGroupPO projectGroupPO);


    /**
     * excelDTO映射addDTO
     *
     * @param dto
     * @return
     */
    ProjectGroupAddDTO fromExcelDTO(ProjectGroupExcelDTO dto);

    /**
     * listVO列表转excelVO列表
     *
     * @param list
     * @return
     */
    List<ProjectGroupExcelVO> toExcelVOList(List<ProjectGroupListVO> list);

    /**
     * listVO转excelVO
     *
     * @param vo
     * @return
     */
    ProjectGroupExcelVO toExcelVO(ProjectGroupListVO vo);


}

