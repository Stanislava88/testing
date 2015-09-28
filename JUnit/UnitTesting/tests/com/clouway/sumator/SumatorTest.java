package com.clouway.sumator;

import com.clouway.test.tasks.Sumator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/28/15.
 */
public class SumatorTest {

    private Sumator sumator;

    @Before
    public void initialize() {
        sumator = new Sumator();
    }

    @Test
    public void sumTwoNumbers() {

        assertThat(sumator.sum("2","4"),is("6"));
    }

    @Test(expected = NullPointerException.class)
    public void sumNullArgument() throws Exception {
        sumator.sum("9",null);
    }

    @Test(expected = NumberFormatException.class)
    public void sumInvalidArgument() throws Exception {
        sumator.sum("jdsd","9");
    }

}
