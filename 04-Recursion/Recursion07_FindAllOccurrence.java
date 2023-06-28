/*
find all occurrence of key value in array
 */

import java.util.ArrayList;
public class Recursion07_FindAllOccurrence {

    public static ArrayList<Integer> findAllOccurrence(int[] arr, int key, int index, ArrayList<Integer> list) {
        if(index == arr.length) {
            return list;
        }

        if(arr[index] == key) {
            list.add(index);
            return findAllOccurrence(arr, key, index+1, list);
        }
        
        return findAllOccurrence(arr, key, index+1, list);

    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,11,1,1,11,1,1};
        int key = 1;
        System.out.println(findAllOccurrence(arr, key, 0, new ArrayList<>()));
    }
}
