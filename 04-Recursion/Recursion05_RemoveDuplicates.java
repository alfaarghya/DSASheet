/*
remove duplicate character from the string
 */

public class Recursion05_RemoveDuplicates { //TC -> O(n) || SC -> O(n)

    public static void removeDuplicates(String str, int index, StringBuilder sb, boolean[] aTOz) {
        if(index == str.length()) { //base case
            System.out.println(sb);
            return;
        }

            //logic
        if(aTOz[str.charAt(index) - 'a']) { //found duplicate element
            removeDuplicates(str, index+1, sb, aTOz);
            return;
        } else {    //no duplicate element
            aTOz[str.charAt(index) - 'a'] = true;
            sb.append(str.charAt(index));
            removeDuplicates(str, index+1, sb, aTOz);
        }
        
    }



    public static void main(String[] args) {
        String str = "arrghyyaa";
        StringBuilder sb = new StringBuilder("");
        boolean[] aTOz = new boolean[26];
        removeDuplicates(str, 0, sb, aTOz);
    }
}
