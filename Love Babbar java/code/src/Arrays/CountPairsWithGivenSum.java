package Arrays;

public class CountPairsWithGivenSum {
    public  static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        int k=2;
        int result=getPairsCount(arr,k);
        System.out.println(result);

    }
    static int getPairsCount(int[] arr, int k) {
        int n= arr.length;
        int count=0;
        int sum=0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <n ; j++) {
                sum =arr[i]+arr[j];
                if(sum==k)
                {
                    count++;
                }
            }
        }
        return count;

    }
}
