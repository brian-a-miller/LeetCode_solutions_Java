package dev.brianmiller.leet.test;

import org.junit.Assert;
import org.junit.Test;

import dev.brianmiller.leet.Problem167_TwoSumIIInputArrayIsSorted;

public class Problem167Test {

    @Test
    public void example1() {

        final int[] inputNumbers = new int[] { 2, 7, 11, 15 };
        final int inputTarget = 9;

        int[] output = Problem167_TwoSumIIInputArrayIsSorted.twoSum(inputNumbers,
                inputTarget);

        Assert.assertNotNull(output);
        Assert.assertEquals(2, output.length);
        Assert.assertEquals(1, output[0]);
        Assert.assertEquals(2, output[1]);
    }

    @Test
    public void example2() {

        final int[] inputNumbers = new int[] { 2, 3, 4 };
        final int inputTarget = 6;
        final int[] expectedResult = new int[] { 1, 3 };

        int[] output = Problem167_TwoSumIIInputArrayIsSorted.twoSum(inputNumbers,
                inputTarget);

        Assert.assertNotNull(output);
        Assert.assertEquals(expectedResult.length, output.length);
        for (int i = 0; i < expectedResult.length; i++) {
            Assert.assertEquals(expectedResult[i], output[i]);
        }
    }

    @Test
    public void example3() {

        final int[] inputNumbers = new int[] { -1, 0 };
        final int inputTarget = -1;
        final int[] expectedResult = new int[] { 1, 2 };

        int[] output = Problem167_TwoSumIIInputArrayIsSorted.twoSum(inputNumbers,
                inputTarget);

        Assert.assertNotNull(output);
        Assert.assertEquals(expectedResult.length, output.length);
        for (int i = 0; i < expectedResult.length; i++) {
            Assert.assertEquals(expectedResult[i], output[i]);
        }
    }
}
