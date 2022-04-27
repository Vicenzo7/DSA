package ArraysProblems;

import java.util.HashMap;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int[] arr = {9,4,9,6,7,4};
        int result = firstNonRepeating(arr);
        System.out.println(result);
    }

    public static int firstNonRepeating(int[] arr) {
        int n= arr.length;
        for (int i = 0; i <n ; i++) {
            int j;
            for ( j = 0; j <n ; j++) {
                if(i!=j && arr[i]==arr[j])
                    break;
            }
            if(j==n)
            {
                return arr[i];
            }
        }
        return -1;






       //optimised approach

//        HashMap<Integer,Integer> ans = new HashMap<>();
//        for(int i:arr)
//        {
//            ans.put(i,ans.getOrDefault(i,0)+1);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if(ans.get(arr[i])==1)
//                return arr[i];
//        }
//        return -1;
    }
}
