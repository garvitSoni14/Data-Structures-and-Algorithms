// BRUTEFORCE: For each subarray, calculate product of all elements and update maximum. TC: O(n^3), SC: O(1).
// BETTER APPROACH: For each starting index, calculate cumulative product till the end and update maximum. TC: O(n^2), SC: O(1).
// OPTIMAL APPROACH: Traverse from both ends keeping prefix and suffix product, reset when zero, track max product.

package Array;

public class Max_Product_Subarray {
    public static void main(String [] args){
//        int []sample ={2,3,-2,4};
        int []sample ={-2,0,-1};
        System.out.println(maxProductSubarray(sample));
    }

    public static int maxProductSubarray(int arr[]){
        int prefix=1, suffix=1;
        int result = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=arr[i];
            suffix*=arr[arr.length-i-1];
            result = Math.max(result, Math.max(prefix, suffix));
        }
        return result;
    }
// TC: O(n)
// SC: O(1)

    public static int maxProductSubarray_BETTER(int [] arr){
        int result = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int prod = 1;
            for(int j=i; j<arr.length; j++){
                prod*=arr[j];
                result = Math.max(result, prod);
            }
        }
        return result;
    }

    public static int maxProductSubarray_BRUTEFORCE(int [] arr){
        int res = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int prod = 1;
                for(int k=i; k<=j; k++){
                    prod *= arr[k];
                }
                res = Math.max(res, prod);
            }
        }
        return res;
    }
}
