class Solution {
    public int[] twoSum(int[] numbers, int target) {
    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    //Time Complexity: O(n), Omega(logn)
    //Space Complexity: O(1)
    int left = 0;
    int right = numbers.length - 1;
    
    while (left < right) {
        int sum = numbers[left] + numbers[right];

        if (sum == target) {
            return new int[] {left + 1, right + 1};
        }

        int mid = left + (right - left) / 2;

        if (sum < target) {
            if (numbers[mid] + numbers[right] < target) {
                left = mid;
            } else {
                ++left;
            }
        } else {
            if (numbers[mid] + numbers[left] > target) {
                right = mid;
            } else {
                --right;
            }
        }
    }
    
    // If no solution is found
        return new int[] {};
    }
}