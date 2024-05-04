package com.coderscampus.arraylist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomArrayListTest {
    private CustomList<Integer> list;

    @Before
    public void setUp() {
        list = new CustomArrayList<>();
    }

    @Test
    public void testAddAndGet() {
        list = new CustomArrayList<>();
        list.add(20);
        list.add(40);
        list.add(60);
        list.add(50);

        assertEquals(4, list.getSize());
        assertEquals(Integer.valueOf(20), list.get(0));
        assertEquals(Integer.valueOf(40), list.get(1));
        assertEquals(Integer.valueOf(60), list.get(2));
        assertEquals(Integer.valueOf(50), list.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndex() {
        list.add(5);
        list.add(6);
        list.add(7);
        list.get(20);
    }

    @Test
    public void testAddAnItemAtAGivenIndex() {
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1, 100);
        // [5, 6, 7]
        // [5, 100, 6, 7]
        assertEquals(4, list.getSize());
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(Integer.valueOf(100), list.get(1));

    }

    @Test
    public void removeAtIndex(){
        list.add(55);
        list.add(46);
        list.add(67);
        list.remove(0);
    }
}
