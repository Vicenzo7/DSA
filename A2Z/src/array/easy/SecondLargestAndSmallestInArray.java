package array.easy;
//https://practice.geeksforgeeks.org/problems/second-largest3735/1
public class SecondLargestAndSmallestInArray {
    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0, 87};
//        System.out.println(secondLargest(nums));
//        System.out.println(secondSmallest(nums));

        System.out.println(fastSecondLargest(nums));
        System.out.println(fastSecondSmallest(nums));

    }

    public static int secondLargest(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int secondLargest = 0;
        for (int num : nums) {
            if (num < max) {
                secondLargest = Math.max(num, secondLargest);
            }
        }
        return secondLargest;
    }


    public static int secondSmallest(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min)
            ;
        }

        int secondSmallest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > min) {
                secondSmallest = Math.min(num, secondSmallest);
            }
        }
        return secondSmallest;
    }
    // better approach TC = O(N)

    public static int fastSecondLargest(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    public static int fastSecondSmallest(int[] nums) {
        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest) {
                secondSmallest = num;
            }
        }

        return secondSmallest;
    }
}
