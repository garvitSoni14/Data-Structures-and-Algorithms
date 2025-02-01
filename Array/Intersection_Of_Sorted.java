package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Intersection_Of_Sorted
{
    public static void main(String[] args)
    {
        int [] arr1 = {1,1,2,3,4,4,5,6};
        int [] arr2 = {4,5,5,6,7,8,9};
        System.out.println("The intersection of two arrays are : " + Arrays.toString(Intersection(arr1, arr2)));

    }


    public static int[] Intersection(int arr1[], int arr2[])
    {   int i =0, j=0;
        ArrayList<Integer> result = new ArrayList<>();
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i] == arr2[j])
            {
                if(result.isEmpty() || result.get(result.size() - 1) != arr1[i])
                {
                    result.add(arr1[i]);
                }
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j])
            {
                i++;
            }
            else {
                j++;
            }
        }
        int [] intersection = new int[result.size()];
        for(int k = 0; k<result.size();k++)
        {
            intersection[k] = result.get(k);
        }
        return intersection ;
    }
}
