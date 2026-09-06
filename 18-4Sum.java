// Approach: Sorting + Two Pointers
// Time Complexity: O(n³)
// Space Complexity: O(1) excluding output

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int p = j + 1;
                int q = n - 1;

                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));

                        p++;
                        q--;

                        while (p < q && nums[p] == nums[p - 1]) {
                            p++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}

/*
Why this method?

4Sum mein humein 4 numbers find karne hain jinka sum target ke equal ho.

3Sum ki tarah yahan bhi pehle array ko sort karte hain.
Uske baad pehle 2 numbers ko fix karte hain:
    i -> first number
    j -> second number

Baaki 2 numbers ke liye Two Pointer use karte hain:
    p -> left side se
    q -> right side se

Agar sum target se chhota hai:
    p++ because humein sum badhana hai.

Agar sum target se bada hai:
    q-- because humein sum kam karna hai.

Agar sum target ke equal hai:
    Valid quadruplet mil gaya, answer mein add karte hain.
    Phir p++ aur q-- karte hain.

Duplicate answers avoid karne ke liye i, j aur p ke duplicate
elements ko skip karte hain.

long sum isliye use kiya hai kyunki 4 integers ka sum int ki
range cross kar sakta hai.

Yaad rakhne ka simple way:
"Sort -> i fix -> j fix -> p & q Two Pointers -> duplicate skip."

3Sum mein 1 number fix + Two Pointers = O(n²).
4Sum mein 2 numbers fix + Two Pointers = O(n³).
*/