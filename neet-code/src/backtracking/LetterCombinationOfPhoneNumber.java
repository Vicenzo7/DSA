package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> digitToStringMap = new HashMap<>() {{
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }};

        List<String> result = new ArrayList<>();
        dfs(0, new StringBuilder(), digits, result, digitToStringMap);
        return result;
    }

    private static void dfs(int index, StringBuilder processed, String digits, List<String> result, Map<Integer, String> digitToStringMap) {

        if (index == digits.length()) {
            result.add(processed.toString());
            return;
        }

        char ch = digits.charAt(index);
        int key = Integer.parseInt(String.valueOf(ch));
        String value = digitToStringMap.get(key);
        for (int i = 0; i < value.length(); i++) {
            processed.append(value.charAt(i));
            dfs(index + 1, processed, digits, result, digitToStringMap);
            processed.deleteCharAt(processed.length() - 1);
        }

    }
}
