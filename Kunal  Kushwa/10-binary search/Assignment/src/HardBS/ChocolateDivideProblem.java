package HardBS;

import java.util.ArrayList;

public class ChocolateDivideProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        int k=5;

        System.out.println(getMaximumSweetness(arr,k));
    }

    public static int getMaximumSweetness(ArrayList<Integer> arr, int k) {
        int start=0;
        int end=0;
        for(int x: arr)
        {
            end += x;
        }

        int ans=-1;

        while(start <= end)
        {
            int mid = start+(end-start)/2;
            if(isPossible(arr,k,mid))
            {
                ans= mid;
                start = mid+1;
            }
            else{
                end =mid -1;
            }
        }
        return ans;
    }

    public static boolean isPossible(ArrayList<Integer> arr, int k, int mid)
    {
//        int sum=0;
//        int friends=1;
//        for(int x: arr)
//        {
//            if(sum +x <= mid)
//            {
//                sum += x;
//            }
//            else
//            {
//                friends++;
//                if(friends> k+1 || x>mid)
//                {
//                    return false;
//                }
//                sum = x;
//            }
//        }
//        return true;

        long sum = 0, cnt = 0;
        for(int n : arr) {
            if(sum + n >= mid) {
                sum = 0;
                cnt++;
            } else {
                sum += n;
            }
        }
        return cnt >= k+1;
    }
}
