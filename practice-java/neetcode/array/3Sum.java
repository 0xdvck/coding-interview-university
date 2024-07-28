import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // https://leetcode.com/problems/3sum/
        // Time Complexity: O(nlogn + (n^2 + n)/2)
        // Space Complexity: O(1)
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int k = i;
            int l = k + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[k] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[k], nums[l], nums[r]));
                    l++;
                    r--;

                } else if (sum > 0)
                    r--;
                else if (sum < 0)
                    l++;

                while (l < r && r < nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                }
            }
        }

        return res;
    }
}