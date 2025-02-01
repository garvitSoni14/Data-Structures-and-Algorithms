package String;

public class ReverseWords
{
    public static void main(String [] args)
    {
        String str = "Hello this is my DSA Series !      ";
//        reverseWords(str);
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s)
    {
        String arr[] = s.split(" +");
       StringBuilder stringBuilder = new StringBuilder();
       for(int i = arr.length-1; i>=0 ;i--)
       {
           stringBuilder.append(arr[i]);
           stringBuilder.append(" ");
       }
        return stringBuilder.toString().trim();
    }

}
