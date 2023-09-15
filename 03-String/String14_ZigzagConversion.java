/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
public class String14_ZigzagConversion {

    public static String convert(String s, int numRow) { // TC -> O(n) || TC -> O(n)
        if (numRow == 1)
            return s;

        StringBuilder ans = new StringBuilder("");
        int n = s.length();
        int diff = (numRow - 1) * 2;// diff of elements in first st and last row

        // run a loop and get zig-zag string
        int idx = 0;
        int diagonalDiff = 0;
        int diagonalIdx = 0;
        for (int i = 0; i < numRow; i++) {
            idx = i;

            while (idx < n) {
                ans.append(s.charAt(idx)); // every row's first element

                if (i != 0 && i != numRow - 1) { // first and last row will skip this
                    diagonalDiff = diff - (2 * i); // diff - (2 elements * row number)
                    diagonalIdx = idx + diagonalDiff; // getting current index for string

                    if (diagonalIdx < n) {
                        ans.append(s.charAt(diagonalIdx));
                    }
                }
                idx += diff;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int row = 5;
        System.out.println(convert(s1, row));
    }
}