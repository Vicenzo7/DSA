package BinarySearchSearchSpaceReduction;

import java.util.ArrayList;

public class BookAllocation {
    public static void main(String[] args) {
        ArrayList<Integer> arr =new ArrayList<>();
        arr.add(3);

        int m=1;

        System.out.println(allocateBooks(arr,1,m));
    }

    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        int start=0;
        int end=0;
        int ans=-1;

        for(int num:arr)
        {
            end += num;
        }

        while(start<= end)
        {
            int mid= start+(end-start)/2;
            if(isPossible(arr,n,m,mid))
            {
                // If mid is a possible ans than store it and move to left the find if there are more ans which is minimum than the current ans
                ans=mid;
                end=mid-1;
            }
            else{
                //moving right to find a possible ans
                start= mid+1;
            }
        }
        return ans;
    }



    public static boolean isPossible(ArrayList<Integer> arr, int n, int m,int mid)
    {
        int studentCount=1;
        int pageSum=0;

        for(int num:arr)
        {
            if(pageSum + num <= mid)
            {
                pageSum +=num;
            }
            else
            {
                studentCount++;
                //checking if our student count is more than the student they provided us and also if the num is greater than mid
                if(studentCount> m || num> mid)
                {
                    return false;
                }
                pageSum = num;
            }
        }
        return true;
    }

}
