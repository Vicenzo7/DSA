package ArraysProblems;


import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(isMajorityElement(arr));
    }

    private static int isMajorityElement(int[] arr) {
        //brute force approach
//        int n= arr.length;
//        int maxCount=-1, index=-1;
//        for (int i = 0; i < arr.length; i++) {
//            int count=0;
//            for (int j = 0; j < arr.length ; j++) {
//                if(arr[i]==arr[j])
//                {
//                    count++;
//                }
//            }
//
//            if(count>maxCount)
//            {
//                maxCount=count;
//                index=i;
//            }
//        }
//
//        if(maxCount> n/2)
//        {
//            return arr[index];
//        }
//        else
//        {
//            return -1;//indicates no majority element
//        }




        //optimised solution
        int n= arr.length;
        if(n==1)
        {
            return arr[0];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            if(map.containsKey(arr[i]))
            {
                int count =map.get(arr[i]) +1;
                if(count > n/2)
                {
                    return arr[i];
                }
                else
                {
                    map.put(arr[i],count );
                }
            }
            else
            {
                map.put(arr[i],1);
            }
        }
        return -1;//indicates no majority element



        //
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i:arr)
//        {
//            map.put(i,map.getOrDefault(i,0)+1);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if(map.containsKey(arr[i]))
//            {
//                int count=map.get(arr[i])+1;
//                if(count> arr.length/2)
//                {
//                    return arr[i];
//                }
//                else
//                {
//                    map.put(arr[i],count);
//                }
//            }
//            else
//            {
//                map.put(arr[i],1);
//            }
//        }
//        return -1;

    }
}
