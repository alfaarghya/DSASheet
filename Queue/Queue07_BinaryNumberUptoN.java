import java.util.Queue;
import java.util.LinkedList;

public class Queue07_BinaryNumberUptoN {

    /*---- use loops to get all the binary number from 1 to N ----*/
    public static void printBinary(int N){  //TC -> O(n^2), SC -> O(1)
        for(int n = 1; n <= N; n++){
            int number = n , i = 0, binary = 0;
            while(number > 0){
                int reminder = number%2;
                binary += reminder * Math.pow(10, i);
                number = number/2;
                i++;
            }
            System.out.print(binary+" ");
        }
    }

    /*---- use Queue to get all the binary number from 1 to N ----*/
    public static void generateBinary(int N){   //TC -> O(n), SC -> O(n)
        Queue<String> q = new LinkedList<>();
            //step 1 -> push 1 in Queue for integer 1
        q.add("1");
        while(N > 0){
                //step 2 -> remove the front of queue and store in a string1 
            String str1 = q.remove();
                //step 3 -> print the string1
            System.out.print(str1+" ");
                //step 4 -> store string1's value to string2
            String str2 = str1;
                //step 5 -> concatenate 0 and 1 with previously removed data
            q.add(str1 + "0");
            q.add(str2 + "1");
                //step 6 -> reduce N's value
            N--;
        }
    }

    public static void main(String[] args) {
        int number1 = 2;
        int number2  = 5;
        int number3 = 8;
        int number4 = 10;

        generateBinary(number4);
        
    }
}
