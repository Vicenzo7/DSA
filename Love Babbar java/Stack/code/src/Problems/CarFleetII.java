package Problems;

import java.util.Arrays;
import java.util.Stack;

public class CarFleetII {
    public static double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] time = new double[n];
        Arrays.fill(time,-1.0);
        Stack<Integer> stack = new Stack<>();

        //traverse from behind
        for(int i = n-1;i>=0;i--){
            int curPos = cars[i][0];
            int curSpeed = cars[i][1];

            while(!stack.isEmpty()){
                int topIndex = stack.peek();
                int topPos = cars[topIndex][0];
                int topSpeed = cars[topIndex][1];

                if(curSpeed <= topSpeed){ // cannot catch other car
                    stack.pop();
                    continue;
                }
                double collisionTime = (double)(topPos - curPos)/(curSpeed - topSpeed);

                // if a collision time of c1 car is < than collision time of c2 car or its -1 means c1 car will not collide c2
                //or c2 car will collide first so we go to next car
                if(collisionTime < time[topIndex] || time[topIndex] == -1)
                {
                    time[i] = collisionTime;
                    break;
                }
                stack.pop(); // pop from stack
            }

            stack.push(i); //push the stack index of car
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] cars = {{3,4},{5,4},{6,3},{9,1}};
        System.out.println(Arrays.toString(getCollisionTimes(cars)));
    }
}
