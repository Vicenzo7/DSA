package RecursionYT;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,8,4,9,7,3};
        int n = arr.length;
        int target=99;
        System.out.println(linearSearch(arr,n,target));
    }

    private static boolean linearSearch(int[] arr, int size,int target) {

        //base case
        if(size == 0)
            return false;

        if(size<0)
            return false;

        if(arr[size-1] == target)
            return true;
        else
        {
            return  linearSearch(arr,size-1,target);
        }

    }
}
