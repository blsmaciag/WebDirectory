package com.gft.challange.directoryTree;

import java.util.List;

public interface TreeNode<T> extends Iterable<TreeNode> {

    TreeNode<T> getParentNode();
    boolean hasChildNodes();

    List<TreeNode<T>> getChildren();
    void addChildNode(TreeNode node);

    TreeNodePayload<T> getNodeContent();

    void setPayload(TreeNodePayload content);
    void setParentNode(TreeNode treeNode);
}
