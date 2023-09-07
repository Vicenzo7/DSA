package strings.medium;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "raaeaedere";
        System.out.println(frequencySort(s));
        System.out.println(frequencySortOptimal(s));
    }


    /*
        1. using Map and Sorting
         -> In a map store the frequency of each character
         -> Take a list and add to it the all character
         -> Now sort the list using a custom comparator list.sort((a,b) -> map.get(b) - map.get(a))
         -> Now iterate the list and construct the ans.

         TC = O(n + (k* log(k))) n is the first iteration, next is sorting,sorting, where k is number of distinct characters.
         SC = O(k)

    */
    public static String frequencySort(String s) {
        // count frequency
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // sorting
        List<Character> characters = new ArrayList<>(frequencyMap.keySet());
        characters.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        // Build String
        StringBuilder builder = new StringBuilder();
        for (Character c : characters) {
            builder.append(String.valueOf(c).repeat(frequencyMap.get(c)));
        }
        return builder.toString();
    }

    /*
        2. using Map and PriorityQueue(maxHeap)
         -> In a map store the frequency of each character
         -> Construct a PriorityQueue (maxHeap) using the map values, using a custom comparator ((a,b) -> map.get(b) - map.get(a))
         -> Add all map keys into the PQ.
         -> Now iterate the PQ and construct the ans.

         TC = O(n + (k* log(k))) n is the first iteration, next is sorting,sorting, where k is number of distinct characters.
         SC = O(k)

    */
    public static String frequencySortOptimal(String s) {
        // count frequency
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // build maxHeap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        // Build String
        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Character c = maxHeap.poll();
            builder.append(String.valueOf(c).repeat(frequencyMap.get(c)));
        }
        return builder.toString();
    }
}
