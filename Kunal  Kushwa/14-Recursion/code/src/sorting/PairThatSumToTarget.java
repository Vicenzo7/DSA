package sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairThatSumToTarget {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(5, 7, 9, 13, 11, 6, 6, 3, 3));

        System.out.println(stockPairs(list,12));
    }

    // 12 = 5-7  3-9  , 3-9 , 6-6
    // output = 3 not to count duplicates

    public static int stockPairs(List<Integer> stocksProfit, long target){
        Collections.sort(stocksProfit);
        int start = 0;
        int end = stocksProfit.size()-1;
        int count =0;
        while (start <= end){
            if (stocksProfit.get(start) + stocksProfit.get(end) == target){
                count++;
                while (start<end && stocksProfit.get(start) == stocksProfit.get(start + 1)){
                    start +=1;
                }

                while ( start<end && stocksProfit.get(end) == stocksProfit.get(end - 1)){
                    end -=1;
                }
                start = start+1;
                end = end-1;
            }else if (stocksProfit.get(start) + stocksProfit.get(end) < target){
                start +=1;
            }else {
                end -=1;
            }
        }

        return count;

    }
}
