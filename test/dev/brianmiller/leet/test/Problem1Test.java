package dev.brianmiller.leet.test;

import dev.brianmiller.leet.Problem1_TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class Problem1Test {

    @Test
    public void twoSum_test1() {
        final int[] nums = new int[] { 2, 7, 11, 15 };
        final int target = 9;

        int[] result = Problem1_TwoSum.twoSum(nums, target);

        Assert.assertNotNull(result);
        Assert.assertNotEquals(0, result.length);
        Assert.assertEquals(2, result.length);

        int sum = nums[result[0]] + nums[result[1]];

        Assert.assertEquals(target, sum);

        Assert.assertEquals(0, result[0]);
        Assert.assertEquals(1, result[1]);
    }

    @Test
    public void twoSum_test2() {
        final int[] nums = new int[] { 3, 2, 4 };
        final int target = 6;

        int[] result = Problem1_TwoSum.twoSum(nums, target);

        Assert.assertNotNull(result);
        Assert.assertNotEquals(0, result.length);
        Assert.assertEquals(2, result.length);

        int sum = nums[result[0]] + nums[result[1]];

        Assert.assertEquals(target, sum);

        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(2, result[1]);
    }

    @Test
    public void twoSum_test3() {
        final int[] nums = new int[] { 3, 3 };
        final int target = 6;

        int[] result = Problem1_TwoSum.twoSum(nums, target);

        Assert.assertNotNull(result);
        Assert.assertNotEquals(0, result.length);
        Assert.assertEquals(2, result.length);

        int sum = nums[result[0]] + nums[result[1]];

        Assert.assertEquals(target, sum);

        Assert.assertEquals(0, result[0]);
        Assert.assertEquals(1, result[1]);
    }
}
