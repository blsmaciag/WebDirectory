package com.gft.challange.directoryTree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RootNodeIterator implements Iterator<TreeNode> {

    private TreeNode root;
    private boolean used = false;

    public RootNodeIterator(TreeNode root) {
        this.root = root;
    }

    @Override
    public boolean hasNext() {
        return !used;
    }

    @Override
    public TreeNode next() {
        if(!used) {
            used = true;
            return root;
        } else {
            throw new NoSuchElementException();
        }
    }
}
