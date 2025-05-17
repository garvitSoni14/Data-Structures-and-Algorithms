package BinarySearch;

public class Floor_SQRT {
    public static void main(String[] args){
        int x= 84;
        System.out.println(mySqrt(x));
    }
    public static int mySqrt(int x) {
        long low = 1, high = (long)x;
        while(low<=high){
            long mid = (low+high)/2;
            if((mid*mid)<=x) low = mid+1;
            else high = mid-1;
        }
        return (int)high;
    }
}

// if we didn't perform this with long data type, because when x is larger number like(2,147,483,647), the int mid (mid*mid) becomes too big and cannot be handled by int so we have to wrap up inside a long variable.
