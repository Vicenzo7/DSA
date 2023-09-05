package strings.easy;


import java.util.Arrays;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde", goal = "eabcd";
        System.out.println(rotateString(s, goal));
    }


    /*

        Solution:
        s = abcde
        Step1 : Iterate a loop for s.
        Step2 : Extract two substring
                first = s.substring(0,i)
                second = s.substring(i)

                for example i = 1, first = a, second = bcde
        Step3 : concatenate, rotated = second+ first = bcdea -> this is rotated by one
        Step4 : check if rotated equals to goal, if yes return true.
        Step5 : If we cannot extract true from the iteration return false.


        TC = O(n) -> iterating s where n is length of s.

    */

    public static boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(0, i);
            String second = s.substring(i);
            String rotated = second + first;
            if (rotated.equals(goal)) return true;
        }
        return false;

    }

    /*
        Solution
        Step1 : Check if string s and goal have same length, then only we can check if s can become goal

        Step2 : Concatenate s twice, eg combination = s + s
        if s = abcde then,
        combination = abcdeabcde;

        Now combination contains each pattern for each rotation.

        Step3 : Check is combination contains the goal pattern,
        if yes return true else false

        TC : O(1)

    */

    public static boolean rotateStringOptimal(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String combination = s + s;

        return combination.contains(goal);
    }


}
