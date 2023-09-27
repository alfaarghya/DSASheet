
/*
You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
Given an integer k, return the kth letter (1-indexed) in the decoded string.

 

Example 1:
Input: s = "leet2code3", k = 10
Output: "o"
Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".

Example 2:
Input: s = "ha22", k = 5
Output: "h"
Explanation: The decoded string is "hahahaha".
The 5th letter is "h".

Example 3:
Input: s = "a2345678999999999999999", k = 1
Output: "a"
Explanation: The decoded string is "a" repeated 8301530446056247680 times.
The 1st letter is "a".
 

Constraints:

2 <= s.length <= 100
s consists of lowercase English letters and digits 2 through 9.
s starts with a letter.
1 <= k <= 109
It is guaranteed that k is less than or equal to the length of the decoded string.
The decoded string is guaranteed to have less than 263 letters.
 */
import java.util.Stack;

public class Stack11_DecodedStringAtIndex {

    public static String decodeAtIndex(String s, int k) { // TC -> O(n) || SC -> O(1)

        Stack<Long> stk = new Stack<>(); // Store length of decode string

        stk.push(0L); // no decoding start yet.... so length 0

        // Run a loop and calculate length
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) { // when digit is there.....
                stk.push(stk.peek() * (ch - '0')); // ...then multiply last length with current digit
            } else { // when it's a character ......
                stk.push(stk.peek() + 1); // .... then simple increase length by 1
            }

        }

        // get k'th character
        int idx = s.length() - 1; // store last index of string
        while (!stk.isEmpty()) {
            k %= stk.pop(); // adjust the k according to length & move to previous length

            if (k == 0 && Character.isLetter(s.charAt(idx))) { // when k is 0 && current character is a letter not a
                                                               // digit
                return String.valueOf(s.charAt(idx)); // .... then found k'th character
            }

            idx--; // decrease index by 1
        }

        return ""; // k'th character does not exist

    }

    public static void main(String[] args) {
        String s1 = "leet2code3";
        String s2 = "ha22";
        String s3 = "a2345678999999999999999";

    }
}
