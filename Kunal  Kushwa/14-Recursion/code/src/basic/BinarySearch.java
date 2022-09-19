package basic;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,55,66,78};
        int s=0;
        int e = arr.length-1;
        int target = 90;
        System.out.println(binarySearch(arr,s,e,target));

    }



    public static int binarySearch(int[] arr,int s,int e,int target){

        if(s>e)
            return -1;

        int m = s+(e-s)/2;

        if(arr[m] == target)
            return m;

        if(arr[m] < target)
            return binarySearch(arr,m+1,e,target);

        return binarySearch(arr,s,m-1,target);

    }
}
