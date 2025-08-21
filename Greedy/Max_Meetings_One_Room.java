package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Max_Meetings_One_Room {
    public static void main(String [] args){
        int [] start = {1,3,0,5,8,5};
        int [] end = {2,4,6,7,9,9};
        System.out.println(maxMeetings(start.length,start, end));
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = S.length;
        int [][] meetings = new int[n][3];
        for(int i=0; i<n; i++){
            meetings[i][0] = S[i];
            meetings[i][1] = F[i];
            meetings[i][2] = i+1; // 1-based index to be returned...
        }
        Arrays.sort(meetings, (a,b)->(a[1]==b[1])?(a[2]-b[2]):(a[1]-b[1]));
        result.add(meetings[0][2]);
        int lastIndex = meetings[0][1];
        for(int i=1; i<n; i++){
            if(meetings[i][0]>lastIndex){
                result.add(meetings[i][2]);
                lastIndex = meetings[i][1];
            }
        }
        result.sort(null);
        return result;
    }
}

// TC: O(n log n) // (n + n log n(sorting) + n(greedy traversal) ===== 2n+nlogn
// SC: O(n) ... in worst case if all the meetings can happen....(n x 3 + n)====4n