class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BT02_KthLevelNode {

    public static void kthLevelNodes(Node root, int kthLv) {
        kthLevelNodes(root, 1, kthLv);
    }

    private static void kthLevelNodes(Node root, int currentLv, int kthLv) {
            //base case ->  current root is null
        if(root == null) {
            return;
        }

        if(currentLv == kthLv) {
            System.out.println(root.data+" ");
            return;
        }

        kthLevelNodes(root.left, currentLv+1, kthLv);
        kthLevelNodes(root.right, currentLv+1, kthLv);
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);
 
         int k = 3;

         kthLevelNodes(root,k);
    }
}
