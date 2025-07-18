// BRUTE FORCE: Traverse the array and store all its non zero elements into a new array and return new array. TC:O(n), SC: O(n)
// OPTIMAL APPROACH: Use two pointers (i,j) initially pointing to first element, if j!=0 and i and j are not pointing to same element, swap them.
package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Move_Zeroes_End
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i=0; i<size;i++)
        {
            System.out.println("Enter the element at "+ i + " : ");
            arr[i] = scanner.nextInt();
        }
        moveZeroesToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void moveZeroesToEnd(int [] arr){
        int i=0; int j=0;
        while(j<arr.length){
            if(arr[j]!=0) {
                if(i!=j){
                    System.out.println("Swapped " + arr[i]+" with "+ arr[j]);
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j] = temp;
                }
                i++;
            }
            j++;
        }
    }
}
// TC: O(n)
// SC: O(1)
