package Arrays;

public class SwapAlternates {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6};
        swapAlternate(arr);
        for(int a:arr)
        {
            System.out.print(a+" ");
        }
    }

    private static void swapAlternate(int[] arr) {
        int n=arr.length;
//        for (int i = 0; i < n/2; i +=2) {
//            int temp=arr[i];
//            arr[i] = arr[n-i-1];
//            arr[n-i-1]=temp;
//        }

        int start=0,end=n-1;
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start +=2;
            end-=2;
        }
    }
}
