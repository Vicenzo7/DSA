/**
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.
 */


package AssignemnetBS;

public class GuessNumber {
    public static void main(String[] args) {
        int n=70;
        int result =guessNumber(n);
        System.out.println(result);
    }

    private static int guessNumber(int n) {
        int start=0;
        int end=n;
        int ans=-1;
        while(start<=end)
        {
            int mid= start+(end-start)/2;
            int myGuess= guess(mid);
            ////0 if myGuess is  equal to the picked number
            if(myGuess==0)
            {
                ans=mid;
                break;
            }
            //1 if myGuess is lower than the picked number
            else if(myGuess==1)
            {
                start = mid+1;
            }
            ////-1 if myGuess is greater than the picked number
            else if(myGuess==-1)
            {
                end=mid-1;
            }
        }
        return ans;
    }

    private static int guess(int num) {

        /**
         * Forward declaration of guess API.
         * @param  num   your guess
         * @return 	     -1 if num is higher than the picked number
         *			      1 if num is lower than the picked number
         *               otherwise return 0
         * int guess(int num);
         */


        int hisPick=50;
        int ans;
        if(num==hisPick)
        {
            ans=0;

        }
        else if (num<hisPick)
        {
            ans=1;
        }
        else
        {
            ans=-1;
        }
        return ans;
    }
}
