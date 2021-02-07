package com.chinapost.devp.generate.pojo.mapper.fsd;

import com.chinapost.devp.generate.pojo.dto.fsd.FsdAddDTO;
import com.chinapost.devp.generate.pojo.dto.fsd.FsdExcelDTO;
import com.chinapost.devp.generate.pojo.dto.fsd.FsdUpdateDTO;
import com.chinapost.devp.generate.pojo.po.fsd.FsdPO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdExcelVO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdListVO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 【模块功能点】映射
 *
 * @author wn
 * @date 2021/01/22
 */
@Mapper
public interface FsdMapper {

    FsdMapper INSTANCE = Mappers.getMapper(FsdMapper.class);

    /**
     * addDTO映射po
     *
     * @param fsdAddDTO
     * @return
     */
    FsdPO fromAddDTO(FsdAddDTO fsdAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param fsdPO
     * @param fsdUpdateDTO
     */
    void setUpdateDTO(@MappingTarget FsdPO fsdPO, FsdUpdateDTO fsdUpdateDTO);

    /**
     * po映射showVO
     *
     * @param fsdPO
     * @return
     */
    FsdShowVO toShowVO(FsdPO fsdPO);


    /**
     * excelDTO映射addDTO
     *
     * @param dto
     * @return
     */
    FsdAddDTO fromExcelDTO(FsdExcelDTO dto);

    /**
     * listVO列表转excelVO列表
     *
     * @param list
     * @return
     */
    List<FsdExcelVO> toExcelVOList(List<FsdListVO> list);

    /**
     * listVO转excelVO
     *
     * @param vo
     * @return
     */
    FsdExcelVO toExcelVO(FsdListVO vo);


}

