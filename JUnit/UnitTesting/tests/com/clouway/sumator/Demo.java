package com.clouway.sumator;

import com.clouway.test.tasks.Sumator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by clouway on 8/18/15.
 */
public class Demo {

    private Sumator sumator;

    @Before
    public void initialize() {
        sumator = new Sumator();
    }

    @Test
    public void sumTwoString() {
        assertEquals("IvanPetrov", sumator.sum("Ivan", "Petrov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullArgument() {
        assertThat("IvanPetrov", is(sumator.sum("Ivan", null)));
    }

    @Test(expected = NumberFormatException.class)
    public void differentArgument() {
        assertThat("IvanPetrov", is(sumator.sum("Ivan", "123")));
    }

}
