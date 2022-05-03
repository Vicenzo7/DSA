package BinarySearch;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 5, 5, 5, 12};
        int target = 5;
        System.out.println(firstOccurrence(arr, target));
        System.out.println(lastOccurrence(arr, target));



    }

    static int firstOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else //arr[mid] > target
            {
                end = mid - 1;
            }
        }
        return ans;
    }


    static int lastOccurrence(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;
                start = start + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else //arr[mid] > target
            {
                end = mid - 1;
            }
        }
        return ans;
    }
}
