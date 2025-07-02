package BasicMaths;

import java.util.ArrayList;
import java.util.Arrays;

public class All_Divisors {
    public static void main(String[] args){
        int x = 20;
        System.out.println(divisor(x));
    }

    public static ArrayList<Integer> divisor(int x){
        ArrayList<Integer> divisors = new ArrayList<>();
        int sqrtN = (int)Math.sqrt(x);
        for(int i=1; i<=sqrtN; i++){
            if(x%i==0){
                divisors.add(i);
                if(i != x/i){
                    divisors.add(x/i);
                }
            }
        }
        return divisors;
    }
    public static int[] divisor_bruteForce(int x){
        int [] divisorList = new int [x];
        int divisor = 0;
        for(int i=1; i<x; i++){
            if(x%i==0){
                divisorList[divisor++] = i;
            }
        }
        return divisorList;
    }
}
