public class BST01_PrintDataInRange{
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

    public static void printInRange(Node root, int lowerBound, int upperBound){ //TC -> O(n)
            //base case
        if(root == null){
            return;
        }
        
        if(lowerBound <= root.data && root.data <= upperBound){ //when root lies between lower bound and upper bound
            printInRange(root.left, lowerBound, upperBound);    //go to the left side of current root
            System.out.print(root.data+ " ");   //print current root's data
            printInRange(root.right, lowerBound, upperBound);   //go to the right side of current root
        }
        else if(root.data > upperBound){    //when upper bound is less than current root's data
            printInRange(root.left, lowerBound, upperBound);    //so we need to search in left side
        }
        else if(root.data < lowerBound){    //when lower bound is greater than current root's data
            printInRange(root.right, lowerBound, upperBound);   //so we need to search in right side
        }
    }

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

        System.out.print("Binary Tree >> ");
        inOrderTraversal(root);
        System.out.println();
        System.out.print("values in range >> ");
        printInRange(root, 5, 10);
        
    }
}
