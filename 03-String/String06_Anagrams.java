/*
Determine if 2 Strings are anagrams of each other.
What are anagrams?
If two strings contain the same characters but in a different order, they can be said to be anagrams. Consider race and care. In this case, race's characters can be formed into a study, or care's characters can be formed into race. Below is a java program to check if two strings are anagrams or not.
 */

public class String06_Anagrams {

    public static boolean isAnagrams(String str1, String str2) {
        if(str1.length() == str2.length()) {
            for(int i = 0; i < str1.length(); i++) {
                char ch = str1.charAt(i);
                int j = 0;
                while(j < str2.length() && ch != str2.charAt(j)) {
                        j++;
                }
                if(j < str2.length()) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str1 = "asdfghjklmnbvcxzqwertyuiop", str2 = "qwertyuiollkjhgfdsazxcvbnm";

        System.out.println(isAnagrams(str1, str2));
    }
}
