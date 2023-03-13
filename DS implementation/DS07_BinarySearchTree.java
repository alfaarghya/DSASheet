    /*---- Node Creation ----*/
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
            /*---- ----*/

class BinarySearchTree{
            /*---- Build a Binary Search Tree ----*/
    public Node buildBST_fromPreOrderData(int[] arr){   //when root node in first position
        Node root = null;   //create a root node for tree
        for(int i = 0; i < arr.length; i++){    //run a loop and store the value in tree
            root = insert(root, arr[i]);    //this function will help to insert nodes in sorted order
        }
        return root;    //return the root for future use
    }
    public Node buildBST_fromPostOrderData(int[] arr){  //when root node in last position
        Node root = null;   //create a root node for tree
        for(int i = arr.length-1; i >= 0; i--){     ////run a loop and store the value in tree
            root = insert(root, arr[i]);    //this function will help to insert nodes in sorted order
        }
        return root;    //return the root for future use
    }

    public Node insert(Node root, int value){
            //base case
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(value < root.data){  //when value is smaller than current root's data
            root.left = insert(root.left, value);   //store the data in left side
        }
        else{   //when value is greater than current root's data 
            root.right = insert(root.right, value); //store it in right side
        }

        return root;
    }
                        /*---- ----*/
        /*---- In-Order Traversal ----*/
    public void inOrderTraversal(Node root){
            //base case
        if(root == null){
            return; 
        }

        inOrderTraversal(root.left);    //check left side of current root
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);   //check right side of current root
    }
                /*---- ----*/

    public boolean searchNode(Node root, int key){
            //base case
        if(root == null){   
            return false;   //when we unable to find out the key and reach to the null node
        }

        if(key == root.data){   //when we found the key
            return true;
        }

        if(key < root.data){    //when key is smaller than root
            return searchNode(root.left, key); //check for key in left side of current root
        }
        else {   //when key is larger than root
            return searchNode(root.right, key);    //check for key in left side of current root
        }

    }
}

public class DS07_BinarySearchTree {
    public static void main(String[] args) {
        
        int[] bst_data1 = {5,1,3,4,2,7}; //pre order mode >> here root node is 5
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.buildBST_fromPreOrderData(bst_data1);
        System.out.println("------------------------------------");
        System.out.print("Whole Tree(InOrder) >> ");
        bst.inOrderTraversal(root);
        System.out.println("\n------------------------------------");
        int key = 7;
        System.out.println("Is "+key+" in the tree?(true/false)?");
        System.out.println(">> "+bst.searchNode(root, key));
        System.out.println("------------------------------------");

    }
}
