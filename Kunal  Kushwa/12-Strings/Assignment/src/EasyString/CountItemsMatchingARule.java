package EasyString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingARule {
    public static void main(String[] args) {
        List<List<String >> items = new ArrayList<>(3);
        items.add(Arrays.asList("phone","blue","pixel"));
        items.add(Arrays.asList("computer","silver","lenovo"));
        items.add(Arrays.asList("phone","gold","iphone"));

        String ruleKey = "color";
        String ruleValue = "silver";

        System.out.println(countMatches(items,ruleKey,ruleValue));

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count =0;
        for(List<String> x : items)
        {
            if(ruleKey.equals("type") && ruleValue.equals(x.get(0)) )
            {
                count++;
            }
            else if(ruleKey.equals("color") && ruleValue.equals(x.get(1)) )
            {
                count++;
            }
            else if(ruleKey.equals("name") && ruleValue.equals(x.get(2)) )
            {
                count++;
            }
        }
        return count;
    }
}
