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
        this.treeLevels.push(new TreeLevelState(0, root));
    }

    @Override
    public boolean hasNext() {
        return !isRootNodeProcessed();
    }

    private boolean isNodeAvailable(TreeLevelState state) {
        TreeNode parent = state.getCurrentElement().getParentNode();
        if(parent != null) {
            return state.getCurrentPosition() < parent.getChildren().size();
        } else {
            return state.getCurrentPosition() < 1;
        }

    }

    @Override
    public TreeNode next() {
        TreeLevelState levelState = treeLevels.peek();
        //going down until finding a leaf
        while (!isRootNodeProcessed()) {
            while (isNodeAvailable(levelState)) {
                TreeNode node = levelState.getCurrentElement();
                if (node.hasChildNodes()) {
                    goDown(node);
                } else {
                    return markAsProcessedAndReturn(node);
                }
            }
            //going up until unprocessed node (directory) found
            if(treeLevels.size() > 0){
                TreeLevelState treeLevelState = goUp();
                return treeLevelState.getCurrentElement();
            } else {
                lastProcessedNode = rootNode;
                return rootNode;
            }

        }
        return lastProcessedNode;
    }

    private boolean isRootNodeProcessed() {
        return rootNode.equals(lastProcessedNode);
    }

    private TreeNode markAsProcessedAndReturn(TreeNode processedNode) {
        lastProcessedNode = processedNode;
        return lastProcessedNode;
    }

    private TreeLevelState goDown(TreeNode node) {
        TreeLevelState levelState = new TreeLevelState(0, node.getChildren().get(0));
        treeLevels.push(levelState);
        return levelState;
    }

    private TreeLevelState goUp() {
        return treeLevels.pop();
    }
}
