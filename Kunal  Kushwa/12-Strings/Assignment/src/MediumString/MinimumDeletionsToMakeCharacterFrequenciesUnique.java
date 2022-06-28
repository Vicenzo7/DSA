package MediumString;
//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
import java.util.HashSet;


public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        String s = "aaabbbcc";
        System.out.println(minDeletions(s));
    }

    public  static int minDeletions(String s) {

        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) -'a']++;
        }


        HashSet<Integer> set = new HashSet<>();
        int deleteCount=0;
        for (int i = 0; i < 26 ; i++) {
            while(frequency[i] >0 && set.contains(frequency[i])){
                frequency[i]--;
                deleteCount++;
            }
            set.add(frequency[i]);
        }

        return deleteCount;
    }
}
