/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

Constraints:
    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].
 */

import java.util.ArrayList;
import java.util.List;

public class Backtracking05_LetterCombinationsOfPhoneNumber {

final static char[][] L = {{},{},{'a','b','c'},{'d','e','f'},
                            {'g','h','i'},{'j','k','l'},{'m','n','o'},
                            {'p','q','r','s'},{'t','u','v'}, {'w','x','y','z'}};

    public static List<String> letterCombination(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0 ) {
            return ans;
        }

        combination(0, digits.length(), new StringBuilder(""), digits, ans);
        return ans;
    }

    public static void combination(int idx, int n, StringBuilder sb, String digits, List<String> ans) { //TC -> O(4^n)
        if(idx == n) {
            // System.out.println(sb.toString());
            ans.add(sb.toString());
            return;
        }

        char[] letters = L[Character.getNumericValue(digits.charAt(idx))];
        for(int i = 0; i  < letters.length; i++) {
            combination(idx+1, n, sb.append(letters[i]), digits, ans);  //recursive call
            sb.deleteCharAt(sb.length()-1); //backtracking strep
        }
    }


    public static void main(String[] args) {
        String digits = "922";
        System.out.println(letterCombination(digits));
    }
} 