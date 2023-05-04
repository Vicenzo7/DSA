package array.hard;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithGivenXorK {
    public static void main(String[] args) {
        int[] nums = {4, 94, 39, 36, 88, 87, 39, 67, 11, 6,};
        int target = 15;
        System.out.println(subsetXOR(nums, target));
        System.out.println(subsetXOROptimal(nums, target));
    }


    /**
     * Brute Force
     * Find xorSum of all the sub-array and check if it's equal to the target provided if yes increase the count.
     * <p>
     * TC = O(n^2) -> we are running two for loop;
     * SC = O(1) Constant space complexity
     */
    public static int subsetXOR(int[] nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int xorValue = 0;
            for (int j = i; j < nums.length; j++) {
                xorValue ^= nums[j];
                if (xorValue == target) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
     Optimal Approach(Using Hashing):
     In this approach, we are going to use the concept of the prefix XOR to solve this problem.
     Here, the prefix XOR of a subarray ending at index i, simply means the XOR of all the elements of that subarray.

    Observation: Assume, the prefix XOR of a subarray ending at index i is xr.
    In that subarray, we will search for another subarray ending at index i, whose XOR is equal to k.
    Here, we need to observe that if there exists another subarray ending at index i, with XOR k, then the prefix XOR of
    the rest of the subarray will be xr^k. The below image will clarify the concept:
    //https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/

    Proof:
    Let's say the XOR of the first part is = x,
    The XOR of the second part, that we are searching is = k
    Prefix XOR till index i = xr;
    Therefore,
        x^k = xr
        x^k^k = xr ^ k (xor k on both side)
        x = xr^k
    Hence the xor of the first part must be, x = xr^k
        xr
    __________
    |        |
    4, 2, 2, 6, 4
	x  | i   |
       |_____|
          k
    k = 6

    Assume
    xor value from 4 to 6 is 2
    xor of first part = 4
    xor of second part = 6

    4 ^ 6 = 2
    4 ^ 6 ^ 6 = 2 ^ 6
    4 = 2 ^ 6



     Approach:
     The steps are as follows:

     1.First, we will declare a map to store the prefix XORs and their counts.
     2.Then, we will set the value of 0 as 1 on the map.
     3.Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
     4.For each index i, we will do the following:
        1.We will XOR the current element i.e. arr[i] to the existing prefix XOR.
        2.Then we will calculate the prefix XOR i.e. xr^k, for which we need the occurrence.
        3.We will add the occurrence of the prefix XOR xr^k i.e. mpp[xr^k] to our answer.
        4.Then we will store the current prefix XOR, xr in the map increasing its occurrence by 1.

     Question: Why do we need to set the value of 0 beforehand?
     Let’s understand this using an example. Assume the given array is [3, 3, 1, 1, 1] and k is 3.
     Now, for index 0, we get the total prefix XOR as 3, and k is also 3.
     So, the prefix XOR xr^k will be = 3^3 = 0. Now, if the value is not previously set for the key 0 in the map, we will get the default value 0 and we will add 0 to our answer.
     This will mean that we have not found any subarray with XOR 3 till now. But this should not be the case as index 0 itself is a subarray with XOR k i.e. 3.
     So, in order to avoid this situation we need to set the value of 0 as 1 on the map beforehand.

    Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
    Reason: For example, if we are using an unordered_map data structure in C++ the time complexity will be O(N) but if we are using a map data structure, the time complexity will be O(N*logN).
     The least complexity will be O(N) as we are using a loop to traverse the array. Point to remember for unordered_map in the worst case, the searching time increases to O(N), and hence the overall time complexity increases to O(N2).

    Space Complexity: O(N) as we are using a map data structure.

    This problem is similar to Count the Sub-Array whose sum = k
    There we do reverse engineering sum-k

    Here also we do reverse engineering but for xor
    x ^ k = xr
    x = xr ^ k
     */


    public static int subsetXOROptimal(int[] nums, int target) {
        int count = 0;
        Map<Integer, Integer> prefixXorSum = new HashMap<>();
        prefixXorSum.put(0, 1);
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
            count += prefixXorSum.getOrDefault(xorSum ^ target, 0);
            prefixXorSum.put(xorSum, prefixXorSum.getOrDefault(xorSum, 0) + 1);
        }
        return count;
    }
}
