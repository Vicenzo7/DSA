package BinarySearch;

public class SquareRoot {
    public static void main(String[] args) {
        int X=37;
        System.out.println(bruteForce(X));
        System.out.println((int)binarySearch(X));

    }


    static int bruteForce(int X)
    {
        int ans=-1;
        for (int i = 1; i < X ; i++) {
            if(i*i==X)
            {
                return i;
            }
            else if(i*i<X)
            {
                ans=i;
            }
        }
        return ans;
    }

   static long binarySearch(int target)
   {

       //we took long for big numbers so integer overflow doesn't occur
       long start=0;
       long end = target-1;
       long ans=-1;
       while (start<=end)
       {
           long mid= start +(end-start)/2;
           long square=mid*mid;
           //if square
           if(square==target){
               return mid;
           }
           else if(square <target){
               //if square< target we are storing mid in ans because if it's not a perfect square we would store the nearest square;
               ans=mid;
               start=mid+1;
           }
           else{ //square>target
               end = mid-1;
           }
       }
       return ans;
   }

}
