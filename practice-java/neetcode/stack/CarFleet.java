import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //https://leetcode.com/problems/car-fleet/
        // Time complexity: O(n)
        // Space complexity: O(n) 
        
        Stack<Double> stack = new Stack<Double>();

        double[] time = new double[target];
        for (int i = 0; i < position.length; i++) {
            time[position[i]] = (double) (target - position[i]) / speed[i];
        }

        for (int i = time.length - 1; i >= 0; i--) {
            if (time[i] <= 0)
                continue;

            if (time[i] > 0) {
                if (stack.isEmpty() || time[i] > stack.peek()) {
                    stack.push(time[i]);
                }
            }
        }
        return stack.size();
    }

}
