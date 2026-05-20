# ✨ DSA Sorting Notes — Visual Quick Revision

> 🎯 **Goal:** Fast revision + deep understanding + interview recall
>
> 📚 **Covers:** Bubble · Selection · Insertion · Merge · Quick · Recursive Variants
>
> 🏷️ **Tags:** `#DSA` `#Sorting` `#Java` `#Interview` `#Algorithms`

---

## 📋 Table of Contents

| # | Algorithm | Time (Best) | Time (Worst) | Stable | Space |
|---|-----------|:-----------:|:------------:|:------:|:-----:|
| 1 | [🫧 Bubble Sort](#-bubble-sort) | `O(n)` | `O(n²)` | ✅ | `O(1)` |
| 2 | [🎯 Selection Sort](#-selection-sort) | `O(n²)` | `O(n²)` | ❌ | `O(1)` |
| 3 | [🃏 Insertion Sort](#-insertion-sort) | `O(n)` | `O(n²)` | ✅ | `O(1)` |
| 4 | [🌳 Merge Sort](#-merge-sort) | `O(n log n)` | `O(n log n)` | ✅ | `O(n)` |
| 5 | [⚡ Quick Sort](#-quick-sort) | `O(n log n)` | `O(n²)` | ❌ | `O(log n)` |

---

## 🫧 Bubble Sort

> ### 🧠 Intuition
> Bubble sort me **bada element bubble ki tarah top (end)** tak chala jata hai.

### 🎬 Animation Feel

```
Pass 1
┌─────────────────────────────────┐
│  [5  3  2  4]  → compare 5, 3  │
│  [3  5  2  4]  → compare 5, 2  │
│  [3  2  5  4]  → compare 5, 4  │
│  [3  2  4  5]  → ✅ largest fixed at end  │
└─────────────────────────────────┘
```

### 🔑 Key Properties

| Property | Detail |
|----------|--------|
| 🔄 Swap Type | **Adjacent swap** — sirf neighboring elements compare hote hain |
| ⏹️ Early Stop | **Possible** — agar ek pass me swap nahi hua, array sorted |
| ⚖️ Stability | **Stable** — equal elements ka relative order same rehta hai |

### ⏱️ Complexity

| Case | Time | Space |
|------|------|-------|
| 🟢 Best | `O(n)` | `O(1)` |
| 🟡 Average | `O(n²)` | `O(1)` |
| 🔴 Worst | `O(n²)` | `O(1)` |

### 💻 Java Code

```java
private static int[] bubble_sort(int[] arr) {
    for (int i = arr.length - 1; i >= 0; i--) {
        boolean isSwapped = false;
        for (int j = 0; j <= i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                isSwapped = true;
            }
        }
        if (!isSwapped) break;   // ← Early exit optimization
    }
    return arr;
}
```

---

## 🎯 Selection Sort

> ### 🧠 Intuition
> Har pass me **minimum select** karo aur front pe rakho.

### 🎬 Animation Feel

```
[4  2  7  1]
      ↓
 find min = 1
      ↓
[1  2  7  4]
      ↓
 find min = 2  (already in place)
      ↓
[1  2  4  7]  ✅
```

### 🔑 Key Properties

| Property | Detail |
|----------|--------|
| 🔄 Swap Count | **Least swaps** — max `n-1` swaps only |
| ⚖️ Stability | **Not stable** ❌ — swapping min with front may disturb equal elements order |

### ⏱️ Complexity

| Case | Time | Space |
|------|------|-------|
| 🟢 Best | `O(n²)` | `O(1)` |
| 🟡 Average | `O(n²)` | `O(1)` |
| 🔴 Worst | `O(n²)` | `O(1)` |

### 💻 Java Code

```java
public static int[] selection_sort(int[] arr) {
    for (int i = 0; i < arr.length - 2; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) minIndex = j;
        }
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    return arr;
}
```

---

## 🃏 Insertion Sort

> ### 🧠 Intuition
> Jaise **cards haath me arrange** karte ho — ek ek card uthao aur sahi jagah daalo.

### 🎬 Animation Feel

```
[5  3  4  1]
    ↓ pick 3, insert before 5
[3  5  4  1]
    ↓ pick 4, insert between 3 & 5
[3  4  5  1]
    ↓ pick 1, insert at beginning
[1  3  4  5]  ✅
```

### 🔥 Best Use Case

> **Nearly sorted arrays** → kyunki shifts kam hote hain, so almost linear `O(n)`.

### ⏱️ Complexity

| Case | Time | Space |
|------|------|-------|
| 🟢 Best (sorted) | `O(n)` | `O(1)` |
| 🟡 Average | `O(n²)` | `O(1)` |
| 🔴 Worst (reverse) | `O(n²)` | `O(1)` |

### 💻 Java Code

```java
public static int[] insertion_sort(int[] arr) {
    for (int i = 1; i <= arr.length - 1; i++) {
        int current = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > current) {
            arr[j + 1] = arr[j];   // ← shift right
            j--;
        }
        arr[j + 1] = current;      // ← place in correct spot
    }
    return arr;
}
```

---

## 🌳 Merge Sort

> ### 🧠 Intuition
> **Divide & Conquer** — array ko tod do, sort karo, phir merge karo.

### 🎬 Animation Feel

```
Step 1 — DIVIDE
        [8  3  5  1]
           /      \
       [8  3]    [5  1]
       /   \     /   \
     [8]  [3]  [5]  [1]

Step 2 — CONQUER (merge sorted halves)
     [3  8]       [1  5]
          \       /
          [1  3  5  8]  ✅
```

### 📐 Recurrence Formula

```
T(n) = 2T(n/2) + O(n)
     ⟹ O(n log n)       ← by Master Theorem
```

### 🔑 Key Properties

| Property | Detail |
|----------|--------|
| ⚖️ Stability | **Stable** ✅ — merge while preserving equal order |
| 💾 Extra Space | **Required** ❌ — temporary merged array banta hai → `O(n)` |
| 🔒 Guaranteed | **Always** `O(n log n)` — no bad worst case |

### ⏱️ Complexity

| Case | Time | Space |
|------|------|-------|
| 🟢 Best | `O(n log n)` | `O(n)` |
| 🟡 Average | `O(n log n)` | `O(n)` |
| 🔴 Worst | `O(n log n)` | `O(n)` |

### 💻 Java Code

```java
public static void mergeSort(int[] arr, int start, int end) {
    if (start >= end) return;
    int mid = start + (end - start) / 2;
    mergeSort(arr, start, mid);       // ← sort left half
    mergeSort(arr, mid + 1, end);     // ← sort right half
    conquer(arr, start, mid, end);    // ← merge both
}

public static void conquer(int[] arr, int start, int mid, int end) {
    int[] mergedArray = new int[end - start + 1];
    int left = start, right = mid + 1, x = 0;

    while (left <= mid && right <= end) {
        if (arr[left] <= arr[right]) mergedArray[x++] = arr[left++];
        else                         mergedArray[x++] = arr[right++];
    }
    while (left <= mid)  mergedArray[x++] = arr[left++];   // ← remaining left
    while (right <= end) mergedArray[x++] = arr[right++];  // ← remaining right

    for (int z = 0, j = start; z < mergedArray.length; z++, j++)
        arr[j] = mergedArray[z];
}
```

---

## ⚡ Quick Sort

> ### 🧠 Intuition
> **Pivot choose karo**, usse sahi jagah rakho — left me chhote, right me bade.

### 🎬 Animation Feel

```
[6  3  8  2  5]   Pivot = 6
        ↓
[3  2  5] | 6 | [8]
        ↓
[2  3  5]   6   [8]   ✅
```

### 🔥 Why Quick?

> Real-world me often **fastest** because:
> - ✅ Cache friendly
> - ✅ Less extra memory than Merge
> - ✅ Good average performance

> ⚠️ **Worst Case Warning:** Poor pivot → `O(n²)`
> Example: Sorted array + first element as pivot = disaster!

### ⏱️ Complexity

| Case | Time | Space |
|------|------|-------|
| 🟢 Best | `O(n log n)` | `O(log n)` |
| 🟡 Average | `O(n log n)` | `O(log n)` |
| 🔴 Worst (bad pivot) | `O(n²)` | `O(n)` |

### 💻 Java Code

```java
public static void quick_sort(int[] arr, int start, int end) {
    if (start < end) {
        int partitionElement = partition(arr, start, end);
        quick_sort(arr, start, partitionElement - 1);  // ← left of pivot
        quick_sort(arr, partitionElement + 1, end);    // ← right of pivot
    }
}

public static int partition(int[] arr, int start, int end) {
    int pivot = arr[start];
    int i = start, j = end;

    while (i < j) {
        while (arr[i] <= pivot && (i < end))  i++;  // ← find elem > pivot
        while (arr[j] > pivot  && (j > start)) j--; // ← find elem ≤ pivot
        if (i < j) swap(arr, i, j);
    }
    swap(arr, start, j);   // ← place pivot in correct position
    return j;
}

public static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}
```

---

## 🔁 Recursive Versions

### 🫧 Recursive Bubble Sort

> **Idea:** Each recursive call fixes the largest element → reduces `n` by 1.

```
n = 5  →  one full pass  →  n = 4
n = 4  →  one full pass  →  n = 3
n = 3  →  one full pass  →  n = 2
n = 2  →  one full pass  →  n = 1  → base case ✅
```

```java
public static void rec_bubble_sort(int[] arr, int n) {
    if (n == 1) return;                   // ← base case
    for (int j = 1; j < n; j++) {
        if (arr[j - 1] > arr[j]) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
        }
    }
    rec_bubble_sort(arr, n - 1);          // ← n reduces by 1 each call
}
```

---

### 🃏 Recursive Insertion Sort

> **Idea:** First sort `n-1` elements recursively, then insert the last element.

```
rec(arr, n-1)  →  sort first n-1 elements
      ↓
insert arr[n-1] into its correct position
```

```java
public static void rec_insertion_sort(int[] arr, int n) {
    if (n <= 1) return;                  // ← base case
    rec_insertion_sort(arr, n - 1);      // ← sort first n-1 elements

    int last = arr[n - 1];
    int j = n - 2;
    while (j >= 0 && arr[j] > last) {
        arr[j + 1] = arr[j];            // ← shift right
        j--;
    }
    arr[j + 1] = last;                  // ← insert last in correct place
}
```

---

## 🎨 Visual Comparison Table

| Sort | Core Logic | Stable | In-Place | Space | Adaptive | Best Use Case |
|------|-----------|:------:|:--------:|-------|:--------:|---------------|
| 🫧 Bubble | Swap adjacent | ✅ | ✅ | `O(1)` | ✅ | Learning / small arrays |
| 🎯 Selection | Select minimum | ❌ | ✅ | `O(1)` | ❌ | When writes are costly |
| 🃏 Insertion | Insert in place | ✅ | ✅ | `O(1)` | ✅ | Nearly sorted arrays |
| 🌳 Merge | Divide & merge | ✅ | ❌ | `O(n)` | ❌ | Guaranteed performance |
| ⚡ Quick | Pivot partition | ❌ | ✅ | `O(log n)` | ❌ | General purpose / real world |

---

## 🚀 Interview Shortcuts

### ✅ Ask Yourself Before Answering

```
┌────────────────────────────────────────┐
│  ✔  Stable?      → Merge or Insertion  │
│  ✔  In-place?    → Bubble / Select / Insert / Quick  │
│  ✔  Adaptive?    → Bubble / Insertion  │
│  ✔  Recursive?   → Merge / Quick       │
│  ✔  Worst case?  → Merge always n log n│
└────────────────────────────────────────┘
```

### 🏆 Golden Tip — Real Interview Answer

| Scenario | Best Choice | Reason |
|----------|-------------|--------|
| 🥇 General purpose | **Quick Sort** | Fast in practice, cache-friendly |
| 🎖️ Need stability | **Merge Sort** | Guaranteed O(n log n) + stable |
| 📦 Small / nearly sorted | **Insertion Sort** | Nearly linear for sorted data |

---

## 🧠 Memory Map

```
┌─────────────────────────────────────────┐
│                                         │
│  Bubble    →  🫧  largest floats END    │
│  Selection →  🎯  minimum to FRONT      │
│  Insertion →  🃏  current INSERT right  │
│  Merge     →  🌳  DIVIDE then merge     │
│  Quick     →  ⚡  PIVOT then partition  │
│                                         │
└─────────────────────────────────────────┘
```

---

## 🔥 Cheat Mnemonic — BSIMQ

```
B → 🫧 Bubble     →  Bubble swaps    (adjacent elements)
S → 🎯 Selection  →  Selection selects (minimum each pass)
I → 🃏 Insertion  →  Insertion inserts (current into sorted)
M → 🌳 Merge      →  Merge divides    (split + conquer)
Q → ⚡ Quick      →  Quick pivots     (partition around pivot)
```

> 💡 **याद करने का shortcut:**
>
> > **Bubble** *swaps* · **Selection** *selects* · **Insertion** *inserts* · **Merge** *divides* · **Quick** *pivots*

---

## 📊 Complexity Quick-Ref

```
Algorithm     Best        Average     Worst       Space
─────────────────────────────────────────────────────────
Bubble        O(n)        O(n²)       O(n²)       O(1)
Selection     O(n²)       O(n²)       O(n²)       O(1)
Insertion     O(n)        O(n²)       O(n²)       O(1)
Merge         O(n log n)  O(n log n)  O(n log n)  O(n)
Quick         O(n log n)  O(n log n)  O(n²)       O(log n)
─────────────────────────────────────────────────────────
```

---

*📝 Notes by — DSA Revision Series | Last Updated: 2025*
