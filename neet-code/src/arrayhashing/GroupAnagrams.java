package arrayhashing;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        /*
            TC = O(m.nlog(n))
            SC = O(m)
            m is the number of elements

            Because we are sorting each string in the array

         */

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedGroup = new String(charArray);
            map.computeIfAbsent(sortedGroup, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
