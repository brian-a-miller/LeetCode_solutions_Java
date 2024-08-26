package dev.brianmiller.leet;

public class Problem415_AddStrings {

    /**
     * @author Brian A. Miller
     * @date November 10, 2023
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        if ((num1 == null) || (num2 == null) || num1.isEmpty() || num2.isEmpty()) {
            throw new IllegalArgumentException("inputs must not be empty");
        }

// 11, 123
// __4 (1+3=4)(Character.getNumericValue(num1.charAt(num1.length()-1)) +
//.     Character.getNumericValue(num2.charAt(num2.length()-1))
// _34 (1+2=3)
// 134 (0+1=1)
        int num1ptr = num1.length() - 1;
        int num2ptr = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while ((num1ptr >= 0) || (num2ptr >= 0)) {
            int leftDigit = (num1ptr < 0 ? 0 : Character.getNumericValue(num1.charAt(num1ptr)));
            int rightDigit = (num2ptr < 0 ? 0 : Character.getNumericValue(num2.charAt(num2ptr)));
            int tmp = leftDigit + rightDigit + carry;
            if (tmp > 9) {
                carry = 1;
                tmp = tmp - 10;
            } else {
                carry = 0;
            }
            sb.insert(0, tmp);
            num1ptr--;
            num2ptr--;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }

    /**
     * @author Brian A. Miller
     * @date Friday, August 23, 2024
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings_optimized(String num1, String num2) {
        if ((num1 == null) || (num2 == null) || num1.isEmpty() || num2.isEmpty()) {
            throw new IllegalArgumentException("inputs must not be empty");
        }

// 11, 123
// __4 (1+3=4)(Character.getNumericValue(num1.charAt(num1.length()-1)) +
//.     Character.getNumericValue(num2.charAt(num2.length()-1))
// _34 (1+2=3)
// 134 (0+1=1)
        int num1ptr = num1.length() - 1;
        int num2ptr = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while ((num1ptr >= 0) || (num2ptr >= 0)) {
            // int leftDigit = (num1ptr < 0 ? 0 : Character.getNumericValue(num1.charAt(num1ptr)));
            // int rightDigit = (num2ptr < 0 ? 0 : Character.getNumericValue(num2.charAt(num2ptr)));
            int leftDigit = (num1ptr < 0 ? 0 : num1.charAt(num1ptr) - '0');
            int rightDigit = (num2ptr < 0 ? 0 : num2.charAt(num2ptr) - '0');

            int tmp = leftDigit + rightDigit + carry;
            if (tmp > 9) {
                carry = 1;
                tmp = tmp - 10;
            } else {
                carry = 0;
            }
            // sb.insert(0, tmp);
            sb.append(tmp);
            num1ptr--;
            num2ptr--;
        }
        if (carry > 0) {
            // sb.insert(0, carry);
            sb.append(carry);
        }

        // return sb.toString();
        return sb.reverse().toString();
    }
}
