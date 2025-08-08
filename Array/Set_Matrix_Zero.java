//BRUTEFORCE: Traverse complete matrix using two loops(nested) and at each 0-valued coordinate convert that complete row,column as zero. TC: O((n*m)*(n*m), SC:O(1).
//BETTER APPROACH: Create two arrays row[n], col[m], traverse complete matrix using two loops(nested), for every row and column mark 1 in the row and column arrays. then at last, convert all rows with row[i]==1, and all columns with col[i] = 1 as 0. TC: O(2(m*n)), SC: O(n+m).
//OPTIMAL APPROACH: Run a nested loop and check for the col and row coordinates for "0", then set those  first row and columns of matrix itself as 0 then excluding first row and first column, change other row and colmns  as zero for "0" coordinates. then at last is required set first row, column also 0.
package Array;

public class Set_Matrix_Zero {


    public static void main(String[] args){
        int arr[][] = {{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        setMatrix_BETTER(arr,4,4);
        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr[i][j]+"\r");
                System.out.println();
            }

        }
    }

    public static void setMatrix(int arr[][], int n, int m){
        boolean row0 = false;
        boolean col0 = false;
        for (int j = 0; j < m; j++) {
            if (arr[0][j] == 0) row0 = true;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) col0 = true;
        }
        for(int i=1; i<n;i++){
            for(int j=1; j<m; j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m; j++){
                    if(arr[i][0] ==0 || arr[0][j]==0){
                        arr[i][j] = 0;
                    }
            }
        }
        if(row0){
            for(int j=0; j<m;j++)arr[0][j]=0;
        }
        if(col0){
            for(int i=0; i<n;i++)arr[i][0]=0;
        }
    }
// TC: O(2(m+n+m*n))
// SC: O(1)

    public static void setMatrix_BETTER(int arr[][], int n, int m ){
        int row[] = new int[n];
        int col[] = new int [m];
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(arr[i][j] == 0){
                    row[i] =1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(row[i]==1 || col[j]==1){
                    arr[i][j] = 0;
                }
            }
        }

    }



   public static void setMatrix_BRUTEFORCE(int arr[][], int n, int m){
       for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               if(arr[i][j] == 0){
                   markRow(arr,n,m,j);
                   markCol(arr, n,m, i);
               }
           }
       }
       for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               if(arr[i][j] == -1){
                   arr[i][j] = 0;
               }
           }
       }
   }

   public static void markRow(int arr[][], int n, int m, int column){
       for(int j = 0; j<m; j++ ){
           arr[column][j] = -1;
       }
   }
    public static void markCol(int arr[][], int n, int m, int row){
        for(int i = 0; i<m; i++ ){
            arr[i][row] = -1;
        }
    }
}
