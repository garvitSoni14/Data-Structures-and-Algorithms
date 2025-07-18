// BRUTE FORCE: ( We can to Collections.sort() for ascending order result) Traverse both arrays one by one and put all the elements inside a Hashmap with will store only unique elements with their frequencies. TC: O(n+m), SC: (n+m)
// BRUTE FORCE: (They are unordered) We can use Hashset which stores only unique elements. TC: O(n+M), SC:O(n+m).
// OPTIMAL APPROACH : Using two pointers (i,j) pointing to the start of arr1, arr2 respectively.
package Array;

import java.util.*;

public class Union_Of_Arrays {
    public static void main(String[] args) {
        int arr1[] = {1, 1, 1, 2, 2, 3, 3, 3,7, 7, 7};
        int arr2[] = {3, 3, 4, 4, 4, 5, 5, 6, 6, 6};

//        System.out.println("Union is : " + Arrays.toString(bruteForce_Union(arr1, arr2)));
        System.out.println("Union is : " + Union(arr1, arr2));
    }

    public static int [] bruteForce_Union(int [] arr1, int [] arr2){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i < arr1.length; i++){
            mp.put(arr1[i], mp.getOrDefault(arr1[i],0)+1);
        }
        for(int i=0; i < arr2.length; i++){
            mp.put(arr2[i], mp.getOrDefault(arr2[i],0)+1);
        }
        int [] result = new int[mp.size()];
        int k=0;
        for(Integer i:mp.keySet()){
            result[k++] = i;
        }
        return result;
    }

    public static List<Integer> Union(int arr1[], int arr2[]) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j])
                { if(union.isEmpty() || union.get(union.size()-1) != arr1[i]) union.add(arr1[i]); i++;}
            else if(arr1[i] > arr2[j])
                { if(union.isEmpty() || union.get(union.size()-1) != arr2[i]) union.add(arr2[i]); j++;}
            else if(arr1[i] == arr2[j])
            { if(union.isEmpty() || union.get(union.size()-1) != arr2[i]) union.add(arr2[i]); i++; j++;}
        }
        while(i<arr1.length){
            if(union.isEmpty() || union.get(union.size()-1) != arr1[i]) union.add(arr1[i]); i++;
        }
        while(j<arr2.length){
            if(union.isEmpty() || union.get(union.size()-1) != arr2[i]) union.add(arr2[i]); j++;
        }

        return union;


    }

}

// TC: O(n+m)
// SC: O(n+m)
