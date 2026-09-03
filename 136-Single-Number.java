// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int singleNumber(int[] nums) {
        int xr = 0;
        for (int num : nums) {
            xr = xr ^ num;
        }
        return xr;
    }
}