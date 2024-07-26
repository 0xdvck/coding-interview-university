import java.util.*;

class Solution {
    public int[] ProductOfArrayExceptSelf(int[] nums) {
        //Time complexity: O(n + n + n)
        //Space complexity: O(n + n + n)
        int[] answer = new int[nums.length];

        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];
        int product = 1;
        lefts[0] = 1;
        for(int i = 1; i < nums.length; i++){
            product *= nums[i-1];
            lefts[i] = product;
        }

        product = 1;
        rights[rights.length - 1] = 1;

        for(int i = rights.length - 2; i >= 0; i--){
            product *= nums[i+1];
            rights[i] = product;
        }

        for(int i = 0; i < nums.length; i++){
            answer[i] = lefts[i]*rights[i];
        }
        return answer;
    }
}