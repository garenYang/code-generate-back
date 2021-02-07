package com.chinapost.devp.generate.pojo.vo.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class TreeNode<T> {
	protected String id;
	protected String parentId;
	protected List<T> children = new ArrayList<T>();
	private String label;

	public void add(T node) {
		children.add(node);
	}
}
