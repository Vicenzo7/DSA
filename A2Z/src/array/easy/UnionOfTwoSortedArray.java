package array.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums2 = {2, 3, 4, 4, 5, 11, 12};
//        ArrayList<Integer> union = findUnion(nums1, nums2, nums1.length, nums2.length);
        ArrayList<Integer> union = union(nums1, nums2, nums1.length, nums2.length);
        System.out.println(union);
    }


    /*
     * TC -> Inserting an element in a set takes log(n)
     * There are m+n elements so tc to add elements in a set is log(m+n) also we are
     * traversing the array so tc here is O(m+n)
     * Total TC O((m+n)log(m+n))
     *
     * Space Complexity
     * */

    public static ArrayList<Integer> findUnion(int nums1[], int nums2[], int n, int m) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set.add(num);
        }
        return new ArrayList<>(set);
    }

    // Using 2 pointer
    /*
     * Traverse both the array from 0 til their length
     * Now we have 3 cases
     * 1. arr[i] == arr[j]
     * Check if the list is empty if empty add arr[i] and increment i if
     * not empty check if the last element int the list is not same as arr[i] if not equal add arr[i] in the list and increment i.
     * This we do to avoid duplicates
     *
     * 2. arr[i] < arr[j]
     * Check if the list is empty if empty add arr[i] and increment i if
     * not empty check if the last element int the list is not same as arr[i] if not equal add arr[i] in the list and increment i.
     * This we do to avoid duplicates
     *
     * 3 arr[i] > arr[j]
     * Check if the list is empty if empty add arr[j] and increment j if
     * not empty check if the last element int the list is not same as arr[j] if not equal add arr[j] in the list and increment j.
     * This we do to avoid duplicates
     *
     * after this there may be some remaining elements in arr1 or arr2 add them carefully such that there are no duplicates
     *
     * TC -> O(m+n)
     * * */

    public static ArrayList<Integer> union(int[] nums1, int[] nums2, int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < n) {
            if (list.get(list.size() - 1) != nums1[i]) {
                list.add(nums1[i]);
            }
            i++;
        }

        while (j < m) {
            if (list.get(list.size() - 1) != nums2[j]) {
                list.add(nums2[j]);
            }
            j++;
        }
        return list;

    }
}
