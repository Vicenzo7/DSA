package HardBS;

//https://leetcode.com/problems/magnetic-force-between-two-balls/

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position={1,2,3,4,7};
        int m=3;
        System.out.println(maxDistance(position,m));
    }

    public static int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        long start=0;
        long end=0;
        long ans=-1;
        for(int x:position)
        {
            end += x;
        }


        while(start<=end)
        {
            long mid = start+(end-start)/2;

            if(isPossible(position ,m,mid))
            {
                ans= mid;
                start=mid+1;

            }
            else{
                end = mid-1;
            }
        }
        return (int)ans;
    }


    public static boolean isPossible(int[] position, int m,long mid) {
        int ballCount=1;
        long lastPosition =position[0];

        for(int x:position)
        {
            if(x-lastPosition>= mid)
            {
                ballCount++;
                if(ballCount==m)
                {
                    return true;
                }
                lastPosition =x;
            }
        }
        return false;

    }
}
