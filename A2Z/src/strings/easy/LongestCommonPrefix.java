package strings.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /*
         Longest Common Prefix  -> Common prefix in all the elements of the array

        In java there is a function on string called string.indexOf(str)
        Whatever sub-string we pass it gives us the index from here that sub-string starts
        in the string. Using this we can solve the problem.\

        Int the ans store the first string of the array
        iterate the array from next string and check if str.indexOf(ans) != 0
        this means "flow".indexOf("flower") -> flower is not in flow
        so reduce the ans by now character
         "flow".indexOf("flowe") != 0
         "flow".indexOf("flow")   == 0
         we are checking for zero because we want to find the prefix
         once its equal to zero go to next word and repeat teh step

    */

    public static String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String word = strs[i];
            while (word.indexOf(ans) != 0) {
                ans = ans.substring(0, ans.length() - 1);
                if (ans.isEmpty()) return "";
            }
        }

        return ans;
    }
}
