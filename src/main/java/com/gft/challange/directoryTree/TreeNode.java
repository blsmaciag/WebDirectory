package com.gft.challange.directoryTree;

import java.util.List;

public interface TreeNode extends Iterable<TreeNode>{

    TreeNode getParentNode();
    boolean hasChildNodes();
    List<TreeNode> getChildren();
    void addChildNode(TreeNode node);
    TreeNodeContent getNodeContent();
    void setContent(TreeNodeContent content);
    void setParentNode(TreeNode treeNode);
}
