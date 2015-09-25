package com.clouway.array;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by clouway on 15-9-25.
 */
public class ArrayTest {
    @Test
    public void getArrayMinimalElement() {
        Array arr = new Array();
        assertEquals(4, arr.getMinimalElement(new int[]{22, 55, 77, 4, 9, 23}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void minElementOfEmptyArray() {
        Array arr = new Array();
        arr.getMinimalElement(new int[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void miniElementNullPointer() {
        Array arr = new Array();
        arr.getMinimalElement(null);
    }

    @Test
    public void arraySum() {
        Array arr = new Array();
        assertEquals(30, arr.getSum(new int[]{2, 4, 6, 8, 10}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void arraySumOfEmptyArray() {
        Array arr = new Array();
        arr.getSum(new int[]{});
    }

    @Test
    public void arraySumNullPointer() {
        try {
            Array arr = new Array();
            arr.getSum(null);
            fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException ill) {
            System.out.println("Wrong insertion!");
        }
    }

    @Test
    public void printArray(){
        Array arr = new Array();
        ArrayOutput arrayOutput = new ArrayOutput();
        arr.printArray(new int[]{1,2,3,4,5},arrayOutput);
        assertThat(" 1 2 3 4 5",is(equalTo(arrayOutput.getArray())));

    }
}
