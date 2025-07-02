package BinarySearch;

public class Book_Allocation_Problem
{
    public static void main(String[] args){
        int [] sample = {12, 34, 67, 90};
        int m = 2;
        System.out.println(bookAllocate(sample, sample.length, m));
    }
    public static int bookAllocate(int [] nums, int size, int m){
        if(m>size) return -1;
        int low = maxOfArray(nums), high = sumOfArray(nums);
        while(low<=high){
            int mid = (low+high)/2;
            int students = countStudents(nums, mid);
            if(students>m){
                low = mid+1;
            }
            else high = mid-1;
        }
        return low;
    }

    public static int countStudents(int [] arr, int pages){
        int students = 1;
        long pagesStudent=0;
        for(int i=0;i<arr.length;i++){
            if(pagesStudent+arr[i]<=pages){
                pagesStudent+=arr[i];
            }
            else {
                students++;
                pagesStudent = arr[i];
            }
        }
        return students;
    }

    public static int maxOfArray(int [] arr){
        int maxElement=Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            maxElement = Math.max(maxElement, arr[i]);
        }
        return maxElement;
    }
    public static int sumOfArray(int [] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
}
