package MediumBS;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums= {1,3,4,2,2};
        System.out.println(findDuplicate(nums));

        System.out.println(findDuplicateUsingFlyodTortoiseandHare(nums));
    }

    public static int findDuplicate(int[] nums) {
        //using HashMap
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int num : nums) {
//            int count = 0;
//            if (map.containsKey(num)) {
//                count = map.get(num) + 1;
//                if (count > 1) {
//                    return num;
//                } else {
//                    map.put(num, count);
//                }
//            } else {
//                map.put(num, 1);
//            }
//        }
//        return -1;



        //using HashSet
        Set<Integer> seen = new HashSet<>();
        for(int n:nums)
        {
            if(seen.contains(n))
                return n;
            seen.add(n);
        }
        return -1;
    }


    // Flyod's Tortoise and Hare method
    //TC O(n) and SC O(1) it is optimised in space


    public static int findDuplicateUsingFlyodTortoiseandHare(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do{
            //moving slow by one
            slow=nums[slow];
            //moving fast by two
            fast=nums[nums[fast]];
        }while(slow != fast);
        //until their first collision

        //after first collision fast is assigned to the first number
        //and they are both moved by one
        fast= nums[0];
        while(slow != fast)
        {
            slow= nums[slow];
            fast= nums[fast];
        }
        //after their second collision they will meet the duplicate element

        return slow;


    }
}
