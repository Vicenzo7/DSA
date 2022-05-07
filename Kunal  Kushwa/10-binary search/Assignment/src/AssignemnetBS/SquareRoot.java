package AssignemnetBS;

public class SquareRoot {
    public static void main(String[] args) {
        int x=16;
        System.out.println(mySqrt(x));

    }

    public static int mySqrt(int x) {

        long start=0;
        long end =x;
        long ans=-1;
        while(start<=end)
        {
            long mid=start +(end-start)/2;
            long square =mid*mid;
            if(square==x)
            {
                return (int)mid;
            }
            else if(square<x)
            {
                ans=mid;
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return (int)ans;

    }
}
