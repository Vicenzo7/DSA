package BinarySearch;

public class Two2DArrayBinarySearch {
    public static void main(String[] args) {
        int[][] arr ={
                {1,5,9},
                {14,20,23},
                {30,34,43}
        };
        int target=5;

        Two2DarrayBinarySearch(arr,target);
    }

    private static boolean Two2DarrayBinarySearch(int[][] arr, int target) {
        int n=arr.length;
        int m=arr[0].length;

        //find row
        int start=0;
        int end=n-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            //check starting element
            if(arr[mid][0]==target)
            {
                System.out.println(mid+" "+0);
                return true;
            }

            //check ending element of row
            if(arr[mid][m-1]==target)
            {
                System.out.println(mid+" "+ (m-1));
                return true;
            }

            //check if element is present in between starting & ending element
            if(arr[mid][0]<=target && target<=arr[mid][m-1])
            {
                //apply binary search on col
                boolean ans=binarySearch(arr,n,m,mid,target);
                return ans;
            }

            //CHECK Upper part
            if(arr[mid][0] >target)
            {
                end = mid-1;
            }

            //CHECK Lower part
            if(arr[mid][mid-1]<target)
            {
                start = mid+1;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[][] arr, int n, int m, int row, int target) {
        int start=0;
        int end=m-1;

        while(start<=end)
        {
            int mid=start +(end-start)/2;
            if(arr[row][mid]==target)
            {
                System.out.println(row+" "+mid);
                return true;
            }
            else if(arr[row][mid]<target)
            {
                start =mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}
