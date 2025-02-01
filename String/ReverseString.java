package String;

public class ReverseString
{
    public static void main(String [] args)
    {
        String str = "Hello World !";
        System.out.println(reverseString(str));
    }
    public static String reverseString(String s)
    {
        char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;
        while (left < right) {

            // Swap elements
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;

            // Move pointers
            left++;
            right--;
        }

        return new String(c);
    }

}
