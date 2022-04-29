package ArraysProblems;

import java.util.HashMap;

public class LargestSubarraywithEqual0and1 {
    public static void main(String[] args) {
        int[] arr={0,1,0,1};
        System.out.println(findLargestSubarray(arr));

    }

    public static int findLargestSubarray(int[] arr) {
//        int n= arr.length;
//        int sum=0,maxsize=-1,startIndex=0,endIndex=0;
//        for(int i=0;i<n;i++)
//        {
//            sum = (arr[i]==0) ? -1:1;
//
//            for (int j = i+1; j < n; j++) {
//                if(arr[j]==0)
//                {
//                    sum +=-1;
//                }
//                else
//                {
//                    sum += 1;
//                }
//
//                if(sum==0 && maxsize<j-i+1)
//                {
//                    maxsize=j-i+1;
//                    startIndex=i;
//                }
//            }
//        }
//        endIndex=startIndex+maxsize-1;
//        if(maxsize==-1)
//        {
//            System.out.println("NO such array");
//
//        }
//        else
//        {
//            System.out.println(startIndex + " to "+endIndex);
//        }


        //optimised using HashMap
        int ans=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;

        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==0)
            {
                sum+= -1;
            }
            else
            {
                sum += 1;
            }

            if(map.containsKey(sum))
            {
                int index=map.get(sum);
                int len=i-index;
                if(len>ans)
                {
                    ans= len;
                }
            }
            else
            {
                map.put(sum,i);
            }
        }
        return ans;
    }
}
