package ArraysProblems;

import java.util.HashMap;

public class FirstRepeatingElementIndex {
    public static void main(String[] args) {
        int[] arr={1, 5, 3, 4, 3, 5, 6};
        int result=firstFound(arr);
        System.out.println(result);
    }

    private static int firstFound(int[] arr) {
        int n =arr.length;
        HashMap<Integer,Integer> ans = new HashMap<>();
        for(int i:arr)
        {
            ans.put(i,ans.getOrDefault(i,0)+1);
        }
        for (int i = 0; i <n ; i++) {
            if(ans.get(arr[i])>=2);
            {

                return i+1;
            }
        }
        return -1;
    }
}
