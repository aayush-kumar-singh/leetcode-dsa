// Time Complexity: O(n²)
// Space Complexity: O(n²)
import java.util.*;
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();
        int repeated = 0;
        int actualSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                actualSum += num;

                if (set.contains(num)) {
                    repeated = num;
                }

                set.add(num);
            }
        }
        int expectedSum = (n * n) * (n * n + 1) / 2;
        int missing = expectedSum + repeated - actualSum;
        return new int[]{repeated, missing};
    }
}