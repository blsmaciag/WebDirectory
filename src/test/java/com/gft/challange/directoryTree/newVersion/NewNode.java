package com.gft.challange.directoryTree.newVersion;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NewNode<T> implements INewNode<T> {

    private T content;
    private List<INewNode<T>> children;

    public NewNode(T content, NewNode<T>... children) {
        this.children = Arrays.asList(children);
        this.content = content;
    }

    @Override
    public T getContent() {
        return content;
    }

    @Override
    public Iterator<INewNode<T>> iterator() {
        if (children == null) {
            return null;
        }
        return children.iterator();
    }
}
