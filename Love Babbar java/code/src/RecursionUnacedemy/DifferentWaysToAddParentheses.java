package RecursionUnacedemy;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String str = "2*3-4*5";
        System.out.println(diffWaysToCompute(str));
    }

    public static List<Integer> diffWaysToCompute(String str) {
        boolean isNumeric = true;
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-' || ch=='*')
            {
                isNumeric = false;
                String left = str.substring(0,i);
                String right = str.substring(i+1,str.length());

                List<Integer> leftAns = diffWaysToCompute(left);
                List<Integer> rightAns = diffWaysToCompute(right);

                for(int j=0;j<leftAns.size();j++)
                {
                    for(int k=0;k<rightAns.size();k++)
                    {
                        output.add(perform(leftAns.get(j),rightAns.get(k),ch));
                    }
                }
            }
        }

        if(isNumeric)
        {
            output.add(Integer.parseInt(str));
        }

        return output;
    }


    public static int perform(int a,int b, char c)
    {
        if(c == '+')
        {
            return a+b;
        }
        else if(c == '*')
        {
            return a*b;
        }
        else if(c == '-')
        {
            return a-b;
        }
        return 0;
    }
}
