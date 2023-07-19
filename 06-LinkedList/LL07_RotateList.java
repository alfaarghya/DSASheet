/*
Given the head of a linked list, rotate the list to the right by k places.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */

 class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL07_RotateList {

    public static Node rotateRight(Node head, int k) {  //TC -> O(n) || Sc -> O(1)
        if(head == null || head.next == null) {
            return head;
        }

        int size = 1;
        Node tail = head;

            //finding tail Node and the size of LL
        while(tail.next != null) {
            size++;
            tail = tail.next;
        }
        
        Node newTail = head;
        int rotatePoint = size - (k % size); //find out rotate point
        for(int i = 1; i < rotatePoint; i++) {
            newTail = newTail.next; //find out new tail node
        }

        //connect all nodes
        tail.next = head;
        head = newTail.next;
        newTail.next = null;

        return head;
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
        // head.next.next.next.next.next = new Node(6);

        int k = 3;

        printLL(rotateRight(head, k));
    }
}
