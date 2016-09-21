package com.gft.challange.directoryTree;

import java.util.Iterator;
import java.util.Stack;

public class TreeNodeIterator implements Iterator<TreeNode> {

    private TreeNode rootNode;
    private TreeNode lastProcessedNode;
    private Stack<TreeLevelState> treeLevels;

    public TreeNodeIterator(TreeNode root) {
        this.rootNode = root;
        //this.lastProcessedNode = root;
        this.treeLevels = new Stack<>();
        this.treeLevels.push(new TreeLevelState(root));
    }

    @Override
    public boolean hasNext() {
        return !isRootNodeProcessed();
    }

    private boolean isNextNodeAvailableOnSameLvl() {
        //if (treeLevels.size() == 1 && !rootNode.hasChildNodes()) { //when root has no children
//            return false;
//        }
        TreeLevelState state = treeLevels.peek();
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
    public TreeNode next() {

        while (!treeLevels.empty()) {
            while (isNextNodeAvailableOnSameLvl()) { //mysle ze tu bedzie problem kiedy osiagniemy ostatni element na danym levelu. Nie zostanie przetworzony
                TreeLevelState levelState = treeLevels.peek();
                TreeNode node = levelState.getCurrentlyProcessedElement();
                if (node.hasChildNodes()) {
                    goDown(node);
                } else {
                    return updateLevelState(node);
                }
            }
            //going up until unprocessed node (directory) found
            if (treeLevels.size() > 1) {
                TreeLevelState higherLevelState = goUp();
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

    private TreeNode updateLevelState(TreeNode processedNode) {
        lastProcessedNode = processedNode;
        TreeLevelState currentLevelState = treeLevels.peek();
        currentLevelState.setCurrentPosition(currentLevelState.getCurrentPosition() + 1);
        return lastProcessedNode;
    }

    private TreeLevelState goDown(TreeNode node) {
        TreeLevelState levelState = new TreeLevelState(node);
        treeLevels.push(levelState);
        return levelState;
    }

    private TreeLevelState goUp() {
        treeLevels.pop();
        return treeLevels.peek();
    }
}