package RecursionYT;

public class SayDigit {
    public static void main(String[] args) {

        String[] str ={"zero","one","two","three","four","five","six","seven","eight","nine"};

        int n=86548;

        sayDigit(n,str);
    }

    private static void sayDigit(int n, String[] str) {

        //base case
        if(n == 0 )
            return ;

        //processing
        int digit = n % 10;
        n= n/10;
        //reverse printing
//        System.out.print(str[digit]+" ");


        //R.C
        sayDigit(n,str);
        System.out.print(str[digit]+" ");



    }
}
