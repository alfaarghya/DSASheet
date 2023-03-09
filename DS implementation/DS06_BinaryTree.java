import java.util.Queue;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    static int idx = -1;
    public Node buildTree(int[] nodes){ //TC -> O(n)
        idx++;  //increase index no.
            //base case -> when we have no node in left side or right side
        if(nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes); //store new node in left side until null comes
        newNode.right = buildTree(nodes);//store new node in right side until null comes

        return newNode; //return the root node
    }

    public void preOrderTraversal(Node root){   //TC -> O(n)
            //base case -> when current root is null
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrderTraversal(root.left);   //left side of a root
        preOrderTraversal(root.right);  //right side of a root
    }

    public void inOrderTraversal(Node root){    //TC -> O(n)
            //base case
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);    //left side of root
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);   //right side of root
    }

    public void postOrderTraversal(Node root){  //TC -> O(n)
            //base case
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);    //left side of root
        postOrderTraversal(root.right);   //right side of root
        System.out.print(root.data+" ");
    }

    public void levelOrderTraversal(Node root){ //TC -> O(n)
            //when our Binary Tree is empty
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();

            //step 1 -> the root node
        q.add(root);
        q.add(null);//this is for next line

            //step 2 -> run a loop until binary tree empty
        while(!q.isEmpty()){
                //step 3 -> remove the element from the queue
            Node currentNode = q.remove();
            if(currentNode == null){
                System.out.println();   //if it is null that's mean we have to provide a next line
                if(q.isEmpty()){    //when queue is empty stop the loop
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currentNode.data+" "); //when front of queue is not null print the value
                    //go to the left subtree
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                    //go to the left subtree
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
        }

    }

    public int heightOfTree(Node root){ //TC -> O(n)
            //base case
        if(root == null){
            return 0;
        }

        int lh = heightOfTree(root.left);   //give us left subtree height
        int rh = heightOfTree(root.right);  //give us right subtree height

        return Math.max(lh, rh)+1;
    }

    public int countOfNodes(Node root){ //TC -> O(n)
            //base case
        if(root == null){
            return 0;   
        }

        int lCount = countOfNodes(root.left);//left subtree nodes
        int rCount = countOfNodes(root.right);//right subtree nodes

        return lCount+rCount+1;
    }

    public int sumOfNodes(Node root){   //TC -> O(n)
            //base case
        if(root == null){
            return 0;
        }

        int lSum = sumOfNodes(root.left);  //sum of left subtree
        int rSum = sumOfNodes(root.right);  //sum of right subtree

        return lSum+rSum+root.data;
    }

    /* public int diameter(Node root){ //TC -> O(n^2)
            //base case
        if(root == null){
            return 0;
        }
        int lDiameter = diameter(root.left);    //left subtree diameter
        int rDiameter = diameter(root.right);   //right subtree diameter

        int lHeight = heightOfTree(root.left);  //left sub tree diameter
        int rHeight = heightOfTree(root.right); //right sub tree diameter

        int selfDiameter = lHeight + rHeight + 1;

        return Math.max(selfDiameter, Math.max(lDiameter,rDiameter));

    }*/

    static class Info{  //creating a class to store information of diameter & height to calculate Diameter of tree
        int diam;   //diameter
        int ht;      //height

        Info(int diam, int ht){ //constructor
            this.diam = diam;
            this.ht = ht;
        }
    }

    public Info diameter(Node root){    //TC -> O(n)
            //base case
        if(root == null){
            return new Info(0, 0);  //returning height = 0 and diameter = 0
        }

        Info lInfo = diameter(root.left);   //left side subtree Info
        Info rInfo = diameter(root.right); // right side subtree Info

        int diam = Math.max(lInfo.ht+rInfo.ht+1, Math.max(lInfo.diam, rInfo.diam)); 
        int height = Math.max(lInfo.ht, rInfo.ht)+1;

        return new Info(diam, height);
    }


}

public class DS06_BinaryTree {
    public static void main(String[] args) {
        int[] nodes = {1,2,4,7,-1,-1,-1,5,-1,8,11,-1,-1,-1,3,-1,6,9,-1,12,-1,-1,10,-1,-1};
/*
             1
           /   \
          2     3
         / \     \
        4   5     6
       /     \   / \ 
      7       8 9   10
             /   \
            11    12
 */
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        System.out.println("root of the tree -> "+root.data);
        System.out.println("------------------------------------------");
        System.out.print("whole tree(preorder format) -> ");
        bt.preOrderTraversal(root);
        System.out.println("\n------------------------------------------");
        System.out.print("whole tree(Inorder format) -> ");
        bt.inOrderTraversal(root);
        System.out.println("\n------------------------------------------");
        System.out.print("whole tree(postorder format) -> ");
        bt.postOrderTraversal(root);
        System.out.println("\n------------------------------------------");
        System.out.println("whole tree(Level order format):");
        bt.levelOrderTraversal(root);
        System.out.println("------------------------------------------");
        System.out.println("height(node) of the tree >> "+bt.heightOfTree(root));
        System.out.println("height(edge) of the tree >> "+(bt.heightOfTree(root)-1));
        System.out.println("------------------------------------------");
        System.out.println("Total number of Nodes in Tree >> "+ bt.countOfNodes(root));
        System.out.println("------------------------------------------");
        System.out.println("Total sum of Nodes in Tree >> "+ bt.sumOfNodes(root));
        System.out.println("------------------------------------------");
        System.out.println("Diameter of Tree >> "+ bt.diameter(root).diam);
        System.out.println("------------------------------------------");
    }
}
