// Approach: Sorting + Two Pointers
// Time Complexity: O(n²)
// Space Complexity: O(1) excluding output

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }

        return ans;
    }
}

/*
Why this method?

3Sum mein humein 3 numbers find karne hain jinka sum 0 ho.

Brute force mein 3 nested loops laga sakte hain, but uski
Time Complexity O(n³) hogi.

Isliye pehle array ko sort karte hain.
Sorting ke baad hum Two Pointer technique use kar sakte hain.

Example:
[-1, 0, 1, 2, -1, -4]

Sorted:
[-4, -1, -1, 0, 1, 2]

Step 1:
i ko first number ke liye fix karte hain.

Step 2:
j = i + 1 se start hota hai.
k = last index se start hota hai.

Ab nums[i] + nums[j] + nums[k] check karte hain.

Agar sum < 0:
    Sum chhota hai, toh humein bigger value chahiye.
    Isliye j++.

Agar sum > 0:
    Sum bada hai, toh humein smaller value chahiye.
    Isliye k--.

Agar sum == 0:
    Humein valid triplet mil gaya.
    Answer mein add karte hain aur j++, k-- karte hain.

Duplicate triplets avoid karne ke liye:
1. i par duplicate value ko skip karte hain.
2. Valid triplet milne ke baad j ke duplicate values ko skip karte hain.

Important idea:
"Ek number fix karo + baaki 2 numbers Two Pointers se find karo."

Sorting ki wajah se pointers ko intelligently move kar sakte hain,
isliye O(n³) se improve hokar O(n²) ho jata hai.

Yaad rakhne ka simple way:
"Sort -> Fix i -> j left se -> k right se -> sum ke according pointer move."
*/