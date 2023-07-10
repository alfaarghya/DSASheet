
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL01_RemoveNthNodeFromEnd {
    static int size;    //track the size of LL
    public static int length(Node head) {   //length of the LL
        Node temp = head;
        
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

        /*---- Remove a Node from last ----*/
    public static Node removeNthNode(Node head, int N) {    //TC -> O(n) | SC-> O(1) 
        length(head);

        if(N > size | N <= 0) {
            System.out.println("value of N is out of the bound...can't delete any Node");
            return head;
        }
        if(N == size) { //try to delete head
            head = head.next;
            return head;
        }

        int i = 1;
        Node prev = head;
        while(i < size-N) { //have to go previous Node of delete Node
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next; //connect the prev Node with delete's next node
        return head;
    }
                    /*---- ----*/

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
        Node head = new Node(11);
        head.next = new Node(22);
        head.next.next = new Node(33);
        head.next.next.next = new Node(44);
        head.next.next.next.next = new Node(55);

        printLL(head);
        head = removeNthNode(head, -5);
        printLL(head);
    }
}
