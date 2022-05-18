package HardBS;

import java.util.ArrayList;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr =new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);


        int k=2;

        System.out.println(findLargestMinDistance(arr,k));
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int start=0;
        int end = 0;
        int ans=-1;
        for(int x: boards)
        {
            end +=x;
        }

        while(start<=end)
        {
            int mid =start+ (end-start)/2;

            if(isPossible(boards,k,mid))
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

    public static boolean isPossible(ArrayList<Integer> boards, int k, int mid)
    {
        int painterCount=1;
        int boardUnit=0;

        for(int x: boards)
        {
            if(boardUnit+x <= mid)
            {
                boardUnit +=x;
            }
            else{
                painterCount++;
                if(painterCount>k || x>mid)
                {
                    return false;
                }
                boardUnit=x;
            }
        }
        return true;
    }
}
