package strings.easy;

public class RemoveOuterMostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }


    /*

    Solution
    Keep a count of open parenthesis
    Iterate the string
    if the char is '(' and count++ > 0 -> append the char to the ans.
    if the char is ')' and count-- > 1 -> append the char to the ans.

    Hint : on count == 1, we add openParenthesis and on count == 2 we add close parenthesis





    */
    public static String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
}
