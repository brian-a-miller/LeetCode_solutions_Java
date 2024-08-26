package dev.brianmiller.leet.test;

import org.junit.Assert;
import org.junit.Test;

// TODO
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
//import org.junit.runner.RunWith;

import dev.brianmiller.leet.Problem66_PlusOne;
import org.junit.Test;

import java.util.Arrays;

public class Problem66Test {
// TODO
    // @Parameters


    @Test
    public void example1() {

        final int[] inputDigits = new int[] {1, 2, 3};
        final int[] expectedOutput = new int[] {1, 2, 4};

        doTest(inputDigits, expectedOutput);
    }

    @Test
    public void example2() {

        final int[] inputDigits = new int[] { 4, 3, 2, 1 };
        final int[] expectedOutput = new int[] { 4, 3, 2, 2 };

        doTest(inputDigits, expectedOutput);
    }

    @Test
    public void example3() {

        final int[] inputDigits = new int[] { 9 };
        final int[] expectedOutput = new int[] { 1, 0 };

        doTest(inputDigits, expectedOutput);
    }

    private void doTest(int[] inputDigits, int[] expectedOutput) {
        int[] actualOutput = Problem66_PlusOne.plusOne(inputDigits);

        System.out.println("Input: " + Arrays.toString(inputDigits));
        System.out.println("Output: " + Arrays.toString(actualOutput));

        Assert.assertNotNull("plusOne returned null", actualOutput);
        Assert.assertEquals("plusOne returned array of unexpected size",
                expectedOutput.length, actualOutput.length);
        for (int i = 0; i < expectedOutput.length; i++) {
            Assert.assertEquals("unexpected value at index " + i,
                    expectedOutput[i], actualOutput[i]);
        }
    }
}