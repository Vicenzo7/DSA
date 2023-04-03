package array.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2,3,3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementOptimal(nums));
    }

    /*Time Complexity: O(N*logN) + O(N), where N = size of the given array.
            Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN). The second O(N) is for checking which element occurs more than floor(N/2) times.
    If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

    Space Complexity: O(N) as we are using a map data structure.*/
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (frequencyCount.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    /* Optimal Approach:
    Moore’s Voting Algorithm:

    Intuition: If the array contains a majority element, its occurrence must be greater than the floor(N/2). Now, we can say that the count of minority elements and majority elements are equal up to a certain point in the array.
    So when we traverse through the array we try to keep track of the count of elements and the element itself for which we are tracking the count.

    After traversing the whole array, we will check the element stored in the variable. If the question states that the array must contain a majority element,
    he stored element will be that one but if the question does not state so, then we need to check if the stored element is the majority element or not. If not, then the array does not contain any majority element.

    Approach:

    Initialize 2 variables:
    Count –  for tracking the count of element.
    Element – for which element we are counting
    Traverse through the given array.
    If Count is 0 then store the current element of the array as Element.
    If the current element and Element are the same increase the Count by 1.
    If they are different decrease the Count by 1.
    The integer present in Element should be the result we are expecting

    Basically, we are trying to keep track of the occurrences of the majority element and minority elements dynamically. That is why, in iteration 4,
    the count becomes 0 as the occurrence of Element and the occurrence of the other elements are the same. So, they canceled each other.
    This is how the process works. The element with the most occurrence will remain and the rest will cancel themselves.

    Here, we can see that 2 is the majority element. But if in this array, the last two elements were 3,
    then the Element variable would have stored 3 instead of 2.
    For that, we need to check if the Element is the majority element by traversing the array once more.
    But if the question guarantees that the given array contains a majority element, then we can bet the Element will store the majority one.

    Time Complexity: O(N) + O(N), where N = size of the given array.
    Space Complexity: O(1) as we are not using any extra space.

    */

    public static int majorityElementOptimal(int[] nums) {
        int count = 0, element = -1;
        for (int j : nums) {
            if (count == 0) {
                count = 1;
                element = j;
            } else if (j == element) {
                count++;
            } else {
                count--;
            }
        }
        // If there is no guarantee a majority element exist
        int count2 = 0;
        for (int num : nums) {
            if (num == element) {
                count2++;
            }
        }
        return count2 > nums.length / 2 ? element : 0;
    }
}
