package MediumString;

public class NumberOfWaysToSplitAString {
    public static void main(String[] args) {
        String s = "10101";
        System.out.println(numWays(s));
    }

    public static int numWays(String s) {
        long noOfOne=0;//to count number of ones
        long n = s.length();
        long MOD = 1_000_000_007;
        char[] ch = s.toCharArray();

        for(char c:ch)
        {
            if(c == '1')
                noOfOne++;
        }

        //there will be 3 cases
        // 1.no ones present in the string
        // 2.number of ones present in the string isnt divisible by 3(since we need to cut 3 parts)
        // 3.number of ones divisible by 3

        if(noOfOne == 0)//case 1
            return (int) ((((n-1)*(n-2))/2) % MOD);


        if(noOfOne % 3 != 0) //case 2,which means we cant split ones equally
            return 0;

        //case 3
        long oneInEachPart = noOfOne/3;//number of ones that should be present in each part
        long part1=0;//number of ways in which part1 and part2 can be split
        long part2=0;

        noOfOne=0;

        for(int i=0;i<ch.length;i++)
        {
            if(ch[i] == '1')
                noOfOne++;

            if(noOfOne == oneInEachPart)
                part1++;

            if(noOfOne == 2*oneInEachPart)
                part2++;
        }

        return (int) ((part1 * part2) %MOD);

    }
}
