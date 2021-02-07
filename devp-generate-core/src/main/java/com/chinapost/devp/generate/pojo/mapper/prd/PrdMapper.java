package com.chinapost.devp.generate.pojo.mapper.prd;

import com.chinapost.devp.generate.pojo.dto.prd.PrdAddDTO;
import com.chinapost.devp.generate.pojo.dto.prd.PrdExcelDTO;
import com.chinapost.devp.generate.pojo.dto.prd.PrdUpdateDTO;
import com.chinapost.devp.generate.pojo.po.prd.PrdPO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdExcelVO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdListVO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 【需求文档管理】映射
 *
 * @author wn
 * @date 2021/01/22
 */
@Mapper
public interface PrdMapper {

    PrdMapper INSTANCE = Mappers.getMapper(PrdMapper.class);

    /**
     * addDTO映射po
     *
     * @param prdAddDTO
     * @return
     */
    PrdPO fromAddDTO(PrdAddDTO prdAddDTO);

    /**
     * 将updateDTO中的值设置到po
     *
     * @param prdPO
     * @param prdUpdateDTO
     */
    void setUpdateDTO(@MappingTarget PrdPO prdPO, PrdUpdateDTO prdUpdateDTO);

    /**
     * po映射showVO
     *
     * @param prdPO
     * @return
     */
    PrdShowVO toShowVO(PrdPO prdPO);


    /**
     * excelDTO映射addDTO
     *
     * @param dto
     * @return
     */
    PrdAddDTO fromExcelDTO(PrdExcelDTO dto);

    /**
     * listVO列表转excelVO列表
     *
     * @param list
     * @return
     */
    List<PrdExcelVO> toExcelVOList(List<PrdListVO> list);

    /**
     * listVO转excelVO
     *
     * @param vo
     * @return
     */
    PrdExcelVO toExcelVO(PrdListVO vo);


}

