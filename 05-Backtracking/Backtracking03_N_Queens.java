/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]

Constraints:

    1 <= n <= 9
 */

import java.util.ArrayList;
import java.util.List;

public class Backtracking03_N_Queens {
   static int countWays = 0;   //to count how many possible ways are there to place Queens
    public static List<List<String>> solveNQueens(int n) {  //TC -> O(n!)
        List<List<String>> allSolution = new ArrayList<>();

        char[][] board = new char[n][n];    //chess board
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j]= '.';
            }
        }

        nQueens(allSolution, board, 0, n);
        return allSolution;
    }

    public static void nQueens (List<List<String>> allSolution, char[][] singleBoard, int row, int n) {
            //base case
        if(n == row) {
            allSolution.add(construct(singleBoard));
            countWays++;    //increasing ways
            return;
        }
            //logic
        for(int col = 0; col < n; col++) {
            if(isSafe(singleBoard, row, col)) {
                singleBoard[row][col] = 'Q';
                nQueens(allSolution, singleBoard, row+1, n);    //recursive call
                singleBoard[row][col] = '.';    //backtracking step
            }
        }

    } 

    public static boolean isSafe (char[][] singleBoard, int row, int col) {
            //vertical up
        for(int i = row-1; i >= 0; i--) {
            if(singleBoard[i][col] == 'Q')  return false;
        }
            //vertical up-left
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(singleBoard[i][j] == 'Q')  return false;
        }
            //vertical up-right
        for(int i = row-1, j = col+1; i >= 0 && j < singleBoard.length; i--, j++) {
            if(singleBoard[i][j] == 'Q')  return false;
        }

        return true;

    }

    public static List<String> construct(char[][] board) {
         List<String> res = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    } 

    
    /*public static void printBoard(char[][] board) {
        System.out.println("------- Chess board -------");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }*/
    
    public static void main(String[] args) {

        int n = 5;
        System.out.println(solveNQueens(n));
        System.out.println(countWays);
        
    }
}
