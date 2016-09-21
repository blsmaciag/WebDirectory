package com.gft.challange.directoryTree;

public class TreeLevelState {

    private int currentPosition;
    private TreeNode parentElement;

    public TreeLevelState(TreeNode parentElement) {
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
