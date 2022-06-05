package RecursionUnacedemy;

import java.util.ArrayList;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        int n=5,k=2;
        System.out.println(findTheWinner(n,k));
    }

    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<= n;i++)
        {
            list.add(i);
        }
        int curK=0;
        int ans=solve(list,k,curK);
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
}
