/*
 Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
 */

public class String15_ReverseWordsInAStringIII { // TC -> O(n) || SC -> O(n)

    public static String reverseWords(String s) {
        int n = s.length();
        int frontPT = 0, rarePT = 0;
        StringBuilder ans = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            // if current char is a space OR if it is last character....start reversing
            if (s.charAt(i) == ' ' || i == n - 1) {
                // if current character is a space then store i-1... else is it is last
                // character store i
                frontPT = i == n - 1 ? i : i - 1;

                // reverse a word
                while (rarePT <= frontPT) {
                    ans.append(s.charAt(frontPT));
                    frontPT--;
                }

                // add aspace after every word
                ans.append(" ");
                rarePT = i + 1;// re-initialize rare index.

            }
        }

        return ans.toString().trim(); // trim extra spaces.
    }

    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }
}
