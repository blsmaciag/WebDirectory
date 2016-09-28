package com.gft.challange.directoryTree.newVersion;

import java.util.Iterator;
import java.util.Stack;

public class NewTreeIterator<T> implements Iterator<INewNode<T>> {

    private INewNode<T> root;
    private Stack<Iterator<INewNode<T>>> stack = new Stack<>();

    public NewTreeIterator(INewNode<T> root) {
        if (root == null) {
            throw new RuntimeException("Tree root can't be null");
        }
        this.root = root;
        stack.push(root.iterator());
    }

    @Override
    public boolean hasNext() {
        return !stack.empty();
    }

    @Override
    public INewNode<T> next() {
        if (stack.empty()) {
            throw new UnsupportedOperationException("This iterator has no ore elemetns");
        }
        INewNode<T> currentNode = null;
        Iterator<INewNode<T>> iterator = stack.peek();
        if (iterator.hasNext()) {
            currentNode = iterator.next();
            stack.push(currentNode.iterator());
        } else {
            do {
                stack.pop();
                if (!stack.empty()) {
                    iterator = stack.peek();
                    if (iterator.hasNext()) {
                        currentNode = iterator.next();
                        stack.push(currentNode.iterator());
                        return currentNode;
                    }
                }
            } while (!stack.empty());
            return root;
        }
        return currentNode;
    }
}
