package Heap;

public class MaxHeap {
    int [] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity){
        this.capacity =capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int parent(int node){
        return (node-1)/2;
    }
    private int leftChild(int node){
        return (node*2)+1;
    }
    private int rightChild(int node){
        return (node*2)+2;
    }
    private void swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    private void shiftUp(int i){
        while(i>0 && heap[parent(i)]<heap[i]){
            swap(parent(i), i);
            i =parent(i);
        }
    }
    public void insert(int key){
        if(size==capacity){
            System.out.println("heap is full");
            return;
        }
        heap[size] = key;
        size++;
        shiftUp(size-1);
    }
    private void shiftDown(int i){
        int maxIndex = i;
        int l = leftChild(i);
        int  r = rightChild(i);
        if(l<size && heap[l]>heap[maxIndex]){
            maxIndex = l;
        }
        if(r<size && heap[r]>heap[maxIndex]){
            maxIndex = r;
        }
        if(i!=maxIndex){
            swap(i, maxIndex);
            shiftDown(maxIndex);
        }
    }

    public int extractMax(){
        if(size == 0){
            System.out.println("heap is empty");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[size-1];
        size--;
        shiftDown(0);
        return max;
    }



    public int peek(){
        if(size==0){
            System.out.println("heap is empty");
            return -1;
        }
        else {
            return heap[0];
        }
    }
    public void buildHeap(int[] arr) {
        heap = arr;
        size = arr.length;
        capacity = arr.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        System.out.println("Max: "+ maxHeap.peek());
        System.out.println("Extract max: "+ maxHeap.extractMax());
        System.out.println("New max: "+ maxHeap.peek());
        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};
        maxHeap.buildHeap(arr);
        System.out.println("Built Heap Max: " + maxHeap.peek());


    }
}