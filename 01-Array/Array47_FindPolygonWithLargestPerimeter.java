import java.util.Arrays;

public class Array47_FindPolygonWithLargestPerimeter {
    
    public static long largestPerimeter(int[] nums) {
        if(nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);

        long ans = -1;
        long prevSum = 0;

        for(int num: nums) {
            
            if(num < prevSum) {
                ans = num + prevSum;
            }

            prevSum += num;

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {5,5,5};
        int[] arr2 = {1,12,1,2,5,50,3};

        System.out.println(largestPerimeter(arr2));
    }
}
