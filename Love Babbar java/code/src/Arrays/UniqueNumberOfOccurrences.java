package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] nums= {1,2,2,1,1,3};
        boolean result=uniqueOccurrences(nums);
        System.out.println(result);

    }
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> num_occurrences = new HashMap<>();
        for(int num:arr)
        {
            num_occurrences.put(num,num_occurrences.getOrDefault(num,0)+1);
        }
        HashSet<Integer> unique_vals = new HashSet<>(num_occurrences.values());
        return num_occurrences.size() == unique_vals.size();
    }
}
