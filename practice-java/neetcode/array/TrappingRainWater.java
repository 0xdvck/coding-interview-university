class Solution {
    public int trap(int[] height) {
        //Time complexity: O(n)
        //Space complexity: O(1)
        int l = 0;
        int r = height.length - 1;
        int maxLeftHeight = 0;
        int maxRightHeight = 0;
        int totalHeight = 0;

        while (l < r) {
            if (height[l] <= height[r]) {

                maxLeftHeight = Math.max(height[l], maxLeftHeight);
                totalHeight += maxLeftHeight - height[l];
                l++;
            } else {
                maxRightHeight = Math.max(height[r], maxRightHeight);
                totalHeight += maxRightHeight - height[r];
                r--;
            }
        }

        return totalHeight;
    }
}