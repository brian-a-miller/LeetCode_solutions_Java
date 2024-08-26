package dev.brianmiller.leet;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
        //System.out.println("123 * 6 = " + multipleIntegerByDigit("123", '6'));
    }

    public static int multipleIntegerByDigit(String integerStr, char digitChar) {
        if (digitChar == '0' || integerStr == null || integerStr.isEmpty() || integerStr.equals("0")) {
            return 0;
        }
        int sum = 0;
        int y = (int) (digitChar - '0');
        int place = 1;
        int carry = 0;
        for (int i = integerStr.length() - 1; i >= 0; i--) {
            int x = (int) (integerStr.charAt(i) - '0');
            int product = x * y;
            System.out.printf("%d * %d = %d, ", x, y, product);
            if (product < 10) {
                sum = sum + place * (product + carry);
                carry = 0;
            } else {
                int tmp = product % 10;
                sum = sum + place * (tmp + carry);
                carry = product / 10;
            }
            place = place * 10;
            System.out.println("sum = " + sum + ", carry = " + carry + ", place = " + place);
        }

        return sum;
    }

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            throw new IllegalArgumentException("inputs must npt be null or empty strings");
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int sum = 0;
        int place = 1;
        for (int j = num2.length() - 1; j >= 0; j--) {
            char y = num2.charAt(j);
            int thisSum = multipleIntegerByDigit(num1, y);
            sum = sum + (place * thisSum);
            place *= 10;
        }

        StringBuilder resultSB = new StringBuilder();
        System.out.println("sum = " + sum);
        while (sum > 9) {
            System.out.println("sum = " + sum);
            int tmp = sum % 10;
            if (resultSB.isEmpty()) {
                resultSB.append(tmp);
            } else {
                resultSB.insert(0, tmp);
            }
            sum = sum / 10;
        }
        resultSB.insert(0, sum);
        return resultSB.toString();
    }
}
