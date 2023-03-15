public class BST04_MirrorBST {
        /*---- Node Creation */
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    /*--- ----*/
         /*---- In-Order Traversal ----*/
    public static void inOrderTraversal(Node root){
            //base case
        if(root == null){
            return; 
        }

        inOrderTraversal(root.left);    //check left side of current root
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);   //check right side of current root
    }
                /*---- ----*/

        /*---- Make a mirror image of BST----*/
    public static Node mirrorOfBST(Node root){
            //base case
        if(root == null){
            return null;
        }

        Node leftSide = mirrorOfBST(root.left); //store left side node of current root
        Node rightSide = mirrorOfBST(root.right);   //store right side node of current root

            //Swap both side
        root.left = rightSide;  //now current root's left is changed to rightSide
        root.right = leftSide;  //now current root's right is changed to leftSide

        return root;
    }
                    /*---- ----*/

    public static void main(String[] args) {
        /*
                Original BST
                        8                                               8
                       / \                                             / \
                      5   10                                         10   5
                     / \   \         --Expected Output-->>          /    / \
                    3  6   11                                     11    6   3
                   / \      \                                    /         / \
                  1   4     14                                  14        4   1
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);  
        root.left.left.right = new Node(4);
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);

        System.out.print("Original BST >> ");
        inOrderTraversal(root);
        System.out.println();

        System.out.print("Mirror of BST >> ");
        mirrorOfBST(root);
        inOrderTraversal(root);
        System.out.println();

        

    }
}
