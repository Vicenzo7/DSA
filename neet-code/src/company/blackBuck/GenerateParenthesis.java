package company.blackBuck;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("", n, 0, 0, ans);

        return ans;
    }

    private static void generate(String s, int n, int openCount, int closeCount, List<String> ans) {
        if (s.length() == n * 2) {
            ans.add(s);
            return;
        }

        if (openCount < n) {
            generate(s + "{", n, openCount + 1, closeCount, ans);
        }

        if (closeCount < openCount) {
            generate(s + "}", n, openCount, closeCount + 1, ans);
        }
    }
}
