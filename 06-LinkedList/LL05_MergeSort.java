
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LL05_MergeSort {

        /*Find Mid - slow-fast approach*/
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {  //even case && odd case
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;    //slow travels half of LL
    }
                /*---- ----*/
    public static Node mergeSort(Node head) {
            //base case
        if(head == null || head.next == null) {
            return head;
        }
            //find the mid node
        Node mid = findMid(head);
            //divide into to LL
        Node rightHead = mid.next;  //right side
        mid.next = null;    //left side
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }
    public static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        } 
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
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
        Node headEven = new Node(11);
        headEven.next = new Node(2);
        headEven.next.next = new Node(8);
        headEven.next.next.next = new Node(5);
        headEven.next.next.next.next = new Node(1);
        headEven.next.next.next.next.next = new Node(3);
        printLL(headEven);
        Node temp = mergeSort(headEven);
        printLL(temp);


        Node headOdd = new Node(11);
        headOdd.next = new Node(2);
        headOdd.next.next = new Node(8);
        headOdd.next.next.next = new Node(5);
        headOdd.next.next.next.next = new Node(1);
        // headOdd.next.next.next.next.next = new Node(3);
        printLL(headOdd);
        Node temp1 = mergeSort(headOdd);
        printLL(temp1);

    }
}
