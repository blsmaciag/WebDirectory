package com.gft.challange.directoryTree;

import java.util.Iterator;

public class Tree<T> implements Iterable<TreeNode<T>> {

    private TreeNode<T> root;

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return new TreeNodeIterator<>(root);
    }
}
