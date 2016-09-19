package com.gft.challange.directoryTree;

import java.util.Iterator;
import java.util.List;

public interface TreeNode extends Iterable<TreeNode>{

    TreeNode getParentNode();
    boolean hasChildNodes();
    List<TreeNode> getChildren();
    Iterator<TreeNode> getSibilingsIterator();
    void addChildNode(TreeNode node);
    boolean isRoot();
    TreeNodeContent getNodeContent();
    void setContent(TreeNodeContent content);
    void setParentNode(TreeNode treeNode);
}
