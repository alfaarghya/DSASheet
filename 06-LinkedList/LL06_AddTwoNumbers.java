class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL06_AddTwoNumbers {
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            
            if(l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            temp.next = new Node(sum % 10);
            temp = temp.next;
            carry = sum/10;
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
        Node l1 = new Node(9);
        // l1.next = new Node(4);
        // l1.next.next = new Node(9);
        // l1.next.next.next = new Node(9);
        // l1.next.next.next.next = new Node(9);
        // l1.next.next.next.next.next = new Node(9);
        // l1.next.next.next.next.next.next = new Node(9);

        Node l2 = new Node(1);
        l2.next = new Node(9);
        l2.next.next = new Node(9);
        l2.next.next.next = new Node(9);
        l2.next.next.next.next = new Node(9);
        l2.next.next.next.next.next = new Node(9);
        l2.next.next.next.next.next.next = new Node(9);
        l2.next.next.next.next.next.next.next = new Node(9);
        l2.next.next.next.next.next.next.next.next = new Node(9);
        l2.next.next.next.next.next.next.next.next.next = new Node(9);
        // l2.next.next.next.next.next.next.next.next.next = new Node(9);

        Node ans = addTwoNumbers(l1, l2);
        printLL(ans);
        
    }
}
