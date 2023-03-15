import java.util.ArrayList;
public class BST03_ValidBST {
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

                /*---- check the tree for it's validation ----*/
    public static boolean isBSTValid(Node root, Node min, Node max){    //TC -> O(n)
            //base case
        if(root == null){
            return true;    //if our BST dose not exist thats mean our BST is valid
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return isBSTValid(root.left, min, root) && isBSTValid(root.right, root, max);
    
    }
                                /*---- ----*/

    public static void main(String[] args) {
        /*
                        8
                       / \
                      5   10
                     / \   \
                    3  6   11
                   / \      \
                  1   4     14
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);  //change it's value and recheck........greater than 8
        root.left.left.right = new Node(4);
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);  //change it's value and recheck........ less than 8

        System.out.print("Original BST >> ");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("is BST valid?(true/false) \n>> "+isBSTValid(root, null, null));
    }
}
