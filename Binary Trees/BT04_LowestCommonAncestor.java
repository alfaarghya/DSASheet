import java.util.ArrayList;

public class BT04_LowestCommonAncestor {
    /*--- Node Creation ----*/
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data =data;
            this.left = null;
            this.right = null;
        }
    }
        /*---- ----*/

                    /*-------- Approach 1 --------*/
    public static int LowestCommonAncestor(Node root, int n1, int n2){
            //when tree is empty
        if(root == null){
            System.out.println("Empty Tree");
            return Integer.MIN_VALUE;
        }
            //store the path for n1 & n2
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        

            //from this we get the paths for n1 & n2
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for(;i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){   //current i point uncommon ancestor
                break;
            }
        }

        return path1.get(i-1).data; //i-1 will point to that node where we found common ancestor
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
            //base case
        if(root == null){
            return false;
        }

        path.add(root); //add current root at path
            
        if(root.data == n){ //when current root's data match with n
            return true;
        }

        boolean leftFound = getPath(root.left, n, path);    //found path left side for current root
        boolean rightFound = getPath(root.right, n, path);  //found path right side for current root

        if(leftFound || rightFound){    //left side and right side both or any one return true
            return true;
        }

        path.remove(path.size()-1); //when left and right side both return false.....simply remove that node.....because after that node we don't have n value
        return false;
    }
                            /*---- ----*/

    public static void main(String[] args) {
        /*
                        1
                       / \
                      2   3
                     / \
                    4   5
                   / \   \
                  6   7   8
                 /       / \
                9      10   11
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(6);
        root.left.left.left.left = new Node(9);
        root.left.left.right = new Node(7);
        root.left.right = new Node(5);
        root.left.right.right = new Node(8);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        int n1 = 9, n2 = 11;

        System.out.println(LowestCommonAncestor(root, n1, n2));
    }
}
