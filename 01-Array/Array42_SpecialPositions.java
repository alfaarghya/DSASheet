/*
Given an m x n binary matrix mat, return the number of special positions in mat.A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

Example 1:
Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.

Example 2:
Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.
 */

public class Array42_SpecialPositions {

    public static int numSpecial(int[][] mat) { // TC -> O(n^2) || SC -> O(1)
        int specials = 0;

        for (int i = 0; i < mat.length; i++) {
            // check the column for 1 or duplicate 1
            int j = checkCol(mat, i);// ==> -1 --> no value or duplicate 1 || value --> col index of 1

            // check row of that column
            if (j != -1 && checkRow(mat, i, j)) {
                specials++;
            }
        }

        return specials;
    }

    public static int checkCol(int[][] mat, int i) {
        int idx = -1;
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[i][j] == 1) {
                if (idx == -1) { // assign the value
                    idx = j;
                } else { // duplicate value
                    return -1;
                }
            }
        }
        return idx;
    }

    public static boolean checkRow(int[][] mat, int rowNo, int j) {
        for (int i = 0; i < mat.length; i++) {
            // search for duplicate 1 in row
            if (mat[i][j] == 1 && i != rowNo) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat1 = { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
        int[][] mat2 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

        System.out.println(numSpecial(mat2));
    }
}
