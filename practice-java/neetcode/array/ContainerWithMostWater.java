import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        int l = 0;
        int r = height.length - 1;
        int area = 0;

        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            area = Math.max(area, (r - l) * minHeight);

            while (l < r && height[l] <= minHeight)
                l++;
            while (l < r && height[r] <= minHeight)
                r--;
        }

        return area;
    }
}
