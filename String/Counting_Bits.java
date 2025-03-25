package String;

import java.util.List;

public class Counting_Bits {

    public static void main(String[] args)
    {
        int n=161;
        CB(n);
    }

    public static void CB(int n)
    {
        int total1 =0;
        int index=1;
        String s= Integer.toBinaryString(n);
        for(char c:s.toCharArray())
        {
            if(c=='1') {
                total1++;
                System.out.println(index);
            }
            index++;
        }
        System.out.println(total1);
    }


}
