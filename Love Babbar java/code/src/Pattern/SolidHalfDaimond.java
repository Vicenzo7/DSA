package Pattern;

public class SolidHalfDaimond {
    public static void main(String[] args) {
        int n=5;
        for (int row = 1; row <=n ; row++) {
            for (int col = 1; col <=row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int row = 1; row <=n-1 ; row++) {
            for (int col = 1; col <=n-row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
