package com.gft.challange.directoryTree.newVersion;

import org.junit.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class NewTreeIteratorTest {

    @Test
    public void testNext_symetricTree() throws Exception {
        NewNode<String> node121 = new NewNode<String>("121");
        NewNode<String> node122 = new NewNode<String>("122");
        NewNode<String> node111 = new NewNode<String>("111");
        NewNode<String> node112 = new NewNode<String>("112");

        NewNode<String> node11 = new NewNode<String>("11", node111, node112);
        NewNode<String> node12 = new NewNode<String>("12", node121, node122);
        NewNode<String> node1 = new NewNode<String>("1", node11, node12);

        Iterator<INewNode<String>> iterator = new NewTreeIterator<>(node1);

        INewNode<String> node = iterator.next();
        assertThat(node.getContent()).isEqualTo("11");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("111");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("112");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("12");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("121");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("122");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("1");
    }


    @Test
    public void testNext_notSymetricTree() throws Exception {
        NewNode<String> node111 = new NewNode<String>("111");
        NewNode<String> node112 = new NewNode<String>("112");
        NewNode<String> node121 = new NewNode<String>("121");
        NewNode<String> node1221 = new NewNode<String>("1221");
        NewNode<String> node1222 = new NewNode<String>("1222");
        NewNode<String> node122 = new NewNode<String>("122", node1221, node1222);

        NewNode<String> node11 = new NewNode<String>("11", node111, node112);
        NewNode<String> node12 = new NewNode<String>("12", node121, node122);
        NewNode<String> node1 = new NewNode<String>("1", node11, node12);

        Iterator<INewNode<String>> iterator = new NewTreeIterator<>(node1);

        INewNode<String> node = iterator.next();
        assertThat(node.getContent()).isEqualTo("11");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("111");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("112");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("12");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("121");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("122");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("1221");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("1222");
        node = iterator.next();
        assertThat(node.getContent()).isEqualTo("1");
    }

    @Test
    public void testHasNext_onlyRoot() throws Exception {
        NewNode<String> node1 = new NewNode<String>("1");
        Iterator<INewNode<String>> iterator = new NewTreeIterator<>(node1);
        assertThat(iterator.hasNext()).isTrue();
        iterator.next();
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNext_noMoreElements() throws Exception {
        NewNode<String> node1 = new NewNode<String>("1");
        Iterator<INewNode<String>> iterator = new NewTreeIterator<>(node1);
        assertThat(iterator.hasNext()).isTrue();
        iterator.next();
        assertThat(iterator.hasNext()).isFalse();
        iterator.next();
    }
}