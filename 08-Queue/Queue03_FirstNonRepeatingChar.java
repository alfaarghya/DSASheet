import java.util.LinkedList;
import java.util.Queue;

public class Queue03_FirstNonRepeatingChar {

    public static String firstNonRepeatingChar(String str) {
        char[] freq = new char[26];
        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()) {
                return "Every char is repeating";
            }
        }
            return q.peek().toString();
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("abcabc"));
    }
}