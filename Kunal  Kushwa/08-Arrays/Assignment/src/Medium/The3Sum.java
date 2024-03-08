package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class The3Sum {
    public static void main(String[] args) {
        int [] nums={-2,0,1,1,2};
        List<List<Integer>> ans = new ArrayList<>();
        ans=threeSum(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List < List < Integer >> result = new ArrayList < List < Integer >> ();
//
//        for(int i=0;i<nums.length-1;i++)
//        {
//            for(int j=i+1;j<nums.length-1;j++)
//            {
//                for(int k=j+1;k<nums.length;k++)
//                {
//                    if(nums[i]+nums[j]+nums[k]==0)
//                    {
//                        List<Integer> triplet = new ArrayList<>();
//                        triplet.add(nums[i]);
//                        triplet.add(nums[j]);
//                        triplet.add(nums[k]);
//                        Collections.sort(triplet);
//                        result.add(triplet);
//                    }
//                }
//            }
//        }
//        result = new ArrayList < List < Integer >> (new LinkedHashSet< List < Integer >>(result));


/*
        We can sort the given array and use the three pointer approach to improve the time complexity of our
         solution as compared to the previous approach.
 */
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {

            ////skipping duplicates start
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            //two pointers
            int start=i+1,end=nums.length-1;
            while(start<end)
            {
                int sum=nums[i]+nums[start]+nums[end];
                if(sum==0)
                {
//                    System.out.println(nums[i]+" "+nums[start]+" "+nums[end]);
                    result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    end--;

                    //skipping duplicates at the end
                    while(start<end && nums[end]==nums[end+1] )
                    {
                        end--;
                    }
                }
                else if(sum<0)
                {
                 start++;
                }
                else//sum>0
                {
                    end--;
                }
            }

        }

        return result;
    }
}
