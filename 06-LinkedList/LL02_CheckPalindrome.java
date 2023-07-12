/*
Given the head of a singly linked list, return true if it is a
palindrome
or false otherwise.

 

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false

 

Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

 */


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL02_CheckPalindrome {

    public static boolean isPalindrome(Node head) { //TC -> O(n)
        //corner case
        if(head == null || head.next == null) { //LL is empty || LL have only one Node
            return true;
        }

            //Step1 -> find out Mid Node
        Node mid = findMid(head);

            //step2 -> reverse 2nd half
        Node tail = reverse(mid);

            //step3 -> check 1st half & 2nd half
        Node left = head, right = tail; 
        while(left != null && right != null) {
            if(left.data != right.data) {   //dose not match
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;    //all case pass....so it is a palindrome
    }
        /*Find Mid - slow-fast approach*/
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {  //even case && odd case
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;    //slow travels half of LL
    }
                /*---- ----*/
        /*---- Reverse LinkedList ----*/
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node nxt;

        while(curr != null) {
            //step1 -> next node of curr is nxt Node
            nxt = curr.next;
            //step2 -> curr Node point to prev Node
            curr.next = prev;
            //Step3 -> prev Node Becomes curr Node
            prev = curr;
            //step4 -> curr Node become nxt Node
            curr = nxt;
        }
        head = prev;
        return head;

    }
                /*---- ----*/

        
    public static void main(String[] args) {
            //odd case
        Node headOdd = new Node(1);
        headOdd.next = new Node(2);
        headOdd.next.next = new Node(3);
        headOdd.next.next.next = new Node(2);
        headOdd.next.next.next.next = new Node(1);
        
        //Even case
        Node headEven = new Node(1);
        headEven.next = new Node(2);
        headEven.next.next = new Node(3);
        headEven.next.next = new Node(3);
        headEven.next.next.next = new Node(2);
        headEven.next.next.next.next = new Node(1);

        System.out.println(isPalindrome(headEven));
    }
}
