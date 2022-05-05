package BinarySearch;

public class SquareRootWithPrecision {
    public static void main(String[] args) {
        int X=5326;
        int tempSol=(int)sqrt(X);
        System.out.println(tempSol);
        float finalAns= (float) morePrecision(X,3,tempSol);
        System.out.println(finalAns);

    }



    static long sqrt(int target)
    {
        long start=0;
        long end=target;
        long ans=-1;
         while(start<= end)
         {
             long mid=start + (end-start)/2;
             long square=mid*mid;
             if(square== target) {
                 return mid;
             }
             else if(square<target){
                 ans=mid;
                 start=mid+1;
             }
             else{
                 end=mid-1;
             }
         }
         return ans;
    }

   public static double morePrecision(int X, int Precision, int tempSol) {

        double factor=1;
        double ans=tempSol;
        for (int i = 0; i < Precision ; i++) {
           factor = factor/10;
           /*
           0.1
           0.01
           0.001
            */
           for (double j = ans; j*j < X; j=j+factor) {
               ans=j;
           }
        }
        return ans;
    }


}
