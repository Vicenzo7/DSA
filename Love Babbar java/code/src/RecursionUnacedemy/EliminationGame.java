package RecursionUnacedemy;

public class EliminationGame {
    public static void main(String[] args) {
        int n =9;
        System.out.println(lastRemaining(n));
    }

    public static int lastRemaining(int n) {

        return n==1 ? 1 : 2*(1+n/2 - lastRemaining(n/2));
    }

}
