package strings.medium;

public class MaximumNestingDepthOfParentheses {
    public static void main(String[] args) {

        String s = "((1+(2*3)+((8)/4))+1"; // should be a valid parentheses string
        System.out.println(maxDepth(s));
    }


    /*
        Intuition
        -> Iterate the string and maintain two counter
            count and maxCount
            if char == '(' count++
            if char == ')' count--
            maxCount = Math.max(count,maxCount)

            return maxCount;

            Inside the loop:

            If the current character c is an opening parenthesis '(', increment the count variable.
            This indicates that we are going one level deeper in nesting.

            If the current character c is a closing parenthesis ')', decrement the count variable.
            This indicates that we are moving one level up in nesting.

            Update maxCount to be the maximum of the current count and the previous maxCount.
            This step ensures that maxCount always holds the maximum nesting depth encountered during the iteration.

            TC = O(n).
    */

    public static int maxDepth(String s) {
        int count = 0, maxCount = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
