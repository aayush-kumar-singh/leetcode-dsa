// Approach: Find Pivot + Swap + Reverse
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot exists, array is in descending order
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find the smallest bigger element from the right
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        // Step 3: Reverse the part after pivot
        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

/*
Why this method?

Next Permutation ka goal hai current arrangement ke just next
lexicographically greater arrangement ko find karna.

Example:
[1, 2, 3] -> [1, 3, 2]

Iske liye 3 steps follow karte hain:

1. Pivot find karo:
   Right se first aisa element find karo jahan nums[i] < nums[i + 1].
   Ye pivot hai.

   Example:
   [1, 2, 5, 4, 3]
        ^
      pivot = 2

2. Pivot se just bigger element find karo:
   Right se search karte hain aur pivot se bada element milte hi
   uske saath pivot ko swap kar dete hain.

   [1, 2, 5, 4, 3]
   pivot = 2
   bigger element = 3

   Swap:
   [1, 3, 5, 4, 2]

3. Pivot ke baad reverse karo:
   Pivot ke baad ka part descending order mein hota hai.
   Usko reverse karne se smallest possible greater permutation milti hai.

   [1, 3, 5, 4, 2]
            ↓ reverse
   [1, 3, 2, 4, 5]

Important:
Agar pivot nahi mila, iska matlab array completely descending order mein hai.
Ye already last permutation hai, toh simply reverse karke first permutation bana do.

Yaad rakhne ka simple way:
"Pivot find -> Bigger element swap -> Suffix reverse."

Extra array use nahi karte, isliye Space O(1) hai.
*/