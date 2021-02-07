package com.chinapost.devp.generate.service.tree;

import cn.hutool.core.util.ObjectUtil;
import com.chinapost.devp.generate.pojo.vo.tree.TreeEntity;
import com.chinapost.devp.generate.pojo.vo.tree.TreeNode;
import com.chinapost.devp.generate.pojo.vo.tree.TreeQuery;
import com.chinapost.devp.generate.util.TreeUtil;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yanglong
 * date 2021-01-29
 */
@Service
public class TreeListService<T extends TreeEntity> {

    /**
     * 构建树
     *
     * @param trees
     * @return
     */
    public List<TreeNode> getNodeTree(TreeQuery treeQuery, List<T> trees, String deptId) {
        String extId = treeQuery.getExtId();
        Collections.sort(trees, Comparator.comparing((T t) -> t.getSort()).reversed());
        List<TreeNode> treeList = trees.stream()
                .filter(dict ->
                        (ObjectUtil.isEmpty(extId) || ObjectUtil.isEmpty(dict.getParentIds()) ||
                                (ObjectUtil.isNotEmpty(extId) && !extId.equals(dict.getId()) && dict.getParentIds() != null
                                        && dict.getParentIds().indexOf("," + extId + ",") == -1))
                )
                .map(tree -> {
                    TreeNode node = new TreeNode();
                    node.setId(tree.getId());
                    node.setParentId(tree.getParentId());
                    node.setLabel(tree.getTitle());
                    return node;
                }).collect(Collectors.toList());

        return TreeUtil.buildByLoop(treeList, deptId ==null? TreeEntity.ROOT : deptId);
    }
}
