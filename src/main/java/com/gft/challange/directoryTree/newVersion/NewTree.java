package com.gft.challange.directoryTree.newVersion;

import java.util.Iterator;

public class NewTree<T> implements Iterable<INewNode<T>> {

    private INewNode<T> root;

    public NewTree(INewNode<T> node) {
        this.root = node;
    }

    @Override
    public Iterator<INewNode<T>> iterator() {
        return new NewTreeIterator<>(root);
    }
}
