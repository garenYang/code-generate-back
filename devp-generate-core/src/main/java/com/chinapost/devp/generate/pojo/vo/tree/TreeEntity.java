package com.chinapost.devp.generate.pojo.vo.tree;

import com.chinapost.devp.common.pojo.po.AbstractPO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 数据TreeEntity类
 * @author kakusilong
 */

@Data
public class TreeEntity<T extends TreeEntity<T>> extends AbstractPO {

	protected String id;
	public static final String ROOT = "-1";
	public static final String F_NAME = "title";
	public static final String F_PARENTID = "parentId";
	public static final String F_PARENTIDS = "parentIds";
	public static final String F_LEAF = "leaf";
	public static final String F_SORT = "sort";
	public static final String F_PARENT = "parent";
	public static final String F_SQL_NAME = "title";
	public static final String F_SQL_PARENTID = "parent_id";
	public static final String F_SQL_PARENTIDS = "parent_ids";
	public static final String F_SQL_LEAF = "leaf";
	public static final String F_SQL_SORT = "sort";
	private static final long serialVersionUID = 1L;
	/*** 组织名称 */
	@NotBlank(message = "名称不能为空")
	protected String title;
	/*** 上级组织 */
	@NotNull(message = "父ID不能为空")
	protected String parentId;
	/*** 所有父编号 */
	protected String parentIds;
	/*** 上级组织 */
	@JsonIgnore
	protected T parent;
	/*** 序号 */
	protected Integer sort;
	/*** 父模块名称 */
	protected String parentName;
	/*** 1 叶子节点 0非叶子节点 */
	private Integer leaf = 1;

	public TreeEntity() {
		super();
		this.sort = 30;
	}

	public TreeEntity(String id) {
		super();
		this.id = id;
		this.sort = 30;
	}

	public String getParentName() {
		if (StringUtils.isEmpty(parentName) && parent != null) {
			parentName = parent.getTitle();
		}
		return parentName;
	}

}
