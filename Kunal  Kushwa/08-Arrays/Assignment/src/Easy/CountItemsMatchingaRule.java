//Count Items Matching a Rule
package Easy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountItemsMatchingaRule {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<List<String>> items = new ArrayList<>();

        for(int i=0; i < 3; i++) {
            items.add(new ArrayList<>());
        }

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                items.get(i).add(in.next());
            }
        }
        System.out.println(items);

        String ruleKey = "color";
        String ruleValue = "silver";
        int ans = countMatches(items,ruleKey,ruleValue);
        System.out.println(ans);

//        phone blue pixel computer silver lenovo phone gold iphone
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count = 0;
        for(List<String> list: items){
            if(ruleKey.equals("type") && ruleValue.equals(list.get(0)))
                count++;
            else if(ruleKey.equals("color") && ruleValue.equals(list.get(1)))
                count++;
            else if(ruleKey.equals("name") && ruleValue.equals(list.get(2)))
                count++;
        }
        return count;
    }
}







