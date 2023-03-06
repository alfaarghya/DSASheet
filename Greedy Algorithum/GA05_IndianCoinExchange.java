import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GA05_IndianCoinExchange {

    public static int exchange(int amount){ //TC -> O(n log(n))
        int[] IndianCoinSystem = {1,2,5,10,20,50,100,500,200,2000};
            //step 1 -> sort the Currency
        Arrays.sort(IndianCoinSystem);
        int countCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>(); //to store which currency used

            // step 2 -> run a loop in reverse order and find out which value need
        for(int i = IndianCoinSystem.length - 1; i >= 0; i--){
            if(amount >= IndianCoinSystem[i]){
                while(amount >= IndianCoinSystem[i]){
                    countCoins++;
                    ans.add(IndianCoinSystem[i]);
                    amount = amount - IndianCoinSystem[i];
                }
            }
            if(amount == 0){
                break;
            }
        }

        System.out.print("Coin or cash used >> ");
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();

        return countCoins;
    }

    public static void main(String[] args) {
        int amount1 = 590;

        System.out.println("-----------------------------------------------");
        System.out.println("Minimum currency used >> "+exchange(amount1));
        System.out.println("-----------------------------------------------");
    }
}
