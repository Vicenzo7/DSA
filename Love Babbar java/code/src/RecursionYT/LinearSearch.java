package RecursionYT;



public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,8,4,9,7,3};
        int n = arr.length;
        int target=2;
        System.out.println(linearSearch(arr,n,target));
    }

    private static boolean linearSearch(int[] arr, int size,int target) {

        printArray(arr,size);
        System.out.println();
        //base case
        if(size == 0)
            return false;

        if(arr[size-1] == target)
            return true;
        else
        {
            return  linearSearch(arr,size-1,target);
        }

    }

    private static void printArray(int[] arr, int size) {
        System.out.println("Size of Array "+size);

        for(int x =0;x<size;x++)
        {
            System.out.print(arr[x]+" ");
        }
    }
}
