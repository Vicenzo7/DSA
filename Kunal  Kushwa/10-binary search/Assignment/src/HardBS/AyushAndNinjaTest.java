package HardBS;

//https://www.codingninjas.com/codestudio/problems/ayush-and-ninja-test_1097574?source=youtube&campaign=love_babbar_codestudio2&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_codestudio2&leftPanelTab=0

public class AyushAndNinjaTest {
    public static void main(String[] args) {
        int[] time= {30,20,10,40,5,45};
        int n=3;

        System.out.println(ayushGivesNinjatest(n,6,time));
    }
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        int start=0;
        int end= 0;
        int ans=-1;

        for(int x:time)
        {
            end += x;
        }

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isPossible(time,n,m,mid))
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


    public static boolean isPossible(int[]time, int n,int m,int mid)
    {
        int daysCount=1;
        int chapters=0;

        for(int x:time)
        {
            if(chapters+x<=mid)
            {
                chapters += x;
            }else{
                daysCount++;
                if(daysCount> n || x>mid)
                {
                    return false;
                }
                chapters=x;
            }
        }
        return true;
    }
}
