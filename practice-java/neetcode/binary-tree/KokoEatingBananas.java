class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //https://leetcode.com/problems/koko-eating-bananas/submissions/1354952787/
        // Time Complexity: O(logr)
        // Space Complexity: O(1)
        long r = 1000000000;
        long l = 1;
        while (l <= r) {
            long k = l + (r - l) / 2;
            long total = 0;
            for (int i = 0; i < piles.length; i++) {
                total += piles[i] / k;
                if (piles[i] % k > 0)
                    total++;
            }
            if (total <= h) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return (int) l;
    }
}