package BasicMaths;

public class GCD_HCF {

    public static void main(String[] args){
        int a = 200;
        int b = 180;
        System.out.println(hcf_brutForce(a,b));
    }

    public static int GCD(int a, int b){
        while(a>0 && b>0){
            if(a>b){ a = a % b; }
            else { b = b % a; }
        }
        if(a==0) return b;
        return a;
    }
    //TC:O(Log min(a,b)
    //SC:O(1)

    public static int hcf_brutForce(int a, int b){
        if (a==0) return Math.abs(b);
        if (b==0) return Math.abs(a);

        int minOfBoth = Math.min(a,b);
        for(int i = minOfBoth; i >= 1; i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
    //TC:O(min(a,b)
    //SC:O(1)
}
