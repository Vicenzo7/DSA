package RecursionUnacedemy;

public class MaxNumber {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5, 1,0,12};
        System.out.println(find(arr, arr.length-1,Integer.MIN_VALUE));
    }

    public static int find(int[] arr,int size,int initial)
    {
        int max = initial;
        //base case
        if(size<0)
            return max;

        max=Math.max(max,arr[size]);
        return find(arr, size-1, max);
    }
}
