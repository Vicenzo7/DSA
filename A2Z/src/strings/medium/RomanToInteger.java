package strings.medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }


    /*

        Intuition

        Create a Map and store the values by mapping to their respective alphabets

        Iterate the string, take the current char and the next character
        if current char mapped value >= next char mapped value in the map, the add the current
        char mapped value to the sum, else subtract the current char value mapped value from the sum


        At last add the last char mapped value to the sum and return the sum

        TC = O(n)

    */

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            if (map.get(current) >= map.get(next)) {
                sum += map.get(current);
            } else {
                sum -= map.get(current);
            }
        }

        sum += map.get(s.charAt(s.length() - 1));
        return sum;
    }
}
