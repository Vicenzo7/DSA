
package Easy;
import java.util.Scanner;

public class prajwal {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if(a>0)
        {
            int b =countCurrency(a);
            System.out.println(b);
        }
        else{
            System.out.println("Invalid Input");
        }



    }

    public static int countCurrency(int amount)
    {
        int[] notes = new int[]{ 500,100, 50,10, 5, 1 };
        int[] noteCounter = new int[6];


        for (int i = 0; i < 6; i++) {
            if (amount >= notes[i]) {
                noteCounter[i] = amount / notes[i];
                amount = amount - noteCounter[i] * notes[i];
            }
        }
        int sum=0;
        for (int i = 0; i < noteCounter.length ; i++) {
             sum = sum+noteCounter[i];
        }



        return sum;
    }
}
