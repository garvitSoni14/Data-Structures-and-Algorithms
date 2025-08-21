package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Shop_In_Candy_Store {

    public static void main(String [] args)
    {
        int [] sample = {3,2,1,4};
        int k = 2;
        System.out.println(minMaxCandy(sample, k));
    }

    public static ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        Arrays.sort(prices);
        int minPrice = 0, buy=0, free= prices.length-1;
        while(buy<=free){
            minPrice+=prices[buy];
            buy++;
            free-=k;
        }
        int maxPrice = 0;
        free=0;
        buy= prices.length-1;
        while(free<=buy){
            maxPrice+=prices[buy];
            buy--;
            free+=k;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(minPrice);
        result.add(maxPrice);
        return result;
    }
}

// TC: O(n log n) .....2n ..~.. n
// SC: O(n) .....worstcase
