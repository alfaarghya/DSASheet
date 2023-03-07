import java.util.*;

public class GA07_ChocolaProblem {

    public static int minCost(Integer[] costVer, Integer[] costHor){
            // sort the Array
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0, hp = 1, vp = 1; 
        int minCost = 0;

        while(h < costHor.length && v < costVer.length){
            if(costVer[v] <= costHor[h]){   //horizontal cut
                minCost += costHor[h]*vp;
                hp++;
                h++;
            }
            else{   //vertical cut
                minCost += costVer[v]*hp;
                vp++;
                v++;
            }
        }

            //rest of the cuts
        while(h < costHor.length){
            minCost += costHor[h]*vp;
            hp++;
            h++;
        }

        while(v < costVer.length){
            minCost += costVer[v]*hp;
            vp++;
            v++;
        }

        return minCost;
    }

    public static void main(String[] args) {
        //6X4 chocolate
        Integer[] costVer = {2,1,3,1,4};
        Integer[] costHor = {4,1,2};

        System.out.println("minimum cost of cut >> "+minCost(costVer, costHor));
    }
}
