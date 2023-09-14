/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;

public class Hash02_LongSubStr {

    public static int longestSubstring(String s) {
        // store substring
        HashSet<Character> subStr = new HashSet<>();

        int maxCount = 0; // count max size of a subString
        int removePoint = 0; // remove element from subStr

        // calculate Longest subStr size
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);// getting the key

            if (subStr.contains(key)) { // duplicate character is present
                while (s.charAt(removePoint) != key) { // remove from last removePoint
                    subStr.remove(s.charAt(removePoint++));
                }
                subStr.remove(s.charAt(removePoint++)); // remove old key
            } else { // duplicate key is not present
                maxCount = Math.max(maxCount, (i - removePoint + 1)); // calculate the length
            }

            subStr.add(key); // always add key

        }

        return maxCount;
    }

    public static void main(String[] args) {
        String str1 = "abcacbbca";
        String str2 = "dvdf";
        String str3 = "ckilbkd";
        String str4 = "tmmzuxt";
        String str5 = "bpfbhmix";

        System.out.println(longestSubstring(str1));

    }
}
