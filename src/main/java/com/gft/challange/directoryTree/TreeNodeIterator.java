package com.gft.challange.directoryTree;

import java.util.Iterator;
import java.util.Stack;

public class TreeNodeIterator<T> implements Iterator<TreeNode<T>> {

    private TreeNode<T> rootNode;
    private TreeNode<T> lastProcessedNode;
    private Stack<TreeLevel> treeLevels;

    public TreeNodeIterator(TreeNode root) {
        this.rootNode = root;
        this.treeLevels = new Stack<>();
        this.treeLevels.push(new TreeLevel(root));
    }

    @Override
    public boolean hasNext() {
        return !isRootNodeProcessed();
    }

    private boolean isNextNodeAvailableOnSameLvl() {
        TreeLevel state = treeLevels.peek();
        if (state.hasElementsToProcess()) {
            TreeNode parent = state.getCurrentlyProcessedElement().getParentNode();
            if (parent != null) {
                return state.getCurrentPosition() < parent.getChildren().size();
            } else {
                return state.getCurrentPosition() < 1;
            }
        }
        return false;
    }

    @Override
    public TreeNode<T> next() {
        while (!treeLevels.empty()) {
            while (isNextNodeAvailableOnSameLvl()) { //mysle ze tu bedzie problem kiedy osiagniemy ostatni element na danym levelu. Nie zostanie przetworzony
                TreeLevel levelState = treeLevels.peek();
                TreeNode node = levelState.getCurrentlyProcessedElement();
                if (node.hasChildNodes()) {
                    goDown(node);
                } else {
                    return updateLevelState(node);
                }
            }
            //going up until unprocessed node (directory) found
            if (treeLevels.size() > 1) {
                TreeLevel higherLevelState = goUp();
                lastProcessedNode = higherLevelState.getCurrentlyProcessedElement();
            } else {
                lastProcessedNode = rootNode;
            }
            updateLevelState(lastProcessedNode);
            return lastProcessedNode;

        }
        return lastProcessedNode;
    }

    private boolean isRootNodeProcessed() {
        return rootNode.equals(lastProcessedNode);
    }

    private TreeNode<T> updateLevelState(TreeNode<T> processedNode) {
        lastProcessedNode = processedNode;
        TreeLevel currentLevelState = treeLevels.peek();
        currentLevelState.setCurrentPosition(currentLevelState.getCurrentPosition() + 1);
        return lastProcessedNode;
    }

    private TreeLevel goDown(TreeNode node) {
        TreeLevel levelState = new TreeLevel(node);
        treeLevels.push(levelState);
        return levelState;
    }

    private TreeLevel goUp() {
        treeLevels.pop();
        return treeLevels.peek();
    }
}
