package Easy;
public class TwoSum {
    public static void main(String[] args) {
        int[] nums ={3,2,4};
        int target = 6;
        int[] result =twoSum(nums,target);
        for(int num : result) {
            System.out.print(num + " ");
        }

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] ans= new int[2];
        int c=0;

        for (int i = 0; i <nums.length-1 ; i++) {
            for (int j =i+1 ; j < nums.length ; j++) {

                if(nums[i]+nums[j] == target)
                {
                    ans[c++]=i;
                    ans[c]=j;
                }
            }
        }
        return ans;

    }
}
