package HardBS;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int h=8;
        System.out.println(minEatingSpeed(piles,h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int start=0;
        int end=0;
        int ans=-1;
        for(int x: piles)
        {
            end = Math.max(end,x);
        }

        if(h== piles.length){
            return end;
        }

        while(start<=end)
        {
            int mid= start+(end-start)/2;
            if(isPossible(piles,h,mid))
            {
                ans=mid;
                end=mid-1;
            }
            else{
                start= mid+1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] piles, int h,int mid)
    {
        int hours=0;
        for(int x:piles)
        {
            if(x <= mid)
            {
                hours++;
            }
            else
            {
                int sum = (int) Math.ceil(x*1.0/mid);
                hours += sum;
            }
        }
        if(hours <= h)
        {
            return true;
        }
        return false;
    }
}
