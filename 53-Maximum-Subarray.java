// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int val : nums) {
            currSum += val;
            maxSum = Math.max(currSum, maxSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}

/*
Why this method?

Yahan hum Kadane's Algorithm use karte hain.
Har element ko current sum mein add karte hain aur check karte hain
ki ab tak ka maximum sum kya hai.

Agar currSum negative ho jata hai, toh usse carry karne ka koi fayda nahi,
kyunki negative sum future subarray ka total kam karega.
Isliye currSum ko 0 se reset kar dete hain.

Is tarah array ko sirf ek baar traverse karke maximum subarray sum mil jata hai.
*/