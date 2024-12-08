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



    /*
        minOpenBracket:

        Tracks the minimum possible number of unmatched opening parentheses ( at any point.
        This can go down (decrease) because * can act as a closing parenthesis ) or be ignored entirely.
        It is reset to 0 whenever it becomes negative, because negative values would mean there are no unmatched opening brackets at that point.

        maxOpenBracket:

        Tracks the maximum possible number of unmatched opening parentheses (.
        This increases for each ( or * that could act as an opening parenthesis.

        The condition minOpenBracket == 0 ensures that after processing the string,
        all unmatched ( (if any) have been successfully balanced by corresponding ) or *.
    */


    public static boolean checkValidString(String s) {
        int minOpenBracket = 0; // minimum open bracket
        int maxOpenBracket = 0; // maximum open bracket

        for (char ch : s.toCharArray()) {
            if (ch == '(') { // increment both
                minOpenBracket += 1;
                maxOpenBracket += 1;
            } else if (ch == ')') { // decrement both
                minOpenBracket -= 1;
                maxOpenBracket -= 1;
            } else { // means a wild character, so we have two choice either consider as open or close bracket
                // if consider close bracket
                minOpenBracket -= 1;
                // if consider open bracket
                maxOpenBracket += 1;
            }

            if (maxOpenBracket < 0) { // this means close bracket are more than open bracket
                // Currently, don't have enough open parentheses to match close parentheses-> Invalid
                // For example: ())(
                return false;
            }
            // since we know open bracket are not less than close bracket from the above condition, we try to continue to find a valid solution
            // exist or not
            if (minOpenBracket < 0) { // if this condition is not put then we will get true for s = (*)*(
                minOpenBracket = 0;  // It's invalid if open parentheses count < 0 that's why leftMin can't be negative
            }
        }
        return minOpenBracket == 0; // Return true if you found `openCount == 0` in range [leftMin, leftMax]
    }

}
