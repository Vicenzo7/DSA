package array.hard;

import java.util.Arrays;

public class FindMissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};
//        System.out.println(Arrays.toString(findTwoElement(nums)));
//        System.out.println(Arrays.toString(findTwoElementOptimal1(nums)));
        System.out.println(Arrays.toString(findTwoElementOptimal2(nums)));
    }

    //Given an unsorted array Arr of size N of positive integers.
    // One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array.
    // Find these two numbers.

    /*
        Solution 1:
        Take array of size n+1 ie frequency
        Traverse the given array and store the element frequency count of the array at its respective index
        Now traverse the frequency array and check if anyone has count > 1 then that index is the repeated element,
        and if any index has element zero then it's a missing number

        TC = O(n)
        SC = O(n)

    */
    public static int[] findTwoElement(int[] nums) {
        // since it has number from 1 to N lets sort the array using cycle sort
        int missing = 0, repeated = 0;
        int[] frequencyCount = new int[nums.length + 1];
        for (int num : nums) {
            frequencyCount[num] += 1;
        }

        for (int i = 1; i < frequencyCount.length; i++) {
            if (frequencyCount[i] > 1) {
                repeated = i;
            } else if (frequencyCount[i] == 0) {
                missing = i;
            }
        }

        System.out.println(Arrays.toString(frequencyCount));

        return new int[]{repeated, missing};
    }


    /*
       Solution 2;
       Since we know the elements are from 1 to N
       Step1: Sort the elements using cycle sort
       Step2: Now the elements are in the correct place run a for loop and which element is in not right place
                    ie nums[i] != i+1
                    So the repeating number will be nums[i], and
                    missing number = i+1

        TC = O(N)
        SC = O(1)
    */
    public static int[] findTwoElementOptimal1(int[] nums) {
        // since it has number from 1 to N lets sort the array using cycle sort
        int missing = 0, repeated = 0;
        int index = 0;
        while (index < nums.length) {
            int correct = nums[index] - 1;
            if (nums[index] != nums[correct]) {
                int temp = nums[index];
                nums[index] = nums[correct];
                nums[correct] = temp;
            } else {
                index++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                repeated = nums[i];
                missing = i + 1;
            }

        }
        System.out.println(Arrays.toString(nums));
        return new int[]{repeated, missing};
    }

    /*
        Solution 3 : By Math Formula
        Let us consider x = missing number
        y = repeating number

        Formula
        s = sum of all number from 1 to n, (n*(n+1)) / 2;  ----------equation 1
        p = square of all number from 1 to n, (n*(n+1)*(2n+1) / 6; -------equation 2

        s1 = Sum of all elements of the array. —– equation 3
        p1 = Sum of squares of all elements of the array. ——– equation 4

        Now, if we subtract the sum of all elements of the array from the sum of all elements from 1 to N, that should give us the value for (X – Y).

        Therefore,

        (X-Y) = s – s1 = s’

        Similarly,

        X^2 – Y^2 = P – P1 = P’

        or, (X + Y)(X – Y) = P’

        or, (X + Y)*s’ = P’

        or, X + Y = P’/s’

        Great,

        we have the two equations we need:

        (X – Y) = s’

        (X + Y) = P’/s’

        We can use the two equations to solve and find values for X and Y respectively.

        x = (s' + p'/s') / 2

        Y = X -s'

        TC = O(n)
        SC = O(1)

    */

    public static int[] findTwoElementOptimal2(int[] nums) {
        int missingNumber = 0, repeatedNumber = 0;
        int n = nums.length;
        long sum = ((long) n * (n + 1)) / 2; // sum of numbers from 1 to n
        long product = (n * (n + 1) * ((2L * n) + 1)) / 6; // sum of squares of all elements from 1 to n

        for (int num : nums) {
            sum -= num;
            product -= (long) num * num;
        }

        missingNumber = (int) ((sum + (product / sum)) / 2);
        repeatedNumber = (int) (missingNumber - sum);

        return new int[]{repeatedNumber, missingNumber};
    }


}
