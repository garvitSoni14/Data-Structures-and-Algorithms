package Greedy;

import java.util.PriorityQueue;

public class Minimum_Ropes_Cost {
    public static void main(String args[]){
        int sample[]= {4, 2, 7, 6, 9};
        System.out.println(countMinCost(sample));
    }
    public static int countMinCost(int [] ropes){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:ropes){
            pq.add(i);
        }
        int totalCost=0;
        while(pq.size() > 1){
            int smallest = pq.poll();
            int secondSmallest = pq.poll();
            int cost = smallest+secondSmallest;
            totalCost+= (cost);
            pq.add(cost);
        }
        return totalCost;
    }
}
