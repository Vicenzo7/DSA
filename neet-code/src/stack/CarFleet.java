package stack;

public class CarFleet {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));
    }

//    public static int carFleet(int target, int[] position, int[] speed) {
//        // TC = O(n.log(n))  SC = O(n)
//        // Required map and stack to solve this
//
//        Stack<Double> timeStack = new Stack<>();
//        Map<Integer, Integer> positionToSpeedMap = new HashMap<>();
//        for (int i = 0; i < position.length; i++) {
//            positionToSpeedMap.put(position[i], speed[i]);
//        }
//
//        // sorting the position array
//        Arrays.sort(position);
//        for (int i = position.length - 1; i >= 0; i--) {
//
//            int positionSpot = position[i];
//            Integer speeds = positionToSpeedMap.get(positionSpot);
//            double timeTaken = (double) (target - positionSpot) / speeds;
//            if (!timeStack.isEmpty() && timeStack.peek() >= timeTaken) {
//                continue;
//            } else {
//                timeStack.push(timeTaken);
//            }
//        }
//        return timeStack.size();
//    }

    public static int carFleet(int target, int[] position, int[] speed) {
        // TC = O(target)  SC = O(target+1)
        double[] timeArray = new double[target + 1];
        double max = 0;

        for (int i = 0; i < position.length; i++) {
            timeArray[position[i]] = (double) (target - position[i]) / speed[i];
        }

        // traverse the time array in reverse order;
        int fleet = 0;
        for (int i = target; i >= 0; i--) {

            if (timeArray[i] > max) {
                fleet++;
                max = timeArray[i];
            }
        }

        return fleet;
    }
}