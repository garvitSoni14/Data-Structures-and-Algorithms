package Array;

import java.util.ArrayList;
import java.util.List;

public class Union_Of_Arrays {
    public static void main(String[] args) {
        int arr1[] = {1, 1, 1, 2, 2, 3, 3, 3};
        int arr2[] = {3, 3, 4, 4, 4, 5, 5, 6, 6, 6};

        System.out.println("Union is : " + Union(arr1, arr2));
    }

    public static List<Integer> Union(int arr1[], int arr2[]) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            while (i > 0 && i < arr1.length && arr1[i] == arr1[i - 1]) {
                i++;
            }
            while (j > 0 && j < arr2.length && arr2[j] == arr2[j - 1]) {
                j++;
            }

            if (i >= arr1.length || j>=arr2.length) break;

            if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                union.add(arr2[j]);
                j++;
            }

            else {
                union.add(arr1[i]);
                i++;
                j++;
            }
        }

        while(i < arr1.length)
        {
            if (i ==0 || arr1[i] != arr1[i - 1])
            {
                union.add(arr1[i]);
            }
            i++;
        }
        while(j < arr2.length)
        {
            if(j ==0 || arr2[j] != arr2[j-1])
            {
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }

}
