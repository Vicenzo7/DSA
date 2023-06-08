package binarysearch.oneDArray;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums));
    }


    /*
         Brute Force
         Create a Map that stores the element and number of time it appears
         Then iterate the array and check which element appears once that is the ans

         TC = O(n) + O(n)  Two time traversal of the array
         SC = O(n) Map to store element


         Optimised Approach: using XOR property
         0 ^ 0 = 0
         0 ^ 1 = 1
         1 ^ 0 = 1
         1 ^ 1 = 0

         From above, we can see if we XOR same value we get 0
         Since the array has only one single element and rest all are twice

         We can xor each element in the array and the ans of the xor will be our unique element


        TC = O(n)


        More Optimised Approach : Using binary Search
        As in the question its given that the array is sorted we can use binary search

        First Boundary Condition

        if array is of length 1 than the unique element is the first element
        else check if nums[0] != nums[1], if true return nums[1]
        else check if nums[n-1] != nums[n-2], if true return nums[n-1]

        Now do a normal binary Search and calculate mid and check if mid is a unique element,
        unique element condition, nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]
        if mid is a unique element return that element

        if not how to know where can unique element be

        Now observe
                 0 1 2 3 4 5 6 7 8
         nums = [1,1,2,3,3,4,4,8,8]

         if the mid is at even index then its duplicate is at odd index, ie mid-1

                 0 1 2 3 4 5 6 7
         nums = [3,3,7,7,10,11,11]

         if the mid is at odd index then its duplicate is at even index, ie mid+1

        So we check according that if duplicate exist, if duplicate is present means no unique exist, so we move left
        ie low = mid +1;
        else
           high = mid -1;

        TC = O(log(n))

     */


    public static int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        // boundary condition
        if (high == 0) return nums[0];
        else if (nums[0] != nums[1]) return nums[0];
        else if (nums[high] != nums[high - 1]) return nums[high];


        while (low <= high) {
            int mid = low + (high - low) / 2;

            // check if mid is a unique element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];


            // check if element at mid has its duplicate
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                // check if mid is an evenIndex , for evenIndex its duplicate in on oddIndex, or
                // check if mid is an oddIndex , for oddIndex its duplicate in on evenIndex.
                // if any one condition satisfies means duplicate is present and no unique element is there so we more left
                // to find unique on left part// if above any condition satisfies mean no unique element exist so move forward
                low = mid + 1;
            } else { // move right to find unique on right part
                high = mid - 1;
            }
        }

        return -1;
    }
}
