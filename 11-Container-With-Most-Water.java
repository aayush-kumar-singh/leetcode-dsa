// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length - 1;
        int maxWater = 0;

        while (lp < rp) {
            int width = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int area = width * ht;
            maxWater = Math.max(maxWater, area);

            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater;
    }
}

/*
Why this method?

Yahan hum Two Pointer approach use karte hain.
Ek pointer left se aur ek right se start hota hai.

Har step mein width aur shorter height ko use karke area calculate karte hain.
Jo maximum area milta hai, usse maxWater mein store karte hain.

Hum hamesha shorter height wale pointer ko move karte hain,
kyunki area shorter height par depend karta hai.
Agar taller pointer ko move karenge, toh width kam hogi
aur height improve hone ki guarantee nahi hai.

Isliye dono pointers ko andar move karte hue maximum area efficiently find kar lete hain.
*/