package ArraysProblems;

public class KadaneAlgo {
    public static void main(String[] args) {
        int[]  arr ={1,2,3,-2,5};
        int result =kadanesAlgo(arr);
        System.out.println(result);
    }

    private static int kadanesAlgo(int[] arr) {
        int sum=0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i <arr.length ; i++) {
            sum += arr[i];
            maxi=Math.max(sum,maxi);
            if(sum<0)
            {
                sum=0;
            }
        }
        return maxi;
    }
}
