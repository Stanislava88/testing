package com.clouway.arrays;

import com.clouway.test.tasks.Array;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/27/15.
 */
public class ArraysTestDemo {

    private Array arr;

    @Before
    public void initialize() {
        arr = new Array();
    }

    @Test
    public void findMinElementInTheArray() throws Exception {
        assertThat(1, is(arr.getMinElement(new int[]{1, 10, 6, 8, 17, 2, 13})));
    }

    @Test
    public void SumOfArrayElements() throws Exception {
        assertThat(16, is(arr.sum(new int[]{1, 2, 3, 4, 5})));
    }

    @Test
    public void reversedArray() throws Exception {
        int[] expectedArray = new int[]{5, 4, 3, 2, 1};
        assertThat(expectedArray, equalTo(arr.reversedArray(new int[]{1, 2, 3, 4, 5})));
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyArray() throws Exception {
        assertThat(arr.sum(new int[]{}), is(0));
    }

    @Test
    public void printAllElementsOfArray() throws Exception {
        int[] array = new int[]{1, 2, 3};
        assertThat(array, is(arr.printAllElementsOfArray(new int[]{1, 2, 3})));
    }

    @Test
    public void printEmptyArray() throws Exception {
        assertThat(arr.printAllElementsOfArray(new int[]{}), is(new int[]{}));
    }
}