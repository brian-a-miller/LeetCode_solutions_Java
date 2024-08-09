package dev.brianmiller.leet.test;

import dev.brianmiller.leet.Problem13_RomanToInteger;
import org.junit.Assert;
import org.junit.Test;

public class Problem13Test {

    @Test
    public void romanToInt_test1() {

        final String input = "III";
        final int expected = 3;

        final int actual = Problem13_RomanToInteger.romanToInt(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void romanToInt_test2() {

        final String input = "LVIII";
        final int expected = 58;

        final int actual = Problem13_RomanToInteger.romanToInt(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void romanToInt_test3() {

        final String input = "MCMXCIV";
        final int expected = 1994;

        final int actual = Problem13_RomanToInteger.romanToInt(input);

        Assert.assertEquals(expected, actual);
    }

}
