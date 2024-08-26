package dev.brianmiller.leet;

public class Problem67_AddBinary {

    /**
     * @author Brian A. Miller
     * @date Friday, August 23, 2024
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.isBlank() || b.isBlank()) {
            throw new IllegalArgumentException("inputs must not be null or empty strings");
        }
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }
        StringBuilder resultSB = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while ((i >= 0) || (j >= 0)) {
            int aDigit = (i >= 0 ? a.charAt(i) - '0' : 0);
            int bDigit = (j >= 0 ? b.charAt(j) - '0' : 0);
            int sum = aDigit + bDigit + carry;
            if (sum < 2) {
                resultSB.append((char)('0' + sum));
                carry = 0;
            } else if (sum == 2) {
                resultSB.append("0");
                carry = 1;
            } else if (sum == 3) {
                resultSB.append("1");
                carry = 1;
            }
            i--;
            j--;
        }
        if (carry == 1) {
            resultSB.append("1");
        }
        return resultSB.reverse().toString();
    }
}
