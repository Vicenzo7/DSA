package Problems;

import java.util.ArrayList;

public class Help {

    public  static int solve(int n,int c,int d,int[] a,int[] b){

        int count = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n ; j++) {
                int first = a[i] - a[j] +c;

                int second = b[i] - b[j] +d;


                if(first <= second)
                    count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {

        int n=5,c=3,d=2;
        int[] a ={9,4,2,3,6};
        int[] b ={1,4,3,1,2};
        System.out.println(solve(n,c,d,a,b));
    }
}
