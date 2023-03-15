package basic.hashing;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1
public class TopKFrequentElementsInArray {
    public static void main(String[] args) {
        int[]nums = {1,1,2,2,3,3,3,4};
        int k = 2;
        System.out.println(Arrays.toString(topK(nums, k)));

    }

    public static int[] topK(int[] nums, int k) {
        // Code here
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : nums) {
            int count = frequencyMap.getOrDefault(i, 0);
            frequencyMap.put(i,count+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((o1, o2) -> Objects.equals(o1.getValue(), o2.getValue()) ? o2.getKey() - o1.getKey() : o2.getValue() - o1.getValue());

        int [] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=list.get(i).getKey();
        }

        return ans;
    }

}
