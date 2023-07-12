class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL03_LLCycle {

    public static boolean isCycle(Node head) {
            //corner case
        if(head == null || head.next == null) { //empty LL || only one Node
            return false;
        }
            //step1 -> slow, fast Node
        Node slow = head, fast = head;
            //step2 -> run loop
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //step3 -> when slow & fast node match
            if(slow == fast) {  
                return true;
            }
        }

        return false;//no cycle
    }

    public static void removeCycle(Node head) {
        boolean flag = false;
        Node slow = head, fast = head;
            //step1 -> is cycle?
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) { //cycle
                flag =  true;
                break;
            }
        }


        if(flag == false) {
            return; //no cycle
        }

            //step2 -> find out last node
        slow = head;
        while(slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
            //step3 -> last node point to null
        fast.next = null;
        printLL(head);

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
        head.next.next.next.next = head.next.next;

        removeCycle(head);
    }
}
