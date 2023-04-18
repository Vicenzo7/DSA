package array.medium;
//https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1
import java.util.*;

public class FindAllPairsWithAGivenSum {
    public static void main(String[] args) {
        long[] nums1 = {1, 2, 4, 5, 7};
        long[] nums2 = {5, 6, 3, 4, 8};
        int x = 9;
        Pair[] pairs = allPairs(nums1, nums2, nums1.length, nums2.length, x);
        for (Pair pair : pairs) {
            System.out.println(pair.first + "-" + pair.second);
        }
    }

    public static Pair[] allPairs(long[] nums1, long[] nums2, long n, long m, long x) {
        Set<Long> set = new HashSet<>();
        List<Pair> pairList = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (long num : nums1) {
            set.add(num);
        }

        for (int i = nums2.length-1; i >= 0; i--) {
            if (set.contains(x-nums2[i])) {
                Pair pair = new Pair(x-nums2[i],nums2[i]);
                pairList.add(pair);
            }
        }

        Pair[] pairs = new Pair[pairList.size()];
        pairs = pairList.toArray(pairs);
        return pairs;

    }

    static class Pair {
        long first, second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}
