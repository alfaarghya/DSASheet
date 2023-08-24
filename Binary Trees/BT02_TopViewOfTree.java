import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class BT02_TopViewOfTree {

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

    static class Info{
        Node node;
        int horDist;

        Info(Node node, int horDist){
            this.node = node;
            this.horDist = horDist;
        }
    }

    public static void topView(Node root){
            //step 1 -> level order Traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();   //to store top view(value) with horizontal distance(key)

        int min = 0, max = 0;

        q.add(new Info(root, 0)); //by default horDist for root is always 0
        q.add(null);

        while(!q.isEmpty()){
            Info currInfo = q.remove();
            if(currInfo == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(currInfo.horDist)){ //check for key already exist in map or not
                    map.put(currInfo.horDist, currInfo.node);   //if key is not exits put that key with value
                }
    
                if(currInfo.node.left != null){ //checks left node exist or not
                    q.add(new Info(currInfo.node.left, currInfo.horDist-1));    //if left node exist add the value in queue
                    min = Math.min(min, currInfo.horDist-1);    //store the minimum horizontal distance
                }
    
                if(currInfo.node.right != null){    //checks right node exist or not
                    q.add(new Info(currInfo.node.right, currInfo.horDist+1));   //if right node exist add the value in queue
                    max = Math.max(currInfo.horDist+1, max);    //store the maximum horizontal distance
                }
            }

        }

        for(int i = min; i <= max; i++){    //run a loop from  min to max to get every value
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                 /\  / \
                4 5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        /*
                        1
                       / \
                      2   3
                       \
                        4
                         \
                          5
                         / \
                        6   7
                       /
                      8
                    /
                   9
         */
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(4);
        root1.left.right.right = new Node(5);
        root1.left.right.right.left = new Node(6);
        root1.left.right.right.right = new Node(7);
        root1.left.right.right.left.left = new Node(8);
        root1.left.right.right.left.left.left = new Node(9);

        topView(root1);
    }
}
