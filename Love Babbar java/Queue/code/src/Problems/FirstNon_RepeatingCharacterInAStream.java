package Problems;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNon_RepeatingCharacterInAStream {
    public static String FirstNonRepeating(String s) {
        // to store first non repeating character
        Queue<Character> q = new LinkedList<>();
        //to store frequency
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch,1);
            }

            //Adding character if its frequency is 1
            if(map.get(ch)==1){
                q.add(ch);
            }

            while(!q.isEmpty()){
                char top = q.peek();
                if(map.get(top) == 1){
                    break;
                }else{
                    q.remove();
                }
            }

            if(q.isEmpty()){
                sb.append("#");
            }else{
                sb.append(q.peek());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aabccdba";
        System.out.println(FirstNonRepeating(s));
    }
}
