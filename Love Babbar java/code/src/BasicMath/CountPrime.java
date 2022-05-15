package BasicMath;

public class CountPrime {
    public static void main(String[] args) {
        int n=50;
        countPrime(n);
    }

    private static void countPrime(int n) {

        int totalPrime=0;
        for (int i = 1; i <= n ; i++) {
            int count=0;
            for (int j = 1; j <= i ; j++) {
                if(i%j==0)
                {
                    count++;
                }
            }
            if(count==2)
            {
                System.out.print(i+" ");
                totalPrime++;
            }
        }
        System.out.println();
        System.out.println(totalPrime);
    }
}
