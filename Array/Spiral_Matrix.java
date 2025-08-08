// BRUTEFORCE: Only approach is to traverse top row from (left->right), right column from (top->bottom), bottom row from (right->left), left column from (bottom->top) and increaseall 4 pointer to traverse next cycle until top<=bottom also left<=right.
package Array;

public class Spiral_Matrix {

    public static void main(String[] args) {

        //Matrix initialization.
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiral(mat);
    }

    public static void spiral(int arr [][]){
        int n = arr.length, m = arr[0].length;
        int top=0, bottom=n-1, right=m-1, left = 0;
        while(top<=bottom && left<=right){
            for (int i=left; i<=right;i++){
                System.out.println(arr[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++){
                System.out.println(arr[i][right]);
            }
            right--;
            for(int i=right; i>=left; i--){
                System.out.println(arr[bottom][i]);
            }
            bottom--;
            for(int i=bottom; i>=top; i--){
                System.out.println(arr[i][left]);
            }
            left++;
        }
    }
}

// TC: O(n*m)
// SC: O(1)