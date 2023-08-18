import java.util.LinkedList;


public class Stack09_Palindrome {


    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.addLast('A');    
        ll.addLast('B');    
        ll.addLast('C');    
        ll.addLast('B');    
        ll.addLast('A');
        System.out.println(ll.getFirst());
    }
}
