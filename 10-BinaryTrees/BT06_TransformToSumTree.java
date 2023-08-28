/*--- Node Creation ----*/
    class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data =data;
            this.left = null;
            this.right = null;
        }
    }
        /*---- ----*/

public class BT06_TransformToSumTree {
    public static void main(String[] args) {
        /*
                        1
                      /  \
                     2    3
                   /   \   \
                  4     5   6
                /  \     \
               7    8     9
                   / \   / \
                 10  11 12  13
                / \
               14 15
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.left = new Node(4);
         root.left.left.left = new Node(7);
         root.left.left.right = new Node(8);
         root.left.left.right.left = new Node(10);
         root.left.left.right.left.left = new Node(14);
         root.left.left.right.left.right = new Node(15);
         root.left.left.right.right = new Node(11);
         root.left.right = new Node(5);
         root.left.right.right = new Node(9);
         root.left.right.right.left = new Node(12);
         root.left.right.right.right = new Node(13);
         root.right.right = new Node(6);
    }
}
