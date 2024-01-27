package greedy;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(*)*(";
        System.out.println(checkValidString(s));
    }

    /*
        Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

        The following rules define a valid string:

        Any left parenthesis '(' must have a corresponding right parenthesis ')'.
        Any right parenthesis ')' must have a corresponding left parenthesis '('.
        Left parenthesis '(' must go before the corresponding right parenthesis ')'.
        '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


        Intuition
        Suppose in our question there was no star then how would we do it?

        we would iterate the string and if it is openParenthesis we would increment openParenthesis count
        if it is closeParenthesis decrement openParenthesis count
        and if openParenthesis count was < 0 at any given time then answer is false because
        ( ( ) ) )
        openCount = 2
        closeCount = 3

        Now with the * -> s = (*)


    */


    public static boolean checkValidString(String s) {
        int leftMin = 0; // minimum open bracket
        int leftMax = 0; // maximum open bracket

        for (char ch : s.toCharArray()) {
            if (ch == '(') { // increment both
                leftMin += 1;
                leftMax += 1;
            } else if (ch == ')') { // decrement both
                leftMin -= 1;
                leftMax -= 1;
            } else { // means a wild character, so we have two choice either consider as open or close bracket
                // if consider close bracket
                leftMin -= 1;
                // if consider open bracket
                leftMax += 1;
            }

            if (leftMax < 0) { // this means close bracket are more than close bracket
                return false;
            }
            // since we know open bracket are not less than close bracket from the above condition, we try to continue to find a valid solution
            // exist or not
            if (leftMin < 0) { // if this condition is not put then we will get true for s = (*)*(
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }

}
