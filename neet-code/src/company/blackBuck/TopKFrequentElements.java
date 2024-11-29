package company.blackBuck;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }


//    public static int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> frequency = new HashMap<>();
//        for (int n : nums) {
//            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
//        }
//
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
//            if (o2.getValue().equals(o1.getValue())) {
//                return o2.getKey().compareTo(o1.getKey());
//            }
//            return o2.getValue().compareTo(o1.getValue());
//        });
//        pq.addAll(frequency.entrySet());
//
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = pq.remove().getKey();
//        }
//
//        return result;
//
//    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new ArrayList<>());
        }

        frequency.forEach((key, value) -> list.get(value).add(key));

        int[] result = new int[k];
        int counter = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            List<Integer> integers = list.get(i);
            if (integers.isEmpty()) {
                continue;
            }

            Collections.sort(integers);
            for (int j = integers.size() - 1; j >= 0; j--) {
                result[counter++] = integers.get(j);
                k--;
                if (k == 0) break;
            }

            if (k == 0) {
                break;
            }
        }

        return result;
    }
}
