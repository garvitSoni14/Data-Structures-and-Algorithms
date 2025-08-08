// v1_BRUTEFORCE: Calculate the nCr for the given coordinate. i.e. = n! / n! * (n-r)!. TC: O(n), SC: O(1).
// v1_OPTIMAL: Compute nCr iteratively using result *= (n - i) / (i + 1). TC: O(r), SC: O(1).
// v2_OPTIMAL: Generate entire row using optimized nCr for each index using res[i] = res[i-1] * (n - i + 1) / i. TC: O(n), SC: O(n).
// v3: Generate full Pascal's Triangle by building rows using v2(row). TC: O(n^2), SC: O(n^2)

package Array;

import java.util.Arrays;

public class Pascals_Triangle {

    public static void main(String [] args){
        System.out.println(v1(6,3));
        System.out.println(Arrays.toString(v2(6)));
        int arr[][] = v3(6);
        for(int[] i:arr){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static int[][] v3(int row){
        int[][] result = new int[row][];
        for(int i=1; i<=row; i++){
            int [] rowRes = v2(i);
            result[i-1] = rowRes;
        }
        return result;
    }


    public static int[] v2(int row){
        int result[] = new int [row];
        int ans=1;
        result[0]=1;
        for(int i=1; i<row; i++){
            ans*=(row-i);
            ans/=i;
            result[i] = ans;
        }
        return result;
    }



    public static int v1(int row, int col){
        row-=1;
        col-=1;
        int result = 1;
        for(int i=0;i<col;i++){
            result *= (row-i);
            result /= (i+1);
        }
        return result;
    }


    public static int factorial(int x){
        int fact = 1;
        for(int i=2; i<=x; i++){
            fact*=i;
        }
        return fact;
    }
    public static int v1_BRUTEFORCE(int rowNo, int colNo){
        int n = rowNo-1, r = colNo-1;
        return factorial(n) / ( factorial(r) * factorial(n-r) );
    }
}
