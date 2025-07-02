package BasicMaths;

public class Check_For_Prime {

    public static void main(String[] args){
        int x = 4;
        System.out.println(prime(x));
    }

    public static boolean prime(int x){
        if(x<=1) return false;
        int sqrt = (int)Math.sqrt(x);
        for(int i=2; i<=sqrt; i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
