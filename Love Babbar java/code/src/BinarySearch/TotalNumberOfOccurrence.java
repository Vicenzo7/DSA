package BinarySearch;

public class TotalNumberOfOccurrence {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 5, 5, 5, 12};
        int target = 5;
        int first=firstOccurrence(arr,target);
        int last=lastOccurrence(arr,target);
        System.out.println("total number of occurrence");
        System.out.println(last-first+1);

        //simple method
        int[]result=findStartEnd(arr,target);
        int ans =result[1]-result[0]+1;
        System.out.println("total number of occurrence using simple method");
        System.out.println(ans);

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




    //simple method
    private static int[] findStartEnd(int[] arr, int target) {
        // optimized approach with O(log n)
        int start =0,end =arr.length-1;
        while(start<=end)
        {
            if(arr[start]==target && arr[end]==target)
            {
                return new int[]{start,end};
            }
            else if(arr[start]==target && arr[end]!=target)
            {
                end--;
            }
            else if(arr[start]!=target && arr[end]==target)
            {
                start++;
            }
            else
            {
                start++;
                end--;
            }
        }
        return new int[] {-1,-1};
    }
}
