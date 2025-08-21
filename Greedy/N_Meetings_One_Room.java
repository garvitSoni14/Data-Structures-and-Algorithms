package Greedy;

import java.util.Arrays;
import java.util.Set;

public class N_Meetings_One_Room {
    public static void main(String [] args){
        int [] start = {1,3,0,5,8,5};
        int [] end = {2,4,6,7,9,9};
        System.out.println(maxMeetings(start, end));
    }

    public static int maxMeetings(int start[], int end[]) {
        int n= start.length;
        int [][] meetings = new int [n][2];
        for(int i=0;i<n; i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, (a,b)->a[1]-b[1]);
        int count=1, lastIndex = meetings[0][1];
        for(int i=1; i<n; i++){
            if(meetings[i][0]>lastIndex){count++;
                lastIndex = meetings[i][1];

            }}
        return count;
    }
}

// TC: O(n log n)
// SC: O(n)