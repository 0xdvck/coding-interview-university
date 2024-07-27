class Solution {
    public boolean isPalindrome(String s) {
        // https: // leetcode.com/problems/valid-palindrome/
        // Two pointers
        // Time complexity: O(n)
        // Space complexity: O(1)
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}