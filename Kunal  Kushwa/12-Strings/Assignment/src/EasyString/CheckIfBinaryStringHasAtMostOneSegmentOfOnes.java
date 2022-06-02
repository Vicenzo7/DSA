package EasyString;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public static void main(String[] args) {
        String s = "11111111000000";
        System.out.println(checkOnesSegment(s));
    }
    public static boolean checkOnesSegment(String s) {
         return !s.contains("01");
    }
}