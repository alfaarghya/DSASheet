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

                /*---- Search For a key ----*/
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
                        /*---- ----*/

    public Node deleteNode(Node root, int deleteData){
        if(root.data < deleteData){ //current root's data is smaller than value 
            root.right = deleteNode(root.right, deleteData);    //go to the right side of current root
        }
        else if(root.data > deleteData){    //current root's data is greater than value
            root.left = deleteNode(root.left, deleteData);  //go to the left side of current root
        }
        else{   //when we found the node to delete

                //case 1 -> delete the leaf node
            if(root.left == null && root.right == null){    //current node's left and right both are null that's mean it is leaf node
                return null;    //by this line....now leaf node's parent node point to the null instate of leaf
            }

                //case 2 -> delete a node which have single child
            if(root.left == null){  //when current root node dose not have a child in left side
                return root.right;  //by this line...... current root node's parent point to the current root node's right child instate of current root
            }
            else if(root.right == null){  //when current root node dose not have a child in right side
                return root.left;  //by this line...... current root node's parent point to the current root node's right child instate of current root
            }

                //case 3 -> delete a node which have both child
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;    //replace current root's data by InOrder Successor
            root.right = deleteNode(root.right, IS.data);   //now delete the IS data from current tree....because we just replace current root by IS but the IS node is still in this tree
        }
        return root;
    }

    private Node findInOrderSuccessor(Node root){
        while(root.left != null){   //find until currents root's left side point to the null
            root = root.left;
        }
        return root;    //return that current root
    }

}

public class DS07_BinarySearchTree {
    public static void main(String[] args) {
        
        int[] bst_data1 = {8, 5, 3, 1, 4, 6, 10, 11, 14}; //pre order mode >> here root node is 5
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
        int deleteData = 10;
        try{
            bst.deleteNode(root, deleteData);
            System.out.print("Delete "+deleteData+" from the tree >> ");
            bst.inOrderTraversal(root);
        }
        catch(Exception e){
            System.out.print(deleteData+" is not in the tree.!");
        }
        System.out.println("\n------------------------------------");

    }
}
