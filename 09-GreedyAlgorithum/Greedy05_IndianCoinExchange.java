/*
we are given an infinite supply of denomination[1,2,5,10,20,50,100,500,2000]. find min no of coins notes to make change for a value V.
 */

import java.util.ArrayList;
import java.util.List;

public class Greedy05_IndianCoinExchange {
    static int[] coin = {1,2,5,10,20,50,100,200,500,2000};
    public static List<Integer> coinExchangeIndia(int amount) {
        int coinCount = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i = coin.length-1; i >= 0; i--) {
            // if(amount >= coin[i]) {
                while(amount >= coin[i]) {
                    coinCount++;
                    ans.add(coin[i]);
                    amount -= coin[i];
                }
            // }
        }

        return ans;
    } 

    public static void main(String[] args) {
        System.out.println(coinExchangeIndia(118));
        
    }
}
