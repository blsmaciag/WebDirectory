package com.gft.challange.directoryTree;

public class TreeLevel<T> {

    private int currentPosition;
    private TreeNode<T> parentElement;

    public TreeLevel(TreeNode parentElement) {
        this.currentPosition = 0;
        this.parentElement = parentElement;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public TreeNode getCurrentlyProcessedElement() {
        return parentElement.getChildren().get(currentPosition);
    }

    public boolean hasElementsToProcess() {
        return parentElement.getChildren().size() > currentPosition;
    }
}
