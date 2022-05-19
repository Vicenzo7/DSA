package HardBS;

import java.util.ArrayList;
import java.util.Collections;

public class RotiParatha {
    public static void main(String[] args) {
        ArrayList<Integer> rank = new ArrayList<>();
        rank.add(1);
        rank.add(2);
        rank.add(3);
        rank.add(4);

        int target =11;
        System.out.println(minCookTime(rank,target));
    }

    public static int minCookTime(ArrayList<Integer> rank, int m)
    {
        //lower bound is 0
        int start=0;

        /**
         *   upper bound : suppose we are given m parata orders and  there is only one cook so total time taken by him is
         *   int min = Collections.min(rank);
         *    int end=min*(m*(m+1))/2;
         */
        int min = Collections.min(rank);
//        int end=min*(m*(m+1))/2;
        int end = (int)Math.pow(10,9);
        int ans=-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
             if(isPossible(rank,m,mid))
             {
                 ans=mid;
                 end=mid-1;
             }
             else{
                 start=mid+1;
             }
        }
        return ans;
    }

    private static boolean isPossible(ArrayList<Integer> rank, int m, int mid) {
        // initially paratha made is 0;
        int paratha=0;
        // time is also 0
        int time=0;

        for(int r:rank)
        {
            // the first cook will take r time to make paratha
            time=r;
            int j=2;
            while(time<=mid)
            {
                // if time taken by the cook is less or equal to the time assumed by us than he will make a paratha
                paratha++;
                // and to make next paratha he will take R+2R+.......
                // so time = time + j*r and will increment j counter
                time += j*r;
                j++;
            }

            // if no of paratha is greater  or equal to target paratha than our assumed time(mid) is a possible ans
            if(paratha>=m)
            {
                return true;
            }
        }
        return false;
    }
}
