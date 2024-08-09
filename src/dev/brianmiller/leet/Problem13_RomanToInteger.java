package dev.brianmiller.leet;

public class Problem13_RomanToInteger {

    public static int romanToInt(String s) {
        if (s == null) {
            throw new IllegalArgumentException("input string must not be null");
        }
        if (s.isBlank()) {
            throw new IllegalArgumentException("input string must contain Roman numerals, can not be empty/blank");
        }
        int result = 0;
        String tmp = s;
        while (!tmp.isEmpty()) {
            if (tmp.startsWith("M")) {
                result = result + 1000;
                tmp = tmp.substring(1);
            } else if (tmp.startsWith("D")) {
                result = result + 500;
                tmp = tmp.substring(1);
            } else if (tmp.startsWith("CM")) {
                result = result + 900;
                tmp = tmp.substring(2);
            } else if (tmp.startsWith("CD")) {
                result = result + 400;
                tmp = tmp.substring(2);
            } else if (tmp.startsWith("C")) {
                result = result + 100;
                tmp = tmp.substring(1);
            } else if (tmp.startsWith("L")) {
                result = result + 50;
                tmp = tmp.substring(1);
            } else if (tmp.startsWith("XC")) {
                result = result + 90;
                tmp = tmp.substring(2);
            } else if (tmp.startsWith("XL")) {
                result = result + 40;
                tmp = tmp.substring(2);
            } else if (tmp.startsWith("X")) {
                result = result + 10;
                tmp = tmp.substring(1);
            } else if (tmp.startsWith("V")) {
                result = result + 5;
                tmp = tmp.substring(1);
            } else if (tmp.startsWith("IX")) {
                result = result + 9;
                tmp = tmp.substring(2);
            } else if (tmp.startsWith("IV")) {
                result = result + 4;
                tmp = tmp.substring(2);
            } else if (tmp.startsWith("I")) {
                result = result + 1;
                tmp = tmp.substring(1);
            }
        }
        return result;
    }
}
