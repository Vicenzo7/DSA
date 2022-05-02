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
        //count window size
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]<=k)
            {
                good++;
            }
        }
        int bad =0;
        //checking for first window; checking till window size
        for (int i = 0; i <good ; i++) {
            if(arr[i]>k)
            {
                bad++;
            }
        }

        int ans=bad;
        for (int i = 0,j=good; j<arr.length  ; i++,j++) {
            //bad-- because starting number of window if greater than k we remove it
            //check old element
            if(arr[i]>k)
            {
                bad--;
            }
            //bad++ because ending number of window if greater than k we add it in our window
            //check new element
            if(arr[j]>k)
            {
                bad++;
            }

            ans=Math.min(ans,bad);
        }
        return ans;
    }
}
