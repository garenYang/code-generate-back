package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.common.util.ConvertUtil;
import org.mapstruct.Named;

import java.util.List;

/**
 * 通用类型转换
 *
 * @author: cpit
 * @date: 2020/11/26
 */
@Named("CommonMapper")
public class CommonMapper {

    @Named("StringToIntegerList")
    public List<Integer> stringToIntegerList(String value) {
        return ConvertUtil.convertIntegerList(value);
    }

}
