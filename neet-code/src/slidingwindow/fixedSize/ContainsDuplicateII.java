package slidingwindow.fixedSize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }

//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] == nums[j] && Math.abs(i-j) <= k) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                if (Math.abs(map.get(nums[i]) - i) <= k) {
//                    return true;
//                }
//            }
//            map.put(nums[i], i);
//        }
//        return false;
//    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) { // checking is gap is not greater than k, if yes removing elements from window set
                set.remove(nums[i-k-1]);
            }
            // if while adding i get false means item already exist and the gap is <= k
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>(); // Cur window of size <= k
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (R - L  > k) {
                window.remove(nums[L]);
                L++;
            }
            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
        }
        return false;
    }
}
