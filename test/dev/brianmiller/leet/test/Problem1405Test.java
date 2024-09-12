package dev.brianmiller.leet.test;

import org.junit.Assert;
import org.junit.Test;

import dev.brianmiller.leet.Problem1405_LongestHappyString;

public class Problem1405Test {

    @Test
    public void example1() {
        final int a = 1;
        final int b = 1;
        final int c = 7;

        final String output = Problem1405_LongestHappyString.longestDiverseString(a, b, c);

        System.out.printf("Inputs: a=%d, b=%d, c=%d%n", a, b, c);
        System.out.println("Output: " + output);

        Assert.assertNotNull(output);
        Assert.assertEquals(8, output.length());

    }
}
