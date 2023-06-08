package binarysearch.oneDArray;

public class SearchInSortedAndRotatedArray2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 13;

        System.out.println(search(nums, target));
    }

    /*Approach:
    1.Initialize the start and end indices to the first and last elements of the array, respectively.
    2.Perform a binary search by repeatedly dividing the search space in half.
    3.Calculate the middle index using the formula mid = start + (end - start) / 2.
    4.Check if the target value is equal to the element at the middle index. If so, return true since the target is found.
    5.Compare the element at the start index with the element at the middle index to determine if the left half is sorted or the right half is sorted.
        If the left half is sorted, check if the target value lies within the range of the sorted left half (nums[start] <= target < nums[mid]).
        If it does, update the end index to mid - 1 to search in the left half; otherwise, update the start index to mid + 1 to search in the right half.

        If the right half is sorted, check if the target value lies within the range of the sorted right half (nums[mid] < target <= nums[end]).
        If it does, update the start index to mid + 1 to search in the right half; otherwise, update the end index to mid - 1 to search in the left half.

    6.If none of the above conditions are satisfied, it means there are duplicate elements at the start and middle indices. In this case, increment the start index by 1 and continue the search.

    Repeat steps 3-6 until the start index is less than or equal to the end index.
    If the target value is not found after the search, return false.

    Complexity:
    Time Complexity: The time complexity of the binary search algorithm is O(log N), where N is the number of elements in the array.
    Space Complexity: The space complexity is O(1) since the algorithm uses a constant amount of additional space to store the indices and variables.*/

    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return true;

            // check if the left part is sorted
            if (nums[start] < nums[mid]) {
                // check if target lies in left part
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1; // target in left part so move left
                } else {
                    start = mid + 1; // target not in left part, so move right
                }
            } else if (nums[mid] < nums[start]) { // check if the right part sorted
                //check target lies in the right part
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1; // target in right part so moving right
                } else {
                    end = mid - 1; // target not in the right part, so we move left;
                }
            } else { // if none of the above conditions meets, means there are duplicates, so move start by one
                start += 1;
            }
        }

        return false;
    }


}