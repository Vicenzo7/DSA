package ArraysProblems;

public class MinimumSwap {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 3};
        int k=3;
        int result=minSwap(arr,k);
        System.out.println(result);
    }

    public static int  minSwap(int[] arr,int k) {
        int good=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]<=k)
            {
                good++;
            }
        }
        int bad =0;
        for (int i = 0; i <good ; i++) {
            if(arr[i]>k)
            {
                bad++;
            }
        }

        int ans=bad;
        for (int i = 0,j=good; j<arr.length  ; i++,j++) {
            if(arr[i]>k)
            {
                bad--;
            }
            if(arr[j]>k)
            {
                bad++;
            }

            ans=Math.min(ans,bad);
        }
        return ans;
    }
}
