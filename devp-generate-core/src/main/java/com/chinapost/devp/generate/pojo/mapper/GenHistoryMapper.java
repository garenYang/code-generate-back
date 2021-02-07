package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.generate.pojo.po.GenHistoryPO;
import com.chinapost.devp.generate.pojo.vo.GenHistoryShowVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 生成历史映射
 * <p>基于mapstruct来实现，编译器自动生成实现类
 *
 * @author: cpit
 * @date: 2020/11/26
 */
@Mapper
public interface GenHistoryMapper {

    GenHistoryMapper INSTANCE = Mappers.getMapper(GenHistoryMapper.class);


    /**
     * po映射showVO
     */
    GenHistoryShowVO toShowVO(GenHistoryPO po);

}
