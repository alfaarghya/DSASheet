import java.util.LinkedList;
import java.util.Queue;

public class BT03_KthLevelNodePrint {

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

    public static void printKLevelData(Node root, int level, int kLevel){    //TC -> O(n)
            //base case
        if(root == null){
            return;
        }
        
        if(level == kLevel){    //when our kLevel match with current level
            System.out.print(root.data+" ");    //print that data
            return;
        }

        printKLevelData(root.left, level+1, kLevel);     //left side of current root >> level will increase
        printKLevelData(root.right, level+1, kLevel);    //right side of current root >> level will increase
    }

    public static void printKLevelData(Node root, int kLevel){  //TC -> O(n)    /*-- to understand this code check levelOrderTraversal code from "DS implementation\DS06_BinaryTree.java" */
            //when Tree is empty
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>(); 

        q.add(root);
        q.add(null);
        int currentLevel = 1;   //currentLevel track the current level ini a tree 

        while(!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                    currentLevel++; //whenever adding a "null" increase level
                }
            }
            else{
                if(currentLevel == kLevel){ //if currentLevel match with Kth level print the data
                    System.out.print(currentNode.data+" ");
                }

                if(currentNode.left != null){//if node's left side is not empty add left side value to queue
                    q.add(currentNode.left); 
                }

                if(currentNode.right != null){//if node's right side is not empty add right side value to queue
                    q.add(currentNode.right);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 3;

        printKLevelData(root, k);
        // printKLevelData(root, 1, k);

    }
}
