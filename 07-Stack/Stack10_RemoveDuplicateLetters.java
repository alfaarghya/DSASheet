/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is 
the smallest in lexicographical order
 among all possible results.

 

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

 */

import java.util.Stack;

public class Stack10_RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) { // TC -> O(n) || TC -> O(n)
        int[] indexes = new int[26];// store index of character
        boolean[] seen = new boolean[26]; // store last seen of characters
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder(""); // answer

        // track index no of every character
        for (int i = 0; i < s.length(); i++) {
            indexes[s.charAt(i) - 'a'] = i;
        }

        // remove duplicate character from stack
        for (int i = 0; i < s.length(); i++) {
            int chIdx = s.charAt(i) - 'a';

            if (!seen[chIdx]) {
                // stack is not empty && stack's top > character index && current idx <
                // indexes[stack's top]
                while (!stk.isEmpty() && stk.peek() > chIdx && i < indexes[stk.peek()]) {
                    seen[stk.pop()] = false; // remove from stack & make it unseen
                }

                stk.push(chIdx); // push current character's index
                seen[chIdx] = true; // make current character seen
            }

        }

        // store into string builder in lexicographical order
        while (!stk.isEmpty()) {
            sb.insert(0, (char) (stk.pop() + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "bcabc";
        String str2 = "cbaacdcbc";

        System.out.println(removeDuplicateLetters(str2));
    }
}
