package Stack;

import org.w3c.dom.ls.LSOutput;

import java.util.Stack;

public class Remove_K_Digits
{
    public static void main(String[] args)
    {
        String s="001432219";
        int k=3;
        System.out.println(Rem_K_Numbers(s,k));
    }

    public static String Rem_K_Numbers(String num, int k)
    {
        Stack<Character> stack = new Stack<>();

        // Iterate over each character in num
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Remove remaining k elements if necessary
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the result from the stack
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse(); // Reverse to correct order

        // Remove leading zeros
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.length() == 0 ? "0" : res.toString();
    }

}
