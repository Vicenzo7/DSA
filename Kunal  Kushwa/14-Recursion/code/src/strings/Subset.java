package strings;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        String a ="ba";
        String substring = a.substring(0, 0);
        System.out.println(substring + 'c' +a.substring(0));
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        subset(nums, 0, ans, temp);
//        System.out.println(ans);
//
//        System.out.println(subset(nums));
//        System.out.println(subsetDuplicates(nums));
    }

    private static void subset(int[] nums, int index, List<List<Integer>> ans, List<Integer> temp) {

        if (index == nums.length) {
            ans.add(temp);
            return;
        }
        // exclude
        subset(nums, index + 1, ans, new ArrayList<>(temp));
        // include
        int value = nums[index];
        temp.add(value);
        subset(nums, index + 1, ans, temp);

    }


    public static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num : arr) {
            int size = outer.size();
            for (int i = 0; i < size; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }


    public static List<List<Integer>> subsetDuplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start;
        int end = 0;
        for (int i = 0; i <arr.length; i++) {
            start =0;
            // if current and previous element are same , start = end+1;
            if(i > 0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end = outer.size()-1;
            int size = outer.size();
            for (int j = start; j < size; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
