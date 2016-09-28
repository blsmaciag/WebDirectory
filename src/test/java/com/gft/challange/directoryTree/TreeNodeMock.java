package com.gft.challange.directoryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNodeMock implements TreeNode {

    private TreeNode parentNode;
    private List<TreeNode> children = new ArrayList<>();
    private TreeNodePayload<String> payload;

    public TreeNodeMock(String content) {
        payload = new TreeNodePayload<>(content);
    }

    @Override
    public TreeNode getParentNode() {
        return parentNode;
    }

    @Override
    public boolean hasChildNodes() {
        return !children.isEmpty();
    }

    @Override
    public List<TreeNode> getChildren() {
        return children;
    }

    @Override
    public void addChildNode(TreeNode node) {
        node.setParentNode(this);
        children.add(node);
    }

    @Override
    public TreeNodePayload getNodeContent() {
        return payload;
    }

    @Override
    public void setPayload(TreeNodePayload content) {
        this.payload = content;
    }

    @Override
    public void setParentNode(TreeNode treeNode) {
        this.parentNode = treeNode;
    }

    @Override
    public Iterator<TreeNode> iterator() {
        return new TreeNodeIterator(this);
    }
}
