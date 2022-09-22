public class Fibo {
    public static void main(String[] args) {
        //int ans = fibo(6);
        //System.out.println(ans);

        for (int i = 0; i < 11; i++) {
            System.out.println(fiboFormula(i));
        }

        System.out.println(fiboFormula(50));

    }

    public static int fibo(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibo(n - 1) + fibo(n - 2);
    }


    static int fiboFormula(int n) {
        // just for demo use long instead
        return (int) (Math.pow(((1 + Math.sqrt(5)) / 2), n) / Math.sqrt(5));
        //return (int) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5));
    }
}
