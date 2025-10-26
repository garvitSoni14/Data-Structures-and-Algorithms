package String;

public class IntegerToRoman {

    public static void main (String [] args){
        int num = 3749;
        System.out.println(intToRoman(num));
    }


    public static String intToRoman(int num) {
            StringBuilder romanized= new StringBuilder();
            int[] values= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] romanMapping = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V", "IV","I"};
            for(int i=0;i<values.length;i++){
                while(num>=values[i]){
                    romanized.append(romanMapping[i]);
                    num-=values[i];
                }
            }
            return romanized.toString();

    }
// TC: O(1)
// SC: O(1)
}
