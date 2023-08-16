import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Queue04_InterLeaveEvenLength {

    public static List<Integer> InterLeave(int arr[]) { //TC -> O(n)
        int n = arr.length;

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

            //store 1st half of array into queue
        for(int i = 0; i < n/2; i++) {
            q.add(arr[i]);
        }

            //interleave 2 halves of array
        for(int i = n/2; i < n; i++ ) {
            if(!q.isEmpty()) {
                ans.add(q.remove());
            }
            ans.add(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(InterLeave(arr));
    }
}
