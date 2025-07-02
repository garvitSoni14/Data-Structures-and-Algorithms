package BasicMaths;

public class Check_Amstorng {
    public static void main(String [] args){
        int x= 371;
        System.out.println(isAmstrong(x));
    }

    public static boolean isAmstrong(int x){
        int cubedSum = 0;
        int originalNumber = x;
        while(x>0){
            cubedSum+= Math.pow((x%10),3);
            x = x/10;
        }
        return (cubedSum == originalNumber) ? true : false;
    }
}

//TC: O(Log 10 n +1)
//SC: O(1)
