// Approach: Binary Search on Rows + Binary Search on One Row
// Time Complexity: O(log m + log n)
// Space Complexity: O(1)

class Solution {
    boolean searchInRow(int[][] mat, int target, int row) {
        int n = mat[0].length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == mat[row][mid]) {
                return true;
            } else if (target > mat[row][mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int startRow = 0;
        int endRow = m - 1;

        while (startRow <= endRow) {
            int midRow = startRow + (endRow - startRow) / 2;

            if (target >= mat[midRow][0] && target <= mat[midRow][n - 1]) {
                return searchInRow(mat, target, midRow);
            } else if (target > mat[midRow][n - 1]) {
                startRow = midRow + 1;
            } else {
                endRow = midRow - 1;
            }
        }

        return false;
    }
}

/*
Why this method?

Matrix ki har row sorted hai, aur ek row ka last element
next row ke first element se chhota hai. Is property ki wajah se
hum Binary Search ko do levels mein use kar sakte hain.

Step 1: Row find karna
    Pehle rows par Binary Search karte hain.
    midRow ki first aur last value check karke decide karte hain
    ki target is row mein ho sakta hai ya nahi.

    Agar target > current row ka last element:
        Neeche wali rows mein search karo.

    Agar target < current row ka first element:
        Upar wali rows mein search karo.

    Agar target first aur last value ke beech hai:
        Target isi row mein ho sakta hai.

Step 2: Row ke andar search
    Ab selected row par normal Binary Search lagate hain.

Example:
[1  3  5  7]
[10 11 16 20]
[23 30 34 60]

Target = 16

Pehle rows mein Binary Search se second row select hogi,
kyunki 16, 10 aur 20 ke beech hai.

Phir second row mein Binary Search:
10 -> 11 -> 16
Target mil gaya.

Yaad rakhne ka simple way:
"First find the row, then find the element."

Hum normal linear search ki jagah Binary Search use kar rahe hain,
isliye time O(m + n) ke bajay O(log m + log n) ho jata hai.
*/