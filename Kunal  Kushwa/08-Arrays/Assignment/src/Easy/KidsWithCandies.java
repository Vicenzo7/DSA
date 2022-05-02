package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        int[] candies = { 2,3,5,1,3};
        List<Boolean> result = kidsWithCandies(candies, 3);
        System.out.println(result);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> results= new ArrayList<>();

        int max =candies[0];
        for(int i=1;i<candies.length;i++){
            if(max < candies[i]){
                max = candies[i];
            }
        }

        for(int i=0; i< candies.length; i++){
            if(candies[i] + extraCandies < max){
                results.add(false);
            }
            else{
                results.add(true);
            }
        }
        return results;

//        for (int i = 0; i < candies.length; i++) {
//            candies[i] = candies[i] + extraCandies;
//            for (int j = 0; j < candies.length; j++) {
//                 if(candies[i] >= candies[j]){
//                     results.set(i,true);
//                 }
//                 else{
//                     results.set(i,false);
//                 }
//            }
//            candies[i] = candies[i] - extraCandies;
//
//
//        }
//        return  results;




    }


}
