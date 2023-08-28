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

    public static void sumTree(Node root) {
        transformToSumTree(root);
        preOrderTraversal(root);
    }

    public static int transformToSumTree(Node root) {
            //base case
        if(root == null) {
            return 0;
        }

        int leftSide = transformToSumTree(root.left); //calculate the left side sum of current root
        int rightSide = transformToSumTree(root.right); //calculate the right side sum of current root

        int currData = root.data;   //store current root's data

                //condition for leaf node
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftSide + newRight + rightSide;  //new left node data + sum of all left side data + new right node data + sum of all right side data

        return currData;
    }
    public static void preOrderTraversal(Node root){   //TC -> O(n)
            //base case -> when current root is null
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);   //left side of a root
        preOrderTraversal(root.right);  //right side of a root
    }

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

        preOrderTraversal(root);

        System.out.println();

        sumTree(root);

    }
}
