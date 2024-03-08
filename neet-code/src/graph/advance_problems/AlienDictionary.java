package graph.advance_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
    public static void main(String[] args) {
//        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] words = {"z", "z"};
        System.out.println(alienDictionary(words));
    }

    public static String alienDictionary(String[] words) {
        Map<String, Set<String>> adjacencyList = new HashMap<>();


        for (int i = 0; i < words.length - 1; i++) {
            // take two pairs or words
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
            /*
                According to the rule, if the first min(w1.length,w2.length) prefix letters are the same, then w1 is smaller
                if and only if w1.length < w2.length, if the condition fails means the given words are not lexicographically
                sorted according to alien dictionary, so return "".
            */

            if (w1.length() > w2.length() && w1.substring(0, minLength).equals(w2.substring(0, minLength))) {
                // if w1 length > w2 length and their prefix is same, means they are not lexicographically sorted according
                // to alien dictionary, so return "".
                return "";
            }

            // find the first character of difference between the two words
            for (int j = 0; j < minLength; j++) {
                char x = w1.charAt(j);
                char y = w2.charAt(j);
                if (x != y) {
                    // according to the rule this means character x comes before y.
                    adjacencyList.computeIfAbsent(String.valueOf(x), k -> new HashSet<>())
                            .add(String.valueOf(y));
                    break; // breaking because we only want first character of difference to determine the order.
                }
            }
        }

        if (adjacencyList.isEmpty()) {
            return words[0];
        }

        // after creating the graph apply the topological sort.
        Map<String, Boolean> visit = new HashMap<>(); // false = visited, true = in current path, if not in set then not visited at all
        StringBuilder stringBuilder = new StringBuilder();

        for (String c : adjacencyList.keySet()) {
            if (hasCycle(c, visit, adjacencyList, stringBuilder)) {
                return "";
            }
        }

        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString();
    }

    private static boolean hasCycle(String c, Map<String, Boolean> visit,
                                    Map<String, Set<String>> adjacencyList, StringBuilder stringBuilder) {

        if (visit.containsKey(c)) {
            return visit.get(c); // return true means cycle exist, return false means already visited.
        }


        visit.put(c, true); // means visited and in current path

        Set<String> neighbours = adjacencyList.getOrDefault(c, new HashSet<>());

        for (String neighbour : neighbours) {
            if (hasCycle(neighbour, visit, adjacencyList, stringBuilder)) {
                return true;
            }
        }

        visit.put(c, false); // means visited
        stringBuilder.append(c);
        return false;
    }
}
