package company.uniCard;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};
//        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
//        int[] nums = {1, 1, 1 };
        System.out.println(longestSubarray(nums));
    }


    public static int longestSubarray(int[] nums) {
        int result = 0;
        int currentOneCount = 0;
        int prevOneCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentOneCount++;
            } else {
                // since we got a zero
                result = Math.max(result, currentOneCount + prevOneCount);
                prevOneCount = currentOneCount;
                currentOneCount = 0;
            }
        }

        result = Math.max(result, currentOneCount + prevOneCount);
        // if array had all one reduce the result count by 1
        return result == nums.length ? result - 1 : result;
    }
}
