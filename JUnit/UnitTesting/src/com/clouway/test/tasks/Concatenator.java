package com.clouway.test.tasks;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author  ivaylo_penev<ipenev91@gmail.com> on 9/18/15.
 */
public class Concatenator {

    /**
     *
     * @param a is first String
     * @param b is second String
     * @return concatenated Strings
     */

    public String concatenation(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }

        int s = Integer.parseInt(a);
        int t = Integer.parseInt(b);

        return a + b;
    }
}
