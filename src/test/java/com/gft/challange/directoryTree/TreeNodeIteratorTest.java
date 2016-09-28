package com.gft.challange.directoryTree;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.Iterator;

public class TreeNodeIteratorTest {

    @Test
    public void testHasNext() throws Exception {

    }

    @Test
    public void testNext() throws Exception {
        TreeNode rootNode = prepareExampleTreeNodeMock("1");
        TreeNode node11 = prepareExampleTreeNodeMock("11");
        TreeNode node12 = prepareExampleTreeNodeMock("12");
        TreeNode node111 = prepareExampleTreeNodeMock("111");
        TreeNode node112 = prepareExampleTreeNodeMock("112");
        TreeNode node121 = prepareExampleTreeNodeMock("121");
        TreeNode node122 = prepareExampleTreeNodeMock("122");
        rootNode.addChildNode(node11);
        rootNode.addChildNode(node12);
        node11.addChildNode(node111);
        node11.addChildNode(node112);
        node12.addChildNode(node121);
        node12.addChildNode(node122);

        Iterator<TreeNode> iterator = rootNode.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getNodeContent().getContents());
        }
    }

    @Test
    public void testNextOnFileSystem() throws Exception {
        TreeNode rootNode = new DirectoryTreeNode(Paths.get("c:\\PROJECTS\\TEMPO"));
        Iterator<TreeNode> iterator = rootNode.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getNodeContent().getContents());
        }
    }


    private TreeNode prepareExampleTreeNodeMock(String content) {
        TreeNode treeNode = new TreeNodeMock(content);
        return treeNode;
    }
}