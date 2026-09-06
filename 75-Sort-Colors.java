// Approach 1: Counting
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution1 {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int idx = 0;

        for (int i = 0; i < count0; i++) {
            nums[idx] = 0;
            idx++;
        }

        for (int i = 0; i < count1; i++) {
            nums[idx] = 1;
            idx++;
        }

        for (int i = 0; i < count2; i++) {
            nums[idx] = 2;
            idx++;
        }
    }
}

/*
Why this method?

Pehle 0, 1 aur 2 ko count karte hain.
Phir unke count ke according array ko dobara fill kar dete hain.
*/


// Approach 2: Dutch National Flag
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution2 {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}

/*
Why this method?

Yahan Dutch National Flag Algorithm use kiya hai.
low  -> 0 ko left mein rakhta hai.
mid  -> current element check karta hai.
high -> 2 ko right mein rakhta hai.

0 mile toh low ke saath swap,
1 mile toh mid aage,
2 mile toh high ke saath swap.

Isse array ek hi traversal mein sort ho jata hai.
*/