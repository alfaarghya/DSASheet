import java.util.LinkedList;

import StackWithLinkedList.Node;

public class Stack09_Palindrome {

    public static boolean isPalindrome(LinkedList<Character> ll) {
        Node head = ll.getFirst();   
    }

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
