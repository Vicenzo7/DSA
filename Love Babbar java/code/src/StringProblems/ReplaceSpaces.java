package StringProblems;

public class ReplaceSpaces {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Coding Ninjas Is A Coding Platform");
        StringBuilder ans= replaceSpaces(str);
        System.out.println(ans);
    }

    public static StringBuilder replaceSpaces(StringBuilder str) {
        // Write your code here.\
        StringBuilder ans= new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            String st= String.valueOf(str.charAt(i));
            if(st.contains(" "))
            {
                st="@40";
                ans.append(st);
            }
            else{
                ans.append(st);
            }
        }
        return ans;
    }
}
