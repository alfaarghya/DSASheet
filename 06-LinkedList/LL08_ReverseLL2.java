/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
 
Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

 */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
} 
public class LL08_ReverseLL2 {

    public static Node reverseBetween(Node head, int left, int right) { //TC -> O(n)
            //empty or single node
        if(head == null || head.next == null) {
            return head;
        }
        
        Node dummy = new Node(-1);
        dummy.next = head;

            //find prev Node of left position
        Node prev = dummy;
        for(int i = 0; i < left-1; i++) {
            prev = prev.next;
        }
            
            //reverse between
        Node curr = prev.next;
        Node nxt;

        for(int i = left; i < right; i++) {
            nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
        }

        return dummy.next;
    }

    public static void printLL(Node head) { //print the LinkedList
        Node temp = head;

        while(temp != null) {
            System.out.print("|"+temp.data+"|->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        int left = 4, right = 7;

        printLL(reverseBetween(head, left, right));
        
    }
}
