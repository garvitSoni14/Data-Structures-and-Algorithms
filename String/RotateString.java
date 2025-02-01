package String;

public class RotateString
{
    public static void main(String [] args)
    {
        String str1 = "abcdef";
        String str2 = "cdefab";
        System.out.println(rotateString(str1,str2));
    }

    public static Boolean rotateString(String s1, String s2)
    {
        return (s1.length()==s2.length() && (s1+s1).contains(s2));
    }
}
