// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public double myPow(double x, int n) {
        long binForm = n;

        // Negative exponent ke liye x ko 1/x karte hain
        if (binForm < 0) {
            x = 1 / x;
            binForm = -binForm;
        }

        double ans = 1;

        while (binForm > 0) {
            // Exponent odd hai toh current x answer mein multiply hoga
            if (binForm % 2 == 1) {
                ans = ans * x;
            }

            // x ko square karte hain
            x = x * x;

            // Exponent ko half karte hain
            binForm = binForm / 2;
        }

        return ans;
    }
}

/*
Why this method?

Normally x^n calculate karne ke liye x ko n times multiply kar sakte hain,
but usme O(n) time lagega.

Yahan hum Binary Exponentiation use karte hain.
Har step mein exponent ko half karte hain aur x ko square karte hain.

Isliye n bahut bada hone par bhi sirf O(log n) steps lagte hain.
Negative n ke liye x ko 1/x kar dete hain because x^(-n) = 1/(x^n).
*/