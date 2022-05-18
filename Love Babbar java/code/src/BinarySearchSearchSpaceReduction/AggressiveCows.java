package BinarySearchSearchSpaceReduction;

import java.util.ArrayList;
import java.util.Collections;

public class AggressiveCows {
    public static void main(String[] args) {

        ArrayList<Integer> stalls= new ArrayList<>();
        stalls.add(0);
        stalls.add(3);
        stalls.add(4);
        stalls.add(7);
        stalls.add(10);
        stalls.add(9);
        int k =4;
        System.out.println(aggressiveCows(stalls,k));

    }

    public static int aggressiveCows(ArrayList<Integer> stalls, int k)
    {
        //first we sort the stalls
        Collections.sort(stalls);
        int start=0;
        int end=0;
        int ans=-1;
        for(int x:stalls){
            end += x;
        }
        //our range is from 0 to max element in the stalls
        while(start<=end)
        {
            int mid= start + (end-start)/2;
            if(isPossible(stalls,k,mid))
            {
                //if mid possible ans we save it and go to right because we want the largest distance
                ans=mid;
                start=mid+1;
            }
            else{
                end= mid-1;
            }
        }
        return ans;
    }

    private static boolean isPossible(ArrayList<Integer> stalls, int k, int mid) {
        int cowCount=1;
        //we assign the first cow at 0th position
        int lastPosition= stalls.get(0);

        for(int x:stalls)
        {
            // to place the second cow  we check if the distance between the is sufficient so that they don't fight
            if(x-lastPosition>=mid)
            {
                //if sufficient that we place the cow and check if the cowCount is equal to the number of cows they have given us
                cowCount++;
                if(cowCount==k)
                {
                    return  true;
                }
                //we than update the lastPostion to the position where we placed the next cow
                lastPosition=x;
            }
        }
        return false;
    }
}
