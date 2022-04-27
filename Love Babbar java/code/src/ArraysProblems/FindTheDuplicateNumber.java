package ArraysProblems;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        int result= duplicateNumber(nums);
        System.out.println(result);
    }

    private static int duplicateNumber(int[] nums)
    {

//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length ; i++) {
//            if(nums[i]==nums[i-1])
//            {
//                return nums[i];
//            }
//        }
//        return -1;

        //since in the above method we're using sorting the TC: O(n logn) and SC:O(logn) or O(n)

        //below approach has  TC:O(n) and SC:O(n)
//        Set<Integer> seen = new HashSet<Integer>();
//        for (int num : nums) {
//            if (seen.contains(num))
//                return num;
//            seen.add(num);
//        }
//        return -1;

        //Third approach
        int sum1 =0,n=nums.length;
        for (int i = 0; i < n ; i++) {
            sum1 += nums[i];
        }

        int sum2=(n*(n-1))/2;

        int ans = sum1- sum2;
        return ans;


    }

}
