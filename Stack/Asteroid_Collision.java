package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Asteroid_Collision
{

    public static void main(String[] args)
    {
        int [] arr={10,2,-5};
        System.out.println(Asteroid_Col(arr));
    }

    public static int[] Asteroid_Col(int [] asteroid)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<asteroid.length; i++)
        {
            if(asteroid[i]>0) stack.push(asteroid[i]);
            else {
                while(!stack.isEmpty() && stack.peek()<Math.abs(asteroid[i]) && stack.peek()>0)
                {
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek()==Math.abs(asteroid[i]))
                {
                    stack.pop();
                }
                else if (stack.isEmpty() || stack.peek()<0)
                {
                    stack.push(asteroid[i]);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

