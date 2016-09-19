package com.gft.challange.directoryTree;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectoryTreeNode implements TreeNode {

    private TreeNode parentNode;
    private List<TreeNode> childNodes = new ArrayList<>();
    private TreeNodeContent<Path> content;

    public DirectoryTreeNode() {
    }

    @Override
    public TreeNode getParentNode() {
        return parentNode;
    }

    @Override
    public void addChildNode(TreeNode node) {
        node.setParentNode(this);
        childNodes.add(node);
    }

    @Override
    public boolean hasChildNodes() {
        return childNodes.size() != 0 ? true : false;
    }

    @Override
    public List<TreeNode> getChildren() {
        return childNodes;
    }

    @Override
    public boolean isRoot() {
        return parentNode == null;
    }

    @Override
    public TreeNodeContent getNodeContent() {
        return content;
    }

    @Override
    public void setContent(TreeNodeContent content) {
        this.content = content;
    }

    @Override
    public void setParentNode(TreeNode treeNode) {
        this.parentNode = treeNode;
    }

    /**
     * @return Iterator to iterate over list of siblings
     */
    @Override
    public Iterator<TreeNode> iterator() {
            return new TreeNodeIterator(this);
    }

    @Override
    public Iterator<TreeNode> getSibilingsIterator() {
        if(isRoot()) {
            return new RootNodeIterator(this);
        } else {
            return getParentNode().getChildren().iterator();
        }
    }
}
