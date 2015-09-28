package com.clouway.test.tasks;

import org.junit.Before;

import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/27/15.
 */
public class Sumator {

    /**
     *
     * @param a is first number
     * @param b is second number
     * @return sum of numbers
     */

    public String sum(String a, String b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }

        Integer s = Integer.parseInt(a);
        Integer t = Integer.parseInt(b);

        Integer sum = s +t;

        return Integer.toString(sum);
    }
}
