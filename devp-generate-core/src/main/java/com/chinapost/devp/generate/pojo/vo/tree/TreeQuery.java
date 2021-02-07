package com.chinapost.devp.generate.pojo.vo.tree;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;


@Data
@ApiModel
@ToString
public class TreeQuery {

	private String extId;
	private String all;

}
