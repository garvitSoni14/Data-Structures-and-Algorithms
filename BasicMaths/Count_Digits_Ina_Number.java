package BasicMaths;

public class Count_Digits_Ina_Number {

    public static void main(String[] args)
    {
        int n = 12345;
        System.out.println(countDigits(n));
    }

    public static int countDigits(int number){
    int count = (int) Math.log10(number)+1;
    return count;
    }

    //TC:O(log10N+1)
    //SC:O(1)

    public static int countDigits_BruteForce(int number){
        int count = 0;
        while(number>0){
            count+=1;
            number = number/10;
        }
        return count;
    }
    //TC:O(n)
    //SC:O(1)
}
