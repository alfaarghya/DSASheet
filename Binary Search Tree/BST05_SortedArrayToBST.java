public class BST05_SortedArrayToBST {

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

                /*---- sorted Array to balanced BST----*/
    public static Node array2BST(int[] arr, int startIndex, int endIndex){  //TC -> O(n)
            //base case
        if(startIndex > endIndex){
            return null;
        }
            //step 1 -> find out midIndex of array
        int midIndex = (startIndex+endIndex) / 2;
            //step 2 -> make current midIndex as root
        Node root = new Node(arr[midIndex]);    
            //step 3 -> now connect left side and right side to current root
        root.left = array2BST(arr, startIndex, midIndex-1);
        root.right = array2BST(arr, midIndex+1, endIndex);

        return root;
    }
                            /*---- ----*/

    public static void main(String[] args) {

        int[] arr = {3,5,6,8,10,11,12}; /*--- expected output ---> 8
                                                                  / \
                                                                 5   11
                                                                / \  / \
                                                               3  6 10 12  */

        Node root = array2BST(arr, 0, arr.length-1);
        inOrderTraversal(root); //if our BST print in sorted manner... thats mean code is write
    }
}
