import java.util.ArrayList;

public class BST02_RootToLeafPath {

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

                /*---- print paths from root to every leaf ----*/
    public static void rootToLeafPaths(Node root, ArrayList<Integer> path){ //TC -> O(n)
            //base case
        if(root == null){
            return;
        }

        path.add(root.data);    //first add current root data to the ArrayList

        if(root.left == null && root.right == null){    //whenever found the leaf node print the path from root to leaf
            printPath(path);
        }

        rootToLeafPaths(root.left, path);   //search for leaf node at left side of current root
        rootToLeafPaths(root.right, path);  //Search for leaf node at right side of current root

        path.remove(path.size()-1); //when ever we return from leaf node remove the node value from the arraylist
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i)+"-> ");
        }
        System.out.print("null");
        System.out.println();
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
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(4);
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);

        System.out.print("Original BST >> ");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Paths :");
        rootToLeafPaths(root, new ArrayList<>());

    }
}
