// BRUTEFORCE: Try all possible triplets using 3 nested loops, and store unique ones that sum to 0 using a Set after sorting them. TC: O(n^3), SC: O(n^2).
// Better APPROACH: Fix one element, then use a HashSet to check if the third number exists to complete a zero-sum triplet, sorting and storing unique ones in a Set. TC: O(n^2), SC: O(n^2)
// Optimal APPROACH: Sort the array, fix one element, and use two pointers (j, k) to find all unique triplets that sum to 0, skipping duplicates to avoid repeats.

package Array;

import java.util.*;

public class Three_Sum {

    public static void main(String [] args){
        int arr[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length; i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k = arr.length-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j] == arr[j-1])j++;
                    while(j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return ans;
    }
// TC: O(n^2)
// SC: O(1)

    public static List<List<Integer>> threeSum_Better(int arr[]){
        Set<List<Integer>> st =  new HashSet<>();
        for(int i=0; i<arr.length; i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1; j<arr.length; j++){
                int third = -(arr[i]+arr[j]);
                if(hashset.contains(third)){
                    List<Integer> tempList = Arrays.asList(arr[i], arr[j], third);
                    tempList.sort(null);
                    st.add(tempList);
                }
                hashset.add(arr[j]);
            }
        }
        List<List<Integer>> result = new ArrayList<>(st);
        return result;
    }
    public static List<List<Integer>> threeSum_BRUTEFORCE(int arr[]){
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                for(int k = j+1; k< arr.length; k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> tempList = Arrays.asList(arr[i], arr[j], arr[k]);
                        tempList.sort(null);
                        st.add(tempList);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(st);
        return result;
    }
}
