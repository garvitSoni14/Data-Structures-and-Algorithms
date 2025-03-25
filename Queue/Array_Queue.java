package Queue;

public class Array_Queue
{
    public static void main(String[]  args)
    {
        Array_Implementation_Queue Q = new Array_Implementation_Queue(20);
//        System.out.println(Q.arr.length());
        System.out.println();
    }
}



class Array_Implementation_Queue{
    private int start, end = -1;
    private int [] arr = new int[1];
    private int currentSize=0;
    private int maxsize;

    public Array_Implementation_Queue(int maxsize)
    {    arr = new int[maxsize];
         this.maxsize = maxsize;
    }

    public void push(int data)
    {
        if(currentSize==maxsize)
        {
            System.out.println("Queue is Empty");
            return;
        }
        if(start == -1 && end ==-1)
        {
            start = end = 0;
            arr[end] = data;
            currentSize+=1;
            return;
        }
        end+=1;
        arr[end]=data;
        return;

    }

}
