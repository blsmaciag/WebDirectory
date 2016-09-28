package com.gft.challange.directoryTree.newVersion;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class NewTreeIteratorTest {

    @Test
    public void testNext() throws Exception {
        NewNode<String> node121 = new NewNode<String>("121");
        NewNode<String> node122 = new NewNode<String>("122");
        NewNode<String> node111 = new NewNode<String>("111");
        NewNode<String> node112 = new NewNode<String>("112");

        NewNode<String> node11 = new NewNode<String>("11", node111, node112);
        NewNode<String> node12 = new NewNode<String>("12", node121, node122);
        NewNode<String> node1 = new NewNode<String>("1", node11, node12);

        Iterator<NewNode<String>> iterator = new NewTreeIterator<>(node1);


        NewNode<String> node = iterator.next();
        assertEquals("11", node.getContent());
        node = iterator.next();
        assertEquals("111", node.getContent());
        node = iterator.next();
        assertEquals("112", node.getContent());
        node = iterator.next();
        assertEquals("12", node.getContent());
        node = iterator.next();
        assertEquals("121", node.getContent());
        node = iterator.next();
        assertEquals("122", node.getContent());
        node = iterator.next();
        assertEquals("1", node.getContent());
    }


    @Test
    public void testNext2() throws Exception {
        NewNode<String> node111 = new NewNode<String>("111");
        NewNode<String> node112 = new NewNode<String>("112");
        NewNode<String> node121 = new NewNode<String>("121");
        NewNode<String> node1221 = new NewNode<String>("1221");
        NewNode<String> node1222 = new NewNode<String>("1222");
        NewNode<String> node122 = new NewNode<String>("122", node1221, node1222);

        NewNode<String> node11 = new NewNode<String>("11", node111, node112);
        NewNode<String> node12 = new NewNode<String>("12", node121, node122);
        NewNode<String> node1 = new NewNode<String>("1", node11, node12);

        Iterator<NewNode<String>> iterator = new NewTreeIterator<>(node1);

        NewNode<String> node = iterator.next();
        //assertEquals("11", node.getContent());
        System.out.println(node.getContent());
        node = iterator.next();
        System.out.println(node.getContent());
        assertEquals("111", node.getContent());
        node = iterator.next();
        System.out.println(node.getContent());
        assertEquals("112", node.getContent());
        node = iterator.next();
        System.out.println(node.getContent());
        assertEquals("12", node.getContent());
        node = iterator.next();
        System.out.println(node.getContent());
        assertEquals("121", node.getContent());
        node = iterator.next();
        System.out.println(node.getContent());
        assertEquals("122", node.getContent());
        node = iterator.next();
        System.out.println(node.getContent());
        assertEquals("1221", node.getContent());
        node = iterator.next();
        System.out.println(node.getContent());
        assertEquals("1222", node.getContent());
        node = iterator.next();
        System.out.println(node.getContent());
        assertEquals("1", node.getContent());
    }
}