package basic.math;
//https://practice.geeksforgeeks.org/problems/count-digits5716/1
public class CountDigitsWhichDivideTheNumberNEvenly {
    public static void main(String[] args) {
        int n = 3298392;
        System.out.println(evenlyDivides(n));
    }

    public static int evenlyDivides(int N){
        int count = 0;
        int num = N;
        while(N>0) {
            int lastDigit = N%10;
            if(lastDigit!= 0 &&  num % lastDigit == 0) {
                count++;
            }
            N = N/10;
        }

        return count;
    }
}
