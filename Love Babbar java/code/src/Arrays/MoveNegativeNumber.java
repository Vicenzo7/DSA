package Arrays;

public class MoveNegativeNumber {
    public static void main(String[] args) {
        int[] arr=new int[]{-12, 11, -13, -5,
                6, -7, 5, -3, 11};
        shiftAll(arr);
        for(int a:arr)
        {
            System.out.print(a+" ");
        }
    }

    private static void shiftAll(int[] arr) {
        int n= arr.length;
        int left=0,right=n-1;
        while(left<=right)
        {
            if(arr[left]<0 && arr[right]<0)
            {
                left++;
            }
            else if(arr[left]>0 && arr[right]<0)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
            else if(arr[left]>0 && arr[right]>0)
            {
                right--;
            }
            else
            {
                left++;
                right--;
            }

        }
    }
}
