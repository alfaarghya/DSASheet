import java.util.Arrays;

public class Greedy07_ChocolaProblem {

    public static int minCuttingCost(int[] horizontalCost, int[] verticalCost) {
    
        Arrays.sort(horizontalCost);
        Arrays.sort(verticalCost);

        int minCost = 0;
        int hIdx = horizontalCost.length-1, vIdx = verticalCost.length-1;
        int hPices = 1, vPices = 1;

        while(hIdx >= 0 && vIdx >= 0) {
            if(verticalCost[vIdx] <= horizontalCost[hIdx]) {    //horizontal cuts
                minCost += horizontalCost[hIdx] * vPices;
                hPices++;
                hIdx--;
            } else {    //vertical cut
                minCost += verticalCost[vIdx] * hPices;
                vPices++;
                vIdx--;
            }
        }

            //rest of the cuts
        while(hIdx >= 0) {
            minCost += horizontalCost[hIdx] * vPices;
            hPices++;
            hIdx--;
        }

        while(vIdx >= 0) {
            minCost += verticalCost[vIdx] * hPices;
            vPices++;
            vIdx--;
        }

        return minCost;

    }

    public static void main(String[] args) {
        int[] horizontalCost = {4,1,2};
        int[] verticalCost = {2,1,3,1,4};
        System.out.println(minCuttingCost(horizontalCost, verticalCost));
    }
}
