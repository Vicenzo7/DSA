package strings.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "egg", t = "odd";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphicOptimal(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!characterMap.containsValue(t.charAt(i))) {
                characterMap.put(s.charAt(i), t.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append(characterMap.getOrDefault(s.charAt(i), '-'));
        }
        return ans.toString().equals(t);
    }

    /*
        Isomorphic String
        For Strings to be isomorphic each charter in first string should be mapped to unique character in other string

        So we will do the character mapping using map<char,char>
        Step 1: Since both the strings are of same length, iterate the string,
        extract the value of both the string at respective index
        suppose say sChar, tChar

        Step 2: check if sChar is present in the map as a key, if present it should be mapped to tChar to be isomorphic
         or else return false.

       step 3: If sChar is not present check if tChar is present int the map as a value, if its present it means tChar is
       being mapped to two character and therefore these two string cannot be isomorphic.
       If tChar is not mapped add in map sChar , tChar to map them.

       If all goes well return true at the end.

    */
    public static boolean isIsomorphicOptimal(String s, String t) {
        Map<Character, Character> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (characterMap.containsKey(sChar)) {
                // if sChar is present it should be mapped to tChar, else it cannot be isomorphic
                if (characterMap.get(sChar) != tChar) return false;
            } else {
                // sChar is not there but check if tChar is present in the map, this state there can be multiple mapping
                // for tChar and they are not isomorphic
                if (characterMap.containsValue(tChar)) return false;
                characterMap.put(sChar, tChar);
            }
        }
        return true;
    }

}
