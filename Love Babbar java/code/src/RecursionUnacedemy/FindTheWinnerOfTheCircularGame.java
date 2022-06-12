package RecursionUnacedemy;

import java.util.ArrayList;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        int n=5,k=2;
        System.out.println(findTheWinner(n,k));
        System.out.println(findTheWinner2(n,k));
    }

    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<= n;i++)
        {
            list.add(i);
        }
        int curK=0;
        int ans=solve(list,k,curK);
        int ans2 = solve2(n,k)+1;
        return ans;

    }

    public static int solve(ArrayList<Integer> list,int k,int curK)
    {
        if(list.size() == 1)
            return list.get(0);


        curK=(curK + k-1)%list.size();
        list.remove(curK);
        return solve(list,k,curK);
    }


    public static int findTheWinner2(int n, int k) {

        int ans2 = solve2(n,k)+1;
        return ans2;

    }


    // optimization
    public static int solve2(int n,int k)
    {
        //base case
        if(n == 1)
            return 0;


        return (solve2(n-1,k)+k)%n;
    }
}
