/*

Sample Input 1
: S = "abcab"
Sample Output 1
: 7
There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca, bcab, c, ca, cab, a, ab, b
Out of the above substrings, there are 7 substrings : a, abca, b, bcab, c, a and b.
So, only 7 contiguous substrings start and end with the same character.
 */

public class Recursion08_contiguousSubStr {

    public static int countContiguousSubStr(String str, int si, int ei, int n) {
            //base case
        if(n == 1) {
            return 1;
        }
        if(n <= 0) {
            return 0;
        }

        int count = countContiguousSubStr(str, si+1, ei, n-1) + countContiguousSubStr(str, si, ei-1, n-1) - countContiguousSubStr(str, si+1, ei-1, n-2);

        if(str.charAt(si) == str.charAt(ei)) {
            count++;
        }

        return count;

    }

    public static void main(String[] args) {
        String str = "abcab";
        System.out.println(countContiguousSubStr(str, 0, str.length()-1, str.length()));
    }
}
