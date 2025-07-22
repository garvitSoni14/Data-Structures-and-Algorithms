//BRUTEFORCE: Use two nested loops, calculate the largest differnece between current element and purchaseprice, return. TC: O(n^2), SC: O(1)
// OPTIMAL APPROACH: Use one loop, store the min till current element as purchase price, store the max difference of(arr[i]-minPurchasePrice) in maxProfit, then return the maxProfit.
package Array;

public class Stock_Buy_and_Sell {
    public static void main(String[] args){
        int [] sample = {7,1,5,3,6,4};
        System.out.println(profit(sample));
    }

    public static int profit(int[] arr){
        int maxProfit=0;
        int minPurchasePrice=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            minPurchasePrice = Math.min(minPurchasePrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i]-minPurchasePrice);
        }
        return maxProfit;
    }
// TC: O(n)
// SC: O(1)

    public static int profit_BRUTEFORCE(int [] arr){
        int maxProfit = 0;
        for(int i=0; i<arr.length;i++){
            for(int j = i+1; j< arr.length;j++){
                if(arr[j]>arr[i]){
                    maxProfit = Math.max(maxProfit, arr[j]-arr[i]);
                }
            }
        }
    return maxProfit;
    }
}
