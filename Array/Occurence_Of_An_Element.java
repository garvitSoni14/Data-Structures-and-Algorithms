package Array;

import java.util.Scanner;

public class Occurence_Of_An_Element
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
        System.out.print("Enter the element whose occurence you want to get: ");
        int target = scanner.nextInt();
        System.out.println("The occurence of "+target+" is : "+occurenceOfAnElement(arr,target));
    }

    public static int occurenceOfAnElement(int arr[], int targetElement)
    {
        int occur=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == targetElement)
            {
                occur+=1;
            }
        }
        return occur;
    }
}
