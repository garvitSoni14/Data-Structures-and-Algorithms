package Heap;

public class MinHeap {
    int [] heap;
    int size;
    int capacity;

    public MinHeap(int capacity){
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
        while(i>0 && heap[parent(i)]>heap[i]){
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
        int minIndex = i;
        int l = leftChild(i);
        int  r = rightChild(i);
        if(l<size && heap[l]<heap[minIndex]){
            minIndex = l;
        }
        if(r<size && heap[r]<heap[minIndex]){
            minIndex = r;
        }
        if(i!=minIndex){
            swap(i, minIndex);
            shiftDown(minIndex);
        }
    }

    public int extractMin(){
        if(size == 0){
            System.out.println("heap is empty");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size-1];
        size--;
        shiftDown(0);
        return min;
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
        for (int i = (size / 2) - 1; i >= 0; i--)
        {
            shiftDown(i);
        }
    }

    public static void main(String[] args){
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(15);
        minHeap.insert(30);
        System.out.println("Min: "+ minHeap.peek());
        System.out.println("Extract min: "+ minHeap.extractMin());
        System.out.println("New min: "+ minHeap.peek());
        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};
        minHeap.buildHeap(arr);
        System.out.println("Built Heap Min: " + minHeap.peek());
    }
}