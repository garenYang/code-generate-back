package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.generate.pojo.dto.DemandsAddDTO;
import com.chinapost.devp.generate.pojo.dto.DemandsExcelDTO;
import com.chinapost.devp.generate.pojo.dto.DemandsUpdateDTO;
import com.chinapost.devp.generate.pojo.po.DemandsPO;
import com.chinapost.devp.generate.pojo.vo.DemandsExcelVO;
import com.chinapost.devp.generate.pojo.vo.DemandsListVO;
import com.chinapost.devp.generate.pojo.vo.DemandsShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 【需求列表】映射
 *
 * @author wn
 * @date 2021/01/22
 */
@Mapper
public interface DemandsMapper {

    DemandsMapper INSTANCE = Mappers.getMapper(DemandsMapper.class);

    /**
     * addDTO映射po
     *
     * @param demandsAddDTO
     * @return
     */
    DemandsPO fromAddDTO(DemandsAddDTO demandsAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param demandsPO
     * @param demandsUpdateDTO
     */
    void setUpdateDTO(@MappingTarget DemandsPO demandsPO, DemandsUpdateDTO demandsUpdateDTO);

    /**
     * po映射showVO
     *
     * @param demandsPO
     * @return
     */
    DemandsShowVO toShowVO(DemandsPO demandsPO);


    /**
     * excelDTO映射addDTO
     *
     * @param dto
     * @return
     */
    DemandsAddDTO fromExcelDTO(DemandsExcelDTO dto);

    /**
     * listVO列表转excelVO列表
     *
     * @param list
     * @return
     */
    List<DemandsExcelVO> toExcelVOList(List<DemandsListVO> list);

    /**
     * listVO转excelVO
     *
     * @param vo
     * @return
     */
    DemandsExcelVO toExcelVO(DemandsListVO vo);


}

