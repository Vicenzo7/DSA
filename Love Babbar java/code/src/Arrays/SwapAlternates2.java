package Arrays;

public class SwapAlternates2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7};
        swapAlternate2(arr);
        for(int a:arr)
        {
            System.out.print(a+" ");
        }
    }

    private static void swapAlternate2(int[] arr) {
        int n= arr.length;
        for (int i = 0; i <n ; i+=2) {
            if(i+1<n)// this we are doing if total array elements are odd
            {
                int temp=arr[i];
                arr[i] =arr[i+1];
                arr[i+1] = temp;
            }
        }
        int j=0;
//        while(j<n)
//        {
//            if(j+1<n)
//            {
//                int temp=arr[j];
//                arr[j] =arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        while(j+1<n)
//        {
//            int temp=arr[j];
//            arr[j] =arr[j+1];
//            arr[j+1] = temp;
//        }



    }
}
