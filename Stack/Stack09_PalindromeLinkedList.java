/*
We shave a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
 */

// import java.util.*;
import java.util.Stack;
public class Stack09_PalindromeLinkedList {
        //Node creation
    static class Node{
        char data;
        Node next;
        Node(char data){
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head){
        Stack<Character> stk = new Stack<>();
        Node temp = head;
        while(temp != null){
            stk.push(temp.data);    //first store all data into stack
            temp = temp.next;
        }
        while(head != null){    //now check it
            if(head.data != stk.peek()){    //if found any head data don't match with stack's top data
                return false;
            }
            head = head.next;   //point to the next Node
            stk.pop();  //remove top data
        }
        return true;
    }

    public static void main(String[] args) {
        Node char1 = new Node('A');
        Node char2 = new Node('B');
        Node char3 = new Node('B');
        Node char4 = new Node('A');
        // Node char5 = new Node('A');
        char1.next = char2;
        char2.next = char3;
        char3.next = char4;
        // char4.next = char5;

        System.out.println(isPalindrome(char1));
    }
}
