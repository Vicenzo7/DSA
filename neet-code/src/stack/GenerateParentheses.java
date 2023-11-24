package stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, n, "", 0, 0);

        return result;
    }

    private static void generate(List<String> result, int n, String s, int openCount, int closedCount) {
        /*
            Only add open parentheses is open < n
            Only add closed parentheses is close < open
            Valid if and only if open == closed == n
        */
        // base case
        if (openCount == n && closedCount == n) {
            result.add(s);
            return;
        }

        // add open parentheses
        if (openCount < n) {
            generate(result, n, s + "(", openCount + 1, closedCount);
        }

        // add closed parentheses
        if (closedCount < openCount) {
            generate(result, n, s + ")", openCount, closedCount + 1);
        }
    }
}
