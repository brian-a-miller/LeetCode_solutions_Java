package dev.brianmiller.leet.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import dev.brianmiller.leet.Problem31_NextPermutation;

public class Problem31Test {

    @Test
    public void test_1_3_2() {

        final int[] nums = new int[] { 1, 3, 2 };
        final int[] expected = new int[] { 2, 1, 3 };

        doTest(nums, expected);
    }

    private void doTest(int[] nums, int[] expectedResult) {

        System.out.println("Input: " + Arrays.toString(nums));

        Problem31_NextPermutation.nextPermutation(nums);

        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("Expected: " + Arrays.toString(expectedResult));

        Assert.assertNotNull(nums);
        Assert.assertEquals(expectedResult.length,nums.length);
        for (int i = 0; i < expectedResult.length; i++) {
            Assert.assertEquals("Unexpected value at index " + i, expectedResult[i], nums[i]);
        }
    }
}
