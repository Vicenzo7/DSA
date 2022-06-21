package ArraysProblems;

public class FindClosestNumbertoZero {
    public static void main(String[] args) {
        int[] nums = {-4, -2, -1, 1, 4, 8};
        System.out.println(findClosestNumber(nums));
    }

    public static int findClosestNumber(int[] nums) {

        int smallest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // comapres if the next element is greater than smallest
            if (Math.abs(smallest) > Math.abs(nums[i])) {
                smallest = nums[i];
                System.out.println("Current smallest is :" + smallest);
            }
            // if both smallest and next number are equal than it will take a large value eg -1 and 1. 1 will be chosen
            else if (Math.abs(smallest) == (nums[i])) {
                smallest = nums[i];
                System.out.println("Current smallest is :" + smallest);
            }
        }
        return smallest;
    }
}
