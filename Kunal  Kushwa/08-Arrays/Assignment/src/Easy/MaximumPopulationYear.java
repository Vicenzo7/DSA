package Easy;
import java.util.Arrays;

//Maximum Population Year
public class MaximumPopulationYear {
    public static void main(String[] args) {
        int[][] logs ={
                {1993,1999},
                {2000,2010}
        };
       int ans= maximumPopulation(logs);
        System.out.println(ans);

    }
    public static int maximumPopulation(int[][] logs){
        int[] years = new int[101];

        //brute force
//        for (int i = 0; i < logs.length; i++) {
//            for (int j = logs[i][0]; j < logs[i][1]; j++) {
//                years[j-1950]++;
//            }
//        }
//        int maxYear=0,maxValue=0;
//        for (int i = 0; i < 101 ; i++) {
//            if(years[i]>maxValue)
//            {
//                maxValue=years[i];
//                maxYear= i+1950;
//            }
//
//        }


        //optimised solution
        for (int i = 0; i < logs.length; i++) {
            years[logs[i][0]-1950]++;
            years[logs[i][1]-1950]--;
        }
        for (int i =1 ; i <101 ; i++) {
            years[i] = years[i] + years[i-1];

        }
        int maxYear=0,maxValue=0;
        for (int i = 0; i < 101 ; i++) {
            if(years[i]>maxValue)
            {
                maxValue=years[i];
                maxYear= i+1950;
            }

        }
        return maxYear;
    }

}
