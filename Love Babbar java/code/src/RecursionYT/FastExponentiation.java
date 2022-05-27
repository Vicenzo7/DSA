package RecursionYT;

public class FastExponentiation {
    public static void main(String[] args) {
        System.out.println(fastExp(3,1));
    }

    public static int fastExp(int a,int b){
        //base case
        if(b == 0)
            return 1;

        //Recursive call
        int ans = fastExp(a,b/2);
        //if b is odd
        if((b&1) == 1)
        {
            return ans * ans *a;
        }
        else{
            //if b is even
            return ans * ans ;
        }
    }
}
