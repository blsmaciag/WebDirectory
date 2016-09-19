package com.gft.challange.directoryTree;

import org.junit.Test;

import java.util.Iterator;

public class TreeNodeIteratorTest {



    @Test
    public void testHasNext() throws Exception {

    }

    @Test
    public void testNext() throws Exception {
        TreeNode rootNode = prepareExampleTreeNode("1");
        TreeNode node11 = prepareExampleTreeNode("11");
        TreeNode node12 = prepareExampleTreeNode("12");
        TreeNode node111 = prepareExampleTreeNode("111");
        TreeNode node112 = prepareExampleTreeNode("112");
        TreeNode node121 = prepareExampleTreeNode("121");
        TreeNode node122 = prepareExampleTreeNode("122");
        rootNode.addChildNode(node11);
        rootNode.addChildNode(node12);
        node11.addChildNode(node111);
        node11.addChildNode(node112);
        node12.addChildNode(node121);
        node12.addChildNode(node122);

        Iterator<TreeNode> iterator = rootNode.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getNodeContent().getContent());
        }


    }

    private TreeNode prepareExampleTreeNode(String content){
        DirectoryTreeNode directoryTreeNode = new DirectoryTreeNode();
        directoryTreeNode.setContent(new TreeNodeContent<String>(content));
        return directoryTreeNode;
    }
}