# ✨ DSA Sorting Notes — Visual Quick Revision

> **Goal:** Fast revision + deep understanding + interview recall

---

# 🫧 Bubble Sort

## 🧠 Intuition
Bubble sort me **bada element bubble ki tarah top (end)** tak chala jata hai.

### Animation Feel
```text
Pass 1
[5 3 2 4]
 compare 5,3 → swap
 [3 5 2 4]
 compare 5,2 → swap
 [3 2 5 4]
 compare 5,4 → swap
 [3 2 4 5]
 largest fixed at end
```

## 🔑 Remember
✅ Adjacent swap → kyunki sirf neighboring elements compare hote hain.  
✅ Early stop possible → agar ek pass me swap nahi hua, array sorted.  
✅ Stable → equal elements ka relative order same rehta hai.

## ⏱ Complexity
| Best | Avg | Worst |
|---|---|---|
| O(n) | O(n²) | O(n²) |

---

```java
private static int[] bubble_sort(int[] arr) {
    for(int i=arr.length-1; i>=0; i--) {
        boolean isSwapped = false;
        for(int j=0; j<=i-1; j++) {
            if(arr[j] > arr[j+1]) {
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                isSwapped = true;
            }
        }
        if(!isSwapped) break;
    }
    return arr;
}
```

# 🎯 Selection Sort

## 🧠 Intuition
Har pass me **minimum select** karo aur front pe rakho.

```text
[4 2 7 1]
↓
find min = 1
↓
[1 2 7 4]
```

## 🔑 Remember
✅ Least swaps → max n-1 swaps only.  
❌ Not stable → swapping min with front may disturb equal elements order.

---

```java
public static int[] selection_sort(int[] arr) {
    for(int i=0; i < arr.length-2; i++) {
        int minIndex = i;
        for(int j=i+1; j < arr.length; j++) {
            if(arr[j] < arr[minIndex]) minIndex = j;
        }
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    return arr;
}
```

# 🃏 Insertion Sort

## 🧠 Intuition
Jaise cards haath me arrange karte ho.

```text
5 3 4 1
↓
3 5 4 1
↓
3 4 5 1
```

## 🔥 Best For
Nearly sorted arrays → kyunki shifts kam hote hain, so almost linear.

---

```java
public static int[] insertion_sort(int[] arr) {
    for(int i=1; i<=arr.length-1; i++) {
        int current = arr[i];
        int j = i-1;
        while(j>=0 && arr[j]>current) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = current;
    }
    return arr;
}
```

# 🌳 Merge Sort

## Divide & Conquer

```text
Step 1: divide into 2 halves
        [8 3 5 1]
         /     \
      [8 3]   [5 1]
      /  \    /  \
    [8] [3] [5] [1]

Step 2: merge sorted
    [3 8]   [1 5]
        \   /
      [1 3 5 8]
```text
[8 3 5 1]
 ↓ split
[8 3] [5 1]
 ↓ split
[8][3][5][1]
 ↓ merge
[3 8][1 5]
 ↓ merge
[1 3 5 8]
```

## Formula
```text
T(n)=2T(n/2)+O(n)
=> O(n log n)
```

## 🔑 Remember
✅ Stable → merge while preserving equal order.  
❌ Extra array required → temporary merged array banta hai.

---

```java
public static void mergeSort(int[] arr, int start, int end) {
    if (start >= end) return;
    int mid = start + (end - start) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    conquer(arr, start, mid, end);
}

public static void conquer(int [] arr, int start, int mid, int end) {
    int i = end-start+1;
    int [] mergedArray = new int[i];
    int left = start;
    int right = mid+1;
    int x=0;
    while(left <= mid && right <= end) {
        if(arr[left] <= arr[right]) mergedArray[x++] = arr[left++];
        else mergedArray[x++] = arr[right++];
    }
    while(left<=mid) mergedArray[x++] = arr[left++];
    while(right<=end) mergedArray[x++] = arr[right++];
    for(int z=0,j=start; z<mergedArray.length; z++,j++) arr[j]=mergedArray[z];
}
```

# ⚡ Quick Sort

## 🧠 Intuition
Pivot choose karo, partition karo.

```text
[6 3 8 2 5]
Pivot = 6
↓
[3 2 5] 6 [8]
```

## Why Quick?
Real-world me often fastest because cache friendly and less extra memory.

⚠ Worst when pivot poor → sorted array + first pivot = O(n²).

---

```java
public static void quick_sort(int [] arr,int start, int end){
    if(start<end){
        int partitionElement = partition(arr, start, end);
        quick_sort(arr, start, partitionElement-1);
        quick_sort(arr, partitionElement+1, end);
    }
}

public static int partition(int []arr, int start, int end){
    int pivot = arr[start];
    int i = start, j = end;
    while(i<j){
        while(arr[i]<=pivot && (i<end)) i++;
        while(arr[j]>pivot && (j>start)) j--;
        if(i<j) swap(arr,i,j);
    }
    swap(arr,start,j);
    return j;
}

public static void swap(int[] arr, int x, int y){
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}
```

# 🔁 Recursive Versions

## Bubble Rec

```java
public static void rec_bubble_sort(int[] arr, int n) {
    if(n==1) return;
    for(int j=1; j<n; j++) {
        if(arr[j-1] > arr[j]) {
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
        }
    }
    rec_bubble_sort(arr,n-1);
}
```
n reduce hota hai.

```text
n=5
pass
↓
n=4
pass
↓
n=3
```

## Insertion Rec

```java
public static void rec_insertion_sort(int [] arr, int n) {
    if(n<=1) return;
    int last = arr[n-1];
    int j = n-2;
    rec_insertion_sort(arr,n-1);
    while(j>=0 && arr[j]>last) {
        arr[j+1] = arr[j];
        j--;
    }
    arr[j+1] = last;
}
```

## Insertion Rec
n-1 sort + last insert.

---

# 🎨 Visual Comparison

| Sort | Logic | Stable | Space | Best Use |
|---|---|---|---|---|
| Bubble | swap | ✅ | O(1) | learning |
| Selection | select min | ❌ | O(1) | less swaps |
| Insertion | insert | ✅ | O(1) | nearly sorted |
| Merge | divide | ✅ | O(n) | guaranteed |
| Quick | pivot | ❌ | O(log n) | practical |

---

# 🚀 Interview Shortcuts

### Ask yourself

✔ Stable?  
✔ In-place?  
✔ Adaptive?  
✔ Recursive?  
✔ Worst case?

---

# 🧠 Memory Map

```text
Bubble    → largest end
Selection → minimum front
Insertion → current insert
Merge     → divide + merge
Quick     → pivot partition
```

---

# 🏆 Golden Tip

### Real Interview
If asked best sorting:

✅ General → Quick  
✅ Stable → Merge  
✅ Small/nearly sorted → Insertion

---

# 🔥 Cheat Mnemonic

## BSIMQ

```text
B → Bubble
S → Selection
I → Insertion
M → Merge
Q → Quick
```

💡 याद करने का shortcut:

> **Bubble swaps**  
> **Selection selects**  
> **Insertion inserts**  
> **Merge divides**  
> **Quick pivots**

