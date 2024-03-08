package BasicMath;

public class SegmentedSieve {
    public static void main(String[] args) {
        int x=10;
        int y=30;
        System.out.println(segmentedSieve(x,y));
    }

    private static int segmentedSieve(int x, int y) {
        boolean[] isPrime = new boolean[y+1];

        for (int i = 2; i <y ; i++) {
            isPrime[i]= true;
        }


        for (int i = 2; i*i<y ; i++) {
            if(!isPrime[i])
            {
               continue;
            }
            for (int j =i*i; j < y ; j=j+i) {
                isPrime[j]=false;
            }
        }
        int count = 0;
        for (int i = x; i < y; i++) {
            if (isPrime[i]) count++;
        }
        return count;

    }
}
