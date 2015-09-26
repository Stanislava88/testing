package com.clouway.sumator;

import com.clouway.test.tasks.Concatenator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author ivaylo_penev<ipenev91@gmail.com> on 9/18/15.
 */
public class Demo {

    private Concatenator concatenator;

    @Before
    public void initialize() {
        concatenator = new Concatenator();
    }


    @Test
    public void concatenateTwoString() {
        assertEquals("IvanPetrov", concatenator.concatenation("Ivan", "Petrov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullArgument() {
        assertThat("IvanPetrov", is(concatenator.concatenation("Ivan", null)));
    }

    @Test(expected = NumberFormatException.class)
    public void differentArgument() {
        assertThat("IvanPetrov", is(concatenator.concatenation("Ivan", "123")));
    }

}
