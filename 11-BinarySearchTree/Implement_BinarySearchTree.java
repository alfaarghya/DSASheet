import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;
    /*--------- Calling Function ---------*/
    BinarySearchTree(int[] dataSet) {
        root = buildBST(dataSet);
    }
    public void inOrderTraversal() {
        System.out.print("In-Order Traversal >> ");
        inOrderTraversal(root);
        System.out.println();
    }
    public void preOrderTraversal() {
        System.out.print("Pre-Order Traversal >> ");
        preOrderTraversal(root);
        System.out.println();
    }
    public void postOrderTraversal() {
        System.out.print("Post-Order Traversal >> ");
        postOrderTraversal(root);
        System.out.println();
    }
    public void levelOrderTraversal() {
        System.out.println("Level-Order Traversal >> ");
        levelOrderTraversal(root);
        System.out.println();
    }
    public void insert(int data) {
        insert(root, data);
    }
    public void search(int key) {
        System.out.println("is "+key+" avaible?(true/false)");
        System.out.println(">> "+search(root, key));
    }
            /*---------- --------- */


        /*---------- Woking Function ----------*/
    private Node buildBST(int[] dataSet) {
        System.out.println("1. 1st Element will be Root Node \n2. nth Element will be root Node");
        System.out.print("Press(1 or 2) >> ");
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        switch (n) {
            case 1:
                return buildBST_PreOrderRoot(dataSet);
        
            case 2:
                return buildBST_PostOrderRoot(dataSet);

            default:
                System.out.println("wrong choice");
                return null;
        }
    }
        /*---- creating BST from preorder dataset ----*/
    private Node buildBST_PreOrderRoot(int[] dataSet) {
        Node root = null;   //create a root node for tree
        for(int i = 0; i < dataSet.length; i++){    //run a loop and store the value in tree
            root = insert(root, dataSet[i]);    //this function will help to insert nodes in sorted order
        }
        return root;
    }
                /*---- ----*/    
    /*---- creating BST from postorder dataset ----*/
    private Node buildBST_PostOrderRoot(int[] dataSet) {
        Node root = null;   //create a root node for tree
        for(int i = dataSet.length-1; i >= 0; i--){     ////run a loop and store the value in tree
            root = insert(root, dataSet[i]);    //this function will help to insert nodes in sorted order
        }
        return root;
    }
                /*---- ----*/
        /*---- insert values into BST -----*/
    private Node insert(Node root, int value){
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
        /*---- In-order Traversal ----*/
    private void inOrderTraversal(Node root) {   //TC -> O(n)
            //base case -> root node reaches leaf node
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left); //left side of current root node
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);    //right side of current root node
    }
                /*---- ----*/
        /*---- Pre-order Traversal ----*/
    private void preOrderTraversal(Node root) {  //TC -> O(n)
            //base case --> root node reaches leaf node
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);    //left side of current root
        preOrderTraversal(root.right);   //right side of current root
    }
                /*---- ----*/
        /*---- Post-order Traversal ----*/
    private void  postOrderTraversal(Node root) {    //TC ->O(n)
            //base case -> root node reaches leaf node
        if(root == null) {
            return;
        }

        postOrderTraversal(root.left);   //left side of current root node
        postOrderTraversal(root.right);  //right side of current root node
        System.out.print(root.data+" ");
    }
                /*---- ----*/
        /*---- Level-Order Traversal ----*/
    private void levelOrderTraversal(Node root) {
            //binary tree is empty
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);//root node
        q.add(null); //here null refers to next line

        while(!q.isEmpty()) {
            Node currentNode = q.remove();

            if(currentNode == null) {   //new level
                System.out.println(); //adding a level
                if(q.isEmpty()) {   //when queue is empty stop the loop
                    break;
                } else {
                    q.add(null);
                }
            } else {    //print value
                System.out.print(currentNode.data+" ");

                if(currentNode.left != null) {//if node's left side is not empty add left side value to queue
                    q.add(currentNode.left);
                }
                if(currentNode.right != null) {//if node's right side is not empty add right side value to queue
                    q.add(currentNode.right);
                }
            }
        }

    }
                /*---- ----*/
        /*---- Search in BST ----*/
    private boolean search(Node root, int key) {
            //base case
        if(root == null) {
            return false;
        }

        if(key == root.data) {
            return true;
        }

        if(key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
                /*---- ----*/
            /*---------- ----------*/
}

public class Implement_BinarySearchTree {
    public static void main(String[] args) {
        int[] dataSet1= {8, 5, 3, 1, 4, 14, 10, 11, 6};
        BinarySearchTree bst = new BinarySearchTree(dataSet1);
        System.out.println("root >> " +bst.root.data);
        bst.inOrderTraversal();
        bst.preOrderTraversal();
        bst.postOrderTraversal();
        bst.levelOrderTraversal();
        
        bst.insert(9);
        bst.inOrderTraversal();
        bst.levelOrderTraversal();

        bst.search(7);

    }
}
