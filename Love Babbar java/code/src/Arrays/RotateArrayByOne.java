package Arrays;

public class RotateArrayByOne {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};

//        int k=arr[arr.length-1];
//        for (int i = arr.length-1; i >0 ; i--) {
//            arr[i]=arr[i-1];
//        }
//        arr[0]=k;
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.print(arr[i]+" ");
//        }

        //second approach
        int first=0,last= arr.length-1;
        while(first!=last)
        {
            int temp= arr[first];
            arr[first] = arr[last];
            arr[last]=temp;
            first++;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
