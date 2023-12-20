package slidingwindow.fixedSize;

public class NumberOfSubArrays {
    // https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
    public static void main(String[] args) {
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 3, threshold = 5;
        System.out.println(numOfSubarrays(arr, k, threshold));
    }


    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0, left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (right - left + 1 > k) { // checking if subarray(window) does not cross k size
                if (sum / k >= threshold) { // if subbray size is going to cross, checking its average >= threshold
                    count++;
                }
                sum -= arr[left]; // reducing sum to accommodate next window element
                left += 1; // incrementing left pointer to accommodate right window size subarray
            }

            sum += arr[right];
        }

        // when array exist finding if the average >= threshold
        if (sum / k >= threshold) {
            count++;
        }

        return count;
    }
}
