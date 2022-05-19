package HardBS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] nums={5,2,6,1};
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();

        for(int x:nums)
        {
            sorted.add(x);
        }

        Collections.sort(sorted);

        for(int x:nums)
        {
            int index= binarySearch(sorted,x);
            ans.add(index);
            sorted.remove(index);
        }
        return ans;

    }


    public static int binarySearch(List<Integer> sorted, int target)
    {
        int start=0;
        int end= sorted.size()-1;
        int firstIndex=0;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            int value = sorted.get(mid);
            if(value == target)
            {
                firstIndex= mid;
                end=end-1;
            }
            else if(value < target)
            {
                start= mid+1;
            }
            else
            {
                end= mid-1;
            }
        }
        return firstIndex;
    }
}
