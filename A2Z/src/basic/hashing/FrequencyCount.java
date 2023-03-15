package basic.hashing;
//https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/0
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {
    public static void main(String[] args) {
        int N = 5,P = 5;
        int[] arr = {2, 3, 2, 3, 5};
        frequencyCount(arr,N,P);

    }

    public static void frequencyCount(int[] arr, int N, int P) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for (int i : arr) {
            int frequencyCount = frequencyMap.getOrDefault(i, 0);
            frequencyMap.put(i, frequencyCount + 1);
        }

        for (int i = 1; i <=N ; i++) {
            arr[i-1] = frequencyMap.getOrDefault(i, 0);
        }

        System.out.println(Arrays.toString(arr));
    }


}
