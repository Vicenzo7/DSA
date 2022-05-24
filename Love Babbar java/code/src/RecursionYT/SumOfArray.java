package RecursionYT;

public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = {2,8,4,9,7,3};
        int n = arr.length;
        int sum = calculateSum(arr,n);
        System.out.println("Sum is "+sum);
    }

    private static int calculateSum(int[] arr,int size) {
        //base case
        if (size == 0 || size <0)
            return 0;
        if (size == 1)
            return arr[0];

        int sum = arr[size-1] + calculateSum(arr,size-1);

        return sum;
    }
}
