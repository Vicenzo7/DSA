package Pattern;

public class hallowInvertedHalfPyramid {
    public static void main(String[] args) {
        int n=16;
        for (int row = 1; row <= n; row++) {
            //till n rows

            if(row == 1 || row ==n)
            {
                for (int col = 1; col <= n-row+1 ; col++) {
                    System.out.print("*");
                }
            }
            else
            {
                System.out.print("*");
                for (int col = 1; col <=n-row-1 ; col++) {
                    System.out.print(" ");
                }

                System.out.print("*");

            }
            System.out.println();
        }
    }
}
