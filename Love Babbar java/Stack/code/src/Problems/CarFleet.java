package Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        //storing in map car position and its respective speed
        for(int i=0;i<length;i++){
            map.put(position[i],speed[i]);
        }

        //to store time
        Stack<Double> stack = new Stack<>();
        //sorting position
        Arrays.sort(position);

        //calculating time required by the nearest car to reach target
        double time = (double) (target-position[length-1])/map.get(position[length-1]);

        stack.push(time);

        //recursively calculate time for each car starting from second last car
        for(int i = length-2;i>=0;i--)
        {
            Double top = stack.pop();
            Double cur_time = (double) (target-position[i])/map.get(position[i]);

            // if car 2 time to reach target is less then there's a car fleet
            //as car2 will reach target faster but it cannot reach so it will be behind the car so we store only one
            if(top >= cur_time){
                stack.push(top);
            }else{
                stack.push(top);
                stack.push(cur_time);
            }
        }
        return stack.size();
    }


    public  static int carFleet2(int target, int[] position, int[] speed) {
        int res = 0;
        double[] timeArr = new double[target];
        for (int i = 0; i < position.length; i++)
        {
            timeArr[position[i]]= (double)(target - position[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target-1; i >=0 ; i--)
        {
            double cur = timeArr[i];
            if (cur > prev)
            {
                prev = cur;
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3}, speed = {2,4,1,1,3};
        System.out.println(carFleet(target,position,speed));
        System.out.println(carFleet2(target,position,speed));
    }
}
