package arrayhashing;

import java.util.*;

public class TopKMostFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

//    public static int[] topKFrequent(int[] nums, int k) {
//        // TC = (n.log(n)) SC = O(n)
//        Map<Integer, Integer> frequencyCount = new HashMap<>();
//        for (int num : nums) {
//            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
//        }
//        System.out.println(frequencyCount);
//
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyCount.entrySet());
//        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
//
//        int[] ans = new int[k];
//        for (int i = 0; i < k; i++) {
//            Map.Entry<Integer, Integer> integerIntegerEntry = list.get(i);
//            Integer key = integerIntegerEntry.getKey();
//            ans[i] = key;
//        }
//
//        return ans;
//    }

//    public static int[] topKFrequent(int[] nums, int k) {
//        // TC = (n.log(n)) SC = O(n)
//        Map<Integer, Integer> frequencyCount = new HashMap<>();
//        for (int num : nums) {
//            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
//        }
//
//        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
//
//        maxHeap.addAll(frequencyCount.entrySet());
//
//        int[] ans = new int[k];
//        for (int i = 0; i < k; i++) {
//            Map.Entry<Integer, Integer> integerIntegerEntry = maxHeap.poll();
//            Integer key = integerIntegerEntry.getKey();
//            ans[i] = key;
//        }
//        return ans;
//    }

    /*
        The above problem can be solved using bucket sort
        TC = O(n) SC = O(n)
    */

    public static int[] topKFrequent(int[] nums, int k) {
        // TC = O(n) SC = O(n)
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> frequencyList = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            frequencyList.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            List<Integer> subList = frequencyList.get(value);
            subList.add(key);
        }

        int[] result = new int[k];
        int counter = 0;
        for (int i = frequencyList.size() - 1; i >= 0; i--) {
            List<Integer> subList = frequencyList.get(i);
            if (subList.isEmpty()) continue;

            for (Integer integer : subList) {
                result[counter++] = integer;
                k--;
                if (k == 0) break;
            }
            if (k == 0) break;
        }

        return result;
    }
}
