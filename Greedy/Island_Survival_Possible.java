package Greedy;

public class Island_Survival_Possible {

    public static void main(String [] args){
        System.out.println(minimumDays(10,9, 8));
    }


    static int minimumDays(int S, int N, int M) {

        int sundays = S/7;         //number of sundays (shop will be closed)
        int buyingDays= S-sundays;      // number of days shop opened
        int totalFoodPackets = S*M;        // total packets needed in all days
        int daysNeededToBuy = 0;         // answer
        if(totalFoodPackets%N==0){              // how many days we have to purchase the food(answer)
            daysNeededToBuy = totalFoodPackets/N;
        }
        else { daysNeededToBuy = (totalFoodPackets/N)+1;}
        if(M>N) return -1;                   // if we cant buy 1 day survival food in one turn of purchase, we will die.
        if((7*M)>(6*N) && (S>6)) return -1;         // if the food packets purchased in 6 days are not enough to survive for 7 days we will die (we cant buy on 7th day(sunday)
        if(daysNeededToBuy <=buyingDays) { return daysNeededToBuy; }     // if we dont get opportunity to buy food for adequate days we would die.
        else { return -1;}
    }
}

// TC: O(1)
// SC: O(1)


