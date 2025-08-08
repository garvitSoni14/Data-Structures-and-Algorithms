//BRUTEFORCE: Create a new matrix and in its columns set the values of rows of given matrix. TC: O(n*m), SC: O(n*m).
//OPTIMAL APPROACH: Set columns into rows by swapping and then reverse all the elements inside each rows (inplace).
package Array;

public class Rotate_Matrix_90 {
    public static void main(String [] args){
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int rotated[][] = rotate_BRUTEFORCE(arr);
        for(int i=0;i<rotated.length;i++){
            for(int j = 0; j< rotated[0].length;j++){
                System.out.println(rotated[i][j]+"\r");
            }
            System.out.println("");
        }
    }

    public static void rotate(int arr[][]){
        for(int i=0;i< arr.length; i++){
            for(int j=i; j<arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr[0].length/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-1-j];
                arr[i][arr.length-1-j] = temp;
            }
        }
    }
// TC: O(2(n*m))
// SC: O(1)

    public static int [][] rotate_BRUTEFORCE(int arr[][]){
        int n= arr.length;
        int m=arr[0].length;
        int result[][] = new int [m][n];
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                result[j][n-i-1] = arr[i][j];
            }
        }
        return result;
    }
}
