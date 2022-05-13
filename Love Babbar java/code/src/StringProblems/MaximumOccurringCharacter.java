package StringProblems;

public class MaximumOccurringCharacter {
    public static void main(String[] args) {
        String str = "testsample";
        char ans = getMaxOccuringChar(str);
        System.out.println(ans);
    }

    public static char getMaxOccuringChar(String line) {
        //array to store the frequency of each letter in string
        int[] frequency = new int[26];
        int max = Integer.MIN_VALUE;
        int index = Integer.MAX_VALUE;
        //storing frequency
        for (int i = 0; i < line.length(); i++) {
            //lower case
            if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
                frequency[line.charAt(i) - 'a']++;
            } else {
                //upper case
                frequency[line.charAt(i) - 'A']++;
            }

        }


        //finding the max frequency
        for (int i = 0; i < 26; i++) {
            //if max is max storing the greater max and its index
            if (max < frequency[i]) {
                max = frequency[i];
                index = i;
            }
        }
        System.out.println(index);

        char ans = (char) (index + 'a');
        return  ans;
    }

}
