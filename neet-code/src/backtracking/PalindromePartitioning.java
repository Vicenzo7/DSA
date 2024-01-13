package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }


    public static List<List<String>> partition(String s) {
        List<String> partition = new ArrayList<>();
        List<List<String>> allPartition = new ArrayList<>();
        generatePartitions(s, 0, partition, allPartition);
        return allPartition;
    }

    private static void generatePartitions(String input, int start, List<String> currentPartition, List<List<String>> allPartitions) {
        if (start == input.length()) {
            allPartitions.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < input.length(); end++) {
            String substring = input.substring(start, end + 1);
            if (isPalindrome(substring)) {
                currentPartition.add(substring);
                generatePartitions(input, end + 1, currentPartition, allPartitions);
                currentPartition.remove(currentPartition.size() - 1);
            }

        }
    }


    private static boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }
}
