package com.clouway.test.tasks;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by clouway on 8/18/15.
 */
public class Sumator {

    public String sum(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }

        int s = Integer.parseInt(a);
        int t = Integer.parseInt(b);

        return a + b;
    }
}
