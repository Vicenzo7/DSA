package company.wayfair;

import java.util.ArrayList;
import java.util.List;

public class AddTwoLargeStrings {
    public static void main(String[] args) {
        String a = "1,534,467";
        String b = "1,235,113";


        validate(a);
        validate(b);

        String x = addTwoLargeString(a, b);
        System.out.println(x);
        List<String> list = generateFirstNFibonacci(10);
        System.out.println(list);
    }

    private static void validate(String number) {
        if (!number.matches("[0-9,]*")) {
            throw new IllegalArgumentException("Invalid input: contains special characters." +
                    " Only digits and commas are allowed");
        }
    }

    private static List<String> generateFirstNFibonacci(int n) {
        String first = "0";
        String second = "1";
        List<String> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        for (int i = 2; i < n; i++) {
            String next = addTwoLargeString(first, second);
            result.add(next);
            first = second;
            second = next;
        }
        return result;
    }

    private static String insertComma(String x) {
        int n = x.length();
        int commas = (n - 1) / 3;
        StringBuilder sb = new StringBuilder(x);
        for (int i = 1; i <= commas; i++) {
            sb.insert(n - 3 * i, ",");
        }

        return sb.toString();
    }

    static
    private String addTwoLargeString(String a, String b) {
        a = a.replaceAll(",", "");
        b = b.replaceAll(",", "");
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? a.charAt(i--) - '0' : 0;
            int y = j >= 0 ? b.charAt(j--) - '0' : 0;

            sum = x + y + carry;
            carry = sum > 9 ? 1 : 0;
            sb.append(sum % 10);
        }

        String result = sb.reverse().toString();
        return insertComma(result);
    }
}
