import java.util.Queue;
import java.util.LinkedList;

public class Queue03_FirstNonRepeatingCharacter {

    public static void NonRepeatingChar(String str){
            //step 1 -> create a array to store frequency for each and every character
        int[] freq = new int[26];
            //step 2 -> create a Queue
        Queue<Character> qu = new LinkedList<Character>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
                //step 3 -> add a data to queue
            qu.add(ch);
                //step 4 -> increase frequency for the character
            freq[ch - 'a']++;
                //step 5 -> when character appear in queue multiple time remove that character until found a character of frequency 1
            while(!qu.isEmpty() && freq[qu.peek()-'a'] > 1){
                qu.remove();
            }
                //step 5 -> print the out put
            if(qu.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(qu.peek()+" ");
            }

        }
    }

    public static void main(String[] args) {
        String str1 = "abccdaeba";
        String str2 = "abbacdce";
        String str3 = "aabccxb";

        NonRepeatingChar(str3);
    }
}
