package com.gft.challange.directoryTree;

/**
 * Created by bzmg on 2016-09-09.
 */
public class TreeLevelState {

    int currentPosition;
    TreeNode currentElement;

    public TreeLevelState(int currentPosition, TreeNode currentElement) {
        this.currentPosition = currentPosition;
        this.currentElement = currentElement;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public TreeNode getCurrentElement() {
        return currentElement;
    }
}
