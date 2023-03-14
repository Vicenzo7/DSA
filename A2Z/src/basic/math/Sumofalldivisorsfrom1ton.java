package basic.math;

public class Sumofalldivisorsfrom1ton {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(sumOfDivisors(n));

      /*  N = 4
        Output:
        15
        Explanation:
        F(1) = 1
        F(2) = 1 + 2 = 3
        F(3) = 1 + 3 = 4
        F(4) = 1 + 2 + 4 = 7
        ans = F(1) + F(2) + F(3) + F(4)
                = 1 + 3 + 4 + 7
                = 15*/
    }

     /*FIRST ITERATION

        see in the summation of f(1)+f(2)+f(3)+f(4)

        when you divide(4/1=4)

        and when you multiply divisor(1) by quotient(4) i.e 1*4

        (1*4) means 1 is occurring 4 times in the summation of f(1)+f(2)+f(3)+f(4)*/



        /*SECOND ITERATION

        when you divide(4/2=2)

        and when you multiply divisor(2) by quotient(2) i.e 2*2

        (2*2) means 2 is occurring 2 times in the summation of f(1)+f(2)+f(3)+f(4)*/



        /*THIRD ITERATION

        when you divide(4/3=1)

        and when you multiply divisor(3) by quotient(1) i.e 3*1

        (3*1) means 3 is occurring 1 times in the summation of f(1)+f(2)+f(3)+f(4)*/



        /*FOURTH ITERATION

        when you divide(4/4=1)

        and when you multiply divisor(4) by quotient(1) i.e 4*1

        (4*1) means 4 is occurring 1 times in the summation of f(1)+f(2)+f(3)+f(4)*/

    public static long sumOfDivisors(int N) {
        // code here
        long ans = 0;
        for (long i = 1; i <= N; i++) {
            ans += (N / i) * i;
        }

        return ans;
    }
}
