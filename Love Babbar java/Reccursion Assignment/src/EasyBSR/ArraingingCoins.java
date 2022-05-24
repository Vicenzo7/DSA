package EasyBSR;

class ArraingingCoins {

    public static void main(String[] args) {
        int n=15;
        int result = arrangeCoins(n);
        System.out.println(result);
    }

    public static int arrangeCoins(int n) {
        long ans= binarySearch(0,n,n);
        return (int)ans;
    }
    
     public static  long binarySearch(long start,long end,int n) {

         
        //base case
        if(start>end)
            return end;
        
        long mid = start + (end-start)/2;
        long possible= mid*(mid+1)/2;
        //BS conditions
        if(possible == n){
             return mid;            
        }
           
            
        else if(possible<n)
        {
            return binarySearch(mid+1,end,n);
        }
        else{
            return binarySearch(start,mid-1,n);
        }
    }
}