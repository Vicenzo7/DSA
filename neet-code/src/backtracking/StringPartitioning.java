package backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPartitioning {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(getStringPartitioning(s));
    }

    public static List<List<String>> getStringPartitioning(String s) {
        List<String> currentPartition = new ArrayList<>();
        List<List<String>> allPartition = new ArrayList<>();
        dfs(0, s, currentPartition, allPartition);
        return allPartition;
    }

    private static void dfs(int start, String s, List<String> currentPartition, List<List<String>> allPartition) {
        if (start == s.length()) {
            allPartition.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            currentPartition.add(substring);
            dfs(end + 1, s, currentPartition, allPartition);
            currentPartition.remove(currentPartition.size() - 1);
        }
    }
}
