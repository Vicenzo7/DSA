package arrayhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        // 1 1 1 2 2 3 3 3 4 4
        System.out.println(containsDuplicate(nums));
    }


//    public static boolean containsDuplicate(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) return true;
//            }
//        }
//        return false;
//    }

//    public static boolean containsDuplicate(int[] nums) {
//
//        Arrays.sort(nums); // O(nlog(n))
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i + 1]) return true;
//        }
//        return false;
//    }

    public static boolean containsDuplicate(int[] nums) {
        // TC = O(n)   SC = O(n)

        HashSet<Integer> hashSet = new HashSet<>();
        for (int x : nums) {
            if (hashSet.contains(x)) return true;
            hashSet.add(x);
        }
        return false;
    }
}
