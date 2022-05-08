package EasyBS;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n=10;
        int result=firstBadVersion(n);
//        if(result==-1)
//        {
//            System.out.println("no bad");
//        }
//        else{
//            System.out.println(result);
//        }
        System.out.println(result);

    }

    public  static int firstBadVersion(int n) {
        int start=1;
        int end=n;
        int ans=-1;

        while(start<=end)
        {
            int mid =start+(end-start)/2;
            //to find if mid is the bad version
            if(isBadVersion(mid))
            {
                //if mid is bad(true), save the mid and move back to check if there are any more bad;
                ans=mid;
                end=mid-1;
            }
            else{
                //if mid is good(false) move ahead to find the bad;
                start=mid+1;
            }
        }
        return ans;
    }

    private static boolean isBadVersion(int mid) {
        int bad=3;
        if(bad==mid)
        {
            return true;
        }
        else if(bad<mid)
        {
            return true;
        }
        return false;
    }
}
