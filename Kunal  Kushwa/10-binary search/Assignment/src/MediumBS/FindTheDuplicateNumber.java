package MediumBS;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums= {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
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
}
