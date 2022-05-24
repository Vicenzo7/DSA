package RecursionYT;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={1,5,6,7,8,9,10,15,18,20,22};
        int target=1;
        int ans=binarySearch(arr,0,arr.length-1,target);
        if(ans != -1)
        {
            System.out.println("Element present at index "+ans);
        }
        else
            System.out.println("Element not present");
    }

    private static int binarySearch(int[] arr,int start,int end,int target) {

        printArray(arr,start,end);

        //base case
        if(start>end)
            return -1;
        System.out.println();
        int mid = start + (end-start)/2;
        System.out.println("Value of mid "+mid);

        System.out.println();

        //BS conditions
        if(arr[mid] == target)
            return mid;
        else if(arr[mid]<target)
        {
            return binarySearch(arr,mid+1,end,target);
        }
        else{
            return binarySearch(arr,start,mid-1,target);
        }
    }

    private static void printArray(int[] arr, int start,int end) {
        for(int x =start;x<=end;x++)
        {
            System.out.print(arr[x]+" ");
        }

    }


}
