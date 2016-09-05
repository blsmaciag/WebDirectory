package com.gft.challange.websocket;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeClassTest {

    @Test
    public void testAddTwoDigits() {
        int a = 3;
        int b = 4;
        SomeClass someClass = new SomeClass();
        assertEquals(7,someClass.addTwoDigits(a,b));
    }
}