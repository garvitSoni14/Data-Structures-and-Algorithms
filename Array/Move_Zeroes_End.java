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


    public static void  moveZeroesToEnd(int arr[])
 {
     int i = 0;
     for(; i<arr.length; i++)
     {
         if(arr[i]==0)
         {
             break;
         }
     }
     for(int j=i+1;j<arr.length;j++)
     {
         if (arr[j] != 0)
         {
             arr[i] = arr[j];
             arr[j]=0;
             i++;
         }
     }
 }
}
