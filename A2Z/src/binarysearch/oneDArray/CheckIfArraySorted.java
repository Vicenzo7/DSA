package binarysearch.oneDArray;

public class CheckIfArraySorted {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int[] nums2 = {90, 3, 8, 10, 8, 9, 2};

        System.out.println(binarySearch(nums2, 0, nums2.length - 1));
    }


    /*
        Brute for approach
        Run a loop and check if there exit this condition if nums[i] > nums[i+1]
        This the above condition exist then the array is not sorted else it's sorted

        TC = O(n) to traverse the array


        How about to do it using binarySearch
        Things to note
        1. A single element is always sorted

        Using recursion
        steps1: if an element is alone than its sorted, return true
        steps2 : check left part is sorted, leftPart = low to mid
        steps3 : check right part is sorted, rightPart = mid+1 to high
        steps4 : Check if the current element is sorted, nums[mid] < nums[mid +1]

        Step5 : Return the result of the three

        TC = O(log(n))
        SC = O(log(n)) -> Auxiliary space

    */


    public static boolean binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return true; // A single element is always sorted
        }

        int mid = left + (right - left) / 2;

        boolean isLeftPartSorted = binarySearch(nums, left, mid);
        boolean isRightPartSorted = binarySearch(nums, mid + 1, right);

        // check if the current element is sorted
        boolean isCurrentElementSorted = nums[mid] <= nums[mid + 1];


        return isLeftPartSorted && isCurrentElementSorted && isRightPartSorted;
    }
}
