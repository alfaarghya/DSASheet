public class BT01_SubtreeOfTree{

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

    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
            //step 1 -> check for root = sub root
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
            //step 2 -> check for subRoot in left side of main tree then check right side of main tree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

        //some reason for identical or non-identical
    public static boolean isIdentical(Node root, Node subRoot){
            //base case
        if(root == null && subRoot == null){
            return true;
        }   //some reason for non-identical
        else if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }

        if(!isIdentical(root.left, subRoot.left)){  //tree's left side and subTree's left side are not same
            return false;
        }
        if(!isIdentical(root.right, subRoot.right)){    //tree's right side and subTree's right side are not same
            return false;
        }

        return true;    //if all upper non-identical logic fail then tree and subtree are identical
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
        root.right.left =  new Node(6);
        root.right.right = new Node(7);
        
        /*
                    2
                   / \
                  4   5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));

    }
}
