/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

The '.' character indicates empty cells.

 

Example 1:

Input: board = [["5","3",".",".","7",".",".",".","."],
                ["6",".",".","1","9","5",".",".","."],
                [".","9","8",".",".",".",".","6","."],
                ["8",".",".",".","6",".",".",".","3"],
                ["4",".",".","8",".","3",".",".","1"],
                ["7",".",".",".","2",".",".",".","6"],
                [".","6",".",".",".",".","2","8","."],
                [".",".",".","4","1","9",".",".","5"],
                [".",".",".",".","8",".",".","7","9"]]

Output: [["5","3","4","6","7","8","9","1","2"],
        ["6","7","2","1","9","5","3","4","8"],
        ["1","9","8","3","4","2","5","6","7"],
        ["8","5","9","7","6","1","4","2","3"],
        ["4","2","6","8","5","3","7","9","1"],
        ["7","1","3","9","2","4","8","5","6"],
        ["9","6","1","5","3","7","2","8","4"],
        ["2","8","7","4","1","9","6","3","5"],
        ["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


Constraints:

    board.length == 9
    board[i].length == 9
    board[i][j] is a digit or '.'.
    It is guaranteed that the input board has only one solution.
 */

public class Backtracking04_Sudoku {

   /*public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
            //Base case
        if(row == 9) {
            return true;
        }
            //logic
        int newRow = row, newCol = col+1;
        if(col+1 == 9) {
            newRow = row+1;
            newCol = 0;
        }
        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, newRow, newCol);
        }
        for(int digit = 1; digit <= 9; digit++) {
            if(isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, newRow, newCol))  {
                    return true;
                }
                sudoku[row][col] = 0;
                
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] sudoku,int row,int col,int digit) {
            //check column
        for(int i = 0; i <= 8; i++) {
            if(sudoku[i][col] == digit) return false;
        }

            //check row
        for(int i = 0; i <= 8; i++) {
            if(sudoku[row][i] == digit) return false;
        }

            //check grid
            int srow_grid = (row/3)*3, scol_grid = (col/3)*3;
            for(int i = srow_grid; i < srow_grid+3; i++) {
                for(int j = scol_grid; j < scol_grid+3; j++) {
                    if(sudoku[i][j] == digit) return false;
                }
            }

        return true;
    }
    public static void printSudoku(int sudoku[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }*/


    public static boolean sudokuSolver(char[][] sudoku, int row, int col) {
            //base case
        if(row == 9) {
            return true;
        }
            //logic
        int nxtRow = row, nxtCol = col+1;
        if(col+1 == 9) {
            nxtRow = row+1;
            nxtCol = 0;
        }

        if(sudoku[row][col] != '.') {
            return sudokuSolver(sudoku, row, col);
        }

        for(int digit = 1; digit <= 9; digit++) {
            if(isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = (char)(48+digit);
                if(sudokuSolver(sudoku, nxtRow, nxtCol)) {
                    return true;
                }
                sudoku[row][col] = '.';
            }
        } 

        return false;
    }

    public static boolean isSafe(char[][] sudoku, int row, int col, int digit) {
           //check column
        for(int i = 0; i <= 8; i++) {
            if(sudoku[i][col] == (char)(48+digit)) return false;
        }

            //check row
        for(int i = 0; i <= 8; i++) {
            if(sudoku[row][i] == (char)(48+digit)) return false;
        }

            //check grid
            int srow_grid = (row/3)*3, scol_grid = (col/3)*3;
            for(int i = srow_grid; i < srow_grid+3; i++) {
                for(int j = scol_grid; j < scol_grid+3; j++) {
                    if(sudoku[i][j] == (char)(48+digit)) return false;
                }
            }

        return true;
    }

    public static void printSudoku(char sudoku[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] sudoku = { {0,0,8,0,0,0,0,0,0},
        //                     {4,9,0,1,5,7,0,0,2},
        //                     {0,0,3,0,0,4,1,9,0},
        //                     {1,8,5,0,6,0,0,2,0},
        //                     {0,0,0,0,2,0,0,6,0},
        //                     {9,6,0,4,0,5,3,0,0},
        //                     {0,3,0,0,7,2,0,0,4},
        //                     {0,4,9,0,3,0,3,5,7},
        //                     {8,2,7,0,0,9,0,1,3} };

        // if(sudokuSolver(sudoku, 0, 0)) {
        // }
        // printSudoku(sudoku);

        char[][] sudoku = { {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'} };

        sudokuSolver(sudoku, 0, 0);
        printSudoku(sudoku);


    }
}
