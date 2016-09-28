package com.gft.challange.directoryTree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class TreeNode1Mock<T> implements TreeNode1<T> {

    private List<TreeNode<T>> children;

    public TreeNode1Mock(T payload, TreeNode<T>... nodeChildren) {
        children = Arrays.asList(nodeChildren);
    }

    @Override
    public T getPayload() {
        return null;
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return children.iterator();
    }
}
