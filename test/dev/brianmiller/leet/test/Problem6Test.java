package dev.brianmiller.leet.test;

import org.junit.Assert;
import org.junit.Test;

import dev.brianmiller.leet.Problem6_ZigzagConversion;

public class Problem6Test {

    @Test
    public void example1() {

        final String inputString1 = "PAYPALISHIRING";
        final int inputNumRows1 = 3;
        final String expectedOutput1 = "PAHNAPLSIIGYIR";

        String actualOutput1 = Problem6_ZigzagConversion.convert(inputString1,
                inputNumRows1);

        Assert.assertNotNull(actualOutput1);
        Assert.assertEquals(expectedOutput1, actualOutput1);
    }

    @Test
    public void example2() {

        final String inputString2 = "PAYPALISHIRING";
        final int inputNumRows2 = 4;
        final String expectedOutput2 = "PINALSIGYAHRPI";

        String actualOutput2 = Problem6_ZigzagConversion.convert(inputString2,
                inputNumRows2);

        Assert.assertNotNull(actualOutput2);
        Assert.assertEquals(expectedOutput2, actualOutput2);
    }

    @Test
    public void example3() {

        final String inputString3 = "A";
        final int inputNumRows3 = 1;
        final String expectedOutput3 = "A";

        String actualOutput3 = Problem6_ZigzagConversion.convert(inputString3,
                inputNumRows3);

        Assert.assertNotNull(actualOutput3);
        Assert.assertEquals(expectedOutput3, actualOutput3);
    }
}