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

    /*----- Approach 1 -> check the tree for it's validation -----*/
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

    public static boolean isBSTValid(Node root, ArrayList<Integer> list){   //TC -> O(n) SC -> O(n  )
        inOrderTraversal(root, list);   //call this to get the sorted from of BSt

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){    //when current data is greater than it's next data
                return false;   //......that's means it is not a valid BST
            }
        }

        return true;    //if loop end that's mean BST is valid
    }
    /*-------- --------*/
        /*----Approach 2 -> check the tree for it's validation ----*/
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

    public static void printArrayList(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
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
        root.left.left.left = new Node(1);  //for Approach 2 -> change it's value and recheck........greater than 8
        root.left.left.right = new Node(4);//for Approach 1 -> change it's value less than it's previous value
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.right = new Node(11);//for Approach 1 -> change it's value greater than it's next value
        root.right.right.right = new Node(14);  //for Approach 2 -> change it's value and recheck........ less than 8

        ArrayList<Integer> list = new ArrayList<>();

            //Approach 1
        /*boolean ans = isBSTValid(root, list);
        System.out.print("Original BST >> ");
        printArrayList(list);
        System.out.println();
        System.out.println("is BST valid?(true/false) \n>> "+ans);*/

            //Approach 2
        System.out.print("Original BST >> ");
        inOrderTraversal(root, list);
        printArrayList(list);
        System.out.println();
        System.out.println("is BST valid?(true/false) \n>> "+isBSTValid(root, null, null));
    }
}
