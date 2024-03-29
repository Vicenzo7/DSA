
package Easy;

public class RichestCustomerWealth {
    public static void main(String[] args) {

        int[][] accounts = {
                {1,5},
                {7,3},
                {3,5}
        };
        int results = maximumWealth(accounts);

        System.out.println(results);

    }

    public static int maximumWealth(int[][] accounts) {


        int max=Integer.MIN_VALUE ;
        for (int row = 0; row < accounts.length; row++) {
            int sum=0;
            for (int col = 0; col < accounts[row].length; col++) {
                sum = sum + accounts[row][col];
            }
            max=Math.max(sum,max);
        }
       return  max;
    }


//    public static int maximumWealth(int[][] accounts) {
//        int n = accounts.length;
//        int[] richest = new int[n];
//        int max=0;
//
//        for(int row=0; row<accounts.length; row++){
//            int sum=0;
//            for(int col=0; col < accounts[row].length; col++){
//                sum = sum + accounts[row][col];
//            }
//            richest[row] = sum;
//        }
//
//        max = richest[0];
//        for(int i=1;i< richest.length; i++){
//            if(max< richest[i]){
//                max= richest[i];
//            }
//        }
//
//        return max;
//    }
}
