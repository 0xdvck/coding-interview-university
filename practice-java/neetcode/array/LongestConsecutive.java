import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Map.Entry<Integer, Integer>> mp = new HashMap<>();
        HashMap<Integer, Boolean> bl = new HashMap<>();
        int mx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (bl.containsKey(nums[i]))
                continue;
            bl.put(nums[i], true);

            int l = nums[i];
            int r = nums[i];
            if (mp.containsKey(l - 1)) {
                l = mp.get(l - 1).getKey();
            }

            if (mp.containsKey(r + 1)) {
                r = mp.get(r + 1).getValue();
            }

            mp.put(l, Map.entry(l, r));
            mp.put(r, Map.entry(l, r));
            mx = Math.max(mx, r - l + 1);
        }

        return mx;
    }
}
