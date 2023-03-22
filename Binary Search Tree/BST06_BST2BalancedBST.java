import java.util.ArrayList;

public class BST06_BST2BalancedBST {

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
    
        /**-------- Unbalanced BST to Balanced BST || TC -> O(n) --------**/
            /*---- In-Order Traversal ----*/
    public static void inOrderTraversal(Node root, ArrayList<Integer> list){
            //base case
        if(root == null){
            return; 
        }

        inOrderTraversal(root.left, list);    //check left side of current root
        // System.out.print(root.data+" ");
        list.add(root.data);
        inOrderTraversal(root.right, list);   //check right side of current root
    }
                    /*---- ----*/

                    /*---- balanced BST----*/
    public static Node array2BST(ArrayList<Integer> arr, int startIndex, int endIndex){  //TC -> O(n)
            //base case
        if(startIndex > endIndex){
            return null;
        }
            //step 1 -> find out midIndex of array
        int midIndex = (startIndex+endIndex) / 2;
            //step 2 -> make current midIndex as root
        Node root = new Node(arr.get(midIndex));    
            //step 3 -> now connect left side and right side to current root
        root.left = array2BST(arr, startIndex, midIndex-1);
        root.right = array2BST(arr, midIndex+1, endIndex);
    
        return root;
    }
                        /*---- ----*/
                    /**-------- --------**/

            /*---- Pre-order Traversal ----*/
    public static void preOrderTraversal(Node root){   //TC -> O(n)
            //base case -> when current root is null
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);   //left side of a root
        preOrderTraversal(root.right);  //right side of a root
    }
                    /*---- ----*/

    public static void main(String[] args) {
        /*
                    8
                   / \                                              8
                  6   10                                           / \
                 /     \        --- Expected output --->          5   11
                5       11                                      /  \  / \
               /         \                                     3   6 10  12
              3           12
         */

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        System.out.print("Original BST >> ");
        preOrderTraversal(root);
        System.out.println();

        ArrayList<Integer> arr = new ArrayList<>();
            //by this 2 line we make our BST balanced
        inOrderTraversal(root, arr);
        root = array2BST(arr, 0, arr.size()-1);

        System.out.print("Balanced BST >>");
        preOrderTraversal(root);    //to check if our BST is balanced or not
    }
}
