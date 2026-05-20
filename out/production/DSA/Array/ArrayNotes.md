fir# 📘 DSA Arrays Notes — Easy Problems (Hindi + English)

## 1️⃣ Largest Element

### 🧠 Problem

Array me sabse bada element nikalna.

### Brute Force

Sort karo ascending → last index largest. Reason: sorting ke baad values increasing order me hoti hain. TC: O(n log n), SC: depends sorting.

### Optimal

Ek `max` variable rakho. Har element compare karo.

### Pseudocode

```text
max = arr[0]
for each element:
   if element > max:
      max = element
return max
```

### Code

```java
public static int largestElement(int arr[]){
    if(arr.length==1) return arr[0];
    int max=arr[0];
    for(int i=1;i<arr.length;i++) if(arr[i]>max) max=arr[i];
    return max;
}
```

TC: O(n), SC: O(1) 💡 Tip: initialize with arr[0], not 0 (negative array issue).

---

## 2️⃣ Second Largest

### Brute

Sort → second last.

### Better

One pass for largest, second pass for second largest. TC: O(2n)

### Optimal

Single traversal with `l` and `sl`.

### Pseudocode

```text
largest=-inf
second=-inf
for num:
  if num > largest:
     second=largest
     largest=num
  else if num > second and num < largest:
     second=num
```

### Code

```java
public static int secondLargestElement(int arr[]) {
    if (arr.length < 2) return -1;
    int l = Integer.MIN_VALUE, sl = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        if (l < arr[i]) { sl = l; l = arr[i]; }
        if (sl < arr[i] && arr[i] < l) sl = arr[i];
    }
    return sl == Integer.MIN_VALUE ? -1 : sl;
}
```

TC O(n), SC O(1)

---

## 3️⃣ Check Sorted
### 🧠 Problem
Check if array ascending sorted hai.

### Brute Force
Har index ke right side sab compare karo. Agar koi smaller mila → false.
Why: kisi bhi element ke baad smaller aaya to order break.
TC: O(n²), SC: O(1)

### Optimal
Sirf adjacent compare.

### Pseudocode
```text
for i=0 to n-2
  if arr[i] > arr[i+1]
    return false
return true
```

### Code
```java
public static boolean ifArraySorted(int arr[]){
    for(int i=0;i<=arr.length-2;i++) if(arr[i]>arr[i+1]) return false;
    return true;
}
```
TC O(n), SC O(1)
Tip: second last tak hi loop.

---

## 4️⃣ Remove Duplicates (Sorted)
### 🧠 Problem
Sorted array me unique elements chahiye.

### Brute
HashSet use.
Store unique, then copy back.
TC O(n), SC O(n)

### Optimal
Two pointers.
`j` = last unique index.

### Visual
```text
[1 1 2 2 3]
 j
    i
when different → j++
```

### Pseudocode
```text
i scans all
j tracks unique
if arr[i]!=arr[j]
  j++
  arr[j]=arr[i]
```

### Code
```java
public static int[] removeDuplicatedFromSorted(int arr[]){
    int j=0;
    for(int i=1;i<arr.length;i++) if(arr[j]!=arr[i]) arr[++j]=arr[i];
    return java.util.Arrays.copyOfRange(arr,0,j+1);
}
```
TC O(n), SC O(1)
Tip: only works sorted array.

---

## 5️⃣ Left Rotate by One
### Brute
Create new array.

### Optimal
Store first, shift left.

### Visual
```text
[1 2 3 4]
→ [2 3 4 1]
```

### Code
```java
public static void leftRotateByOne(int arr[]){
    int first=arr[0];
    for(int i=1;i<arr.length;i++) arr[i-1]=arr[i];
    arr[arr.length-1]=first;
}
```
TC O(n), SC O(1)

---

## 6️⃣ Move Zeroes to End
### Brute
new array.
TC O(n), SC O(n)

### Optimal
Two pointers.

### Visual
```text
[1 0 2 0 3]
 i j
non-zero swap front
```

### Code
```java
public static void moveZeroesToEnd(int [] arr){
    int i=0,j=0;
    while(j<arr.length){
        if(arr[j]!=0){
            if(i!=j){ int t=arr[i]; arr[i]=arr[j]; arr[j]=t; }
            i++;
        }
        j++;
    }
}
```
TC O(n), SC O(1)
Tip: order preserved.

---

## 7️⃣ Linear Search
### Brute = only approach
Every element compare.

### Pseudocode
```text
for i in array
  if arr[i]==target return i
return -1
```

### Code
```java
public static int linearSearch(int arr[], int k){
    for(int i=0;i<arr.length;i++) if(arr[i]==k) return i;
    return -1;
}
```
TC O(n), SC O(1)

---

## 8️⃣ Union of Arrays
### Problem
Unique elements from both arrays.

### Brute Force
HashSet/Map.
TC O(n+m), SC O(n+m)

### Optimal
Two pointers.

### Pseudocode
```text
i=0 j=0
compare
add smaller if unique
move pointer
```

### Code
```java
public static java.util.List<Integer> Union(int a[], int b[]) {
    java.util.ArrayList<Integer> union = new java.util.ArrayList<>();
    int i = 0, j = 0;
    while(i<a.length && j<b.length){
        if(a[i]<=b[j]){
            if(union.isEmpty() || union.get(union.size()-1) !=a[i]) union.add(a[i]);
            i++;
        } else {
            if(union.isEmpty() || union.get(union.size()-1) !=b[j]) union.add(b[j]);
            j++;
        }
    }
    while(i<a.length){ if(union.isEmpty() || union.get(union.size()-1)!=a[i]) union.add(a[i]); i++; }
    while(j<b.length){ if(union.isEmpty() || union.get(union.size()-1)!=b[j]) union.add(b[j]); j++; }
    return union;
}
```
TC O(n+m), SC O(n+m)

---

## 9️⃣ Missing and Repeating
### Brute
For 1..n count each.
TC O(n²)

### Better
Freq array.
TC O(n), SC O(n)

### Optimal
Math equations.

### Logic
```text
x = repeating
y = missing
sum diff = x-y
square diff = x+y
solve
```

### Code
```java
public static int[] findMissingRepeating(int []nums){
    long n = nums.length;
    long Sn = (n*(n+1))/2;
    long S2n = (n*(n+1)*(2*n+1))/6;
    long s=0, s2=0;
    for(int i=0;i<n; i++){ s += nums[i]; s2 += (long) nums[i]*nums[i]; }
    long val1 = s-Sn;
    long val2 = (s2-S2n)/val1;
    long x = (val1+val2)/2;
    long y = x-val1;
    return new int[]{(int)x,(int)y};
}
```
TC O(n), SC O(1)

---

## 🔟 First Missing Positive
### Brute
Sort.
### Better
HashSet.
### Optimal
Index marking.

### Code
```java
public static int firstMissingPositive(int[] nums) {
    int l = nums.length;
    for(int i=0;i<l;i++) if(nums[i]<=0 || nums[i]>=l+1) nums[i]=l+1;
    for(int i=0;i<l;i++){
        int el=Math.abs(nums[i]);
        if(el==l+1) continue;
        int seat=el-1;
        if(nums[seat]>0) nums[seat]*=-1;
    }
    for(int i=0;i<l;i++) if(nums[i]>0) return i+1;
    return l+1;
}
```
TC O(n), SC O(1)

---

## 1️⃣1️⃣ Maximum Consecutive Ones
### Brute
All subarrays.
TC O(n²)

### Optimal
Count streak.

```java
public static int maxConsecutiveOnes(int arr[]){
    int result=0,count=0;
    for(int i:arr){
        if(i==1){ count++; result=Math.max(result,count);} else count=0;
    }
    return result;
}
```
TC O(n), SC O(1)

---

## 1️⃣2️⃣ Occurs Once
### Brute
Nested loops.
### Better
HashMap.
### Optimal
XOR.
Reason: a^a=0.

```java
public static int occurForOnce(int arr[]) {
    int xor=0;
    for(int i:arr) xor^=i;
    return xor;
}
```
TC O(n), SC O(1)

---

## 1️⃣3️⃣ Longest Subarray Sum 0
### Brute
All subarrays.
TC O(n²)

### Better/Optimal
Prefix sum map.

### Why?
Same prefix sum repeat => between them sum zero.

```java
public static int longestSubarray(int [] arr) {
    java.util.HashMap<Integer,Integer> hm = new java.util.HashMap<>();
    int maxlen=0,sum=0;
    for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        if(sum==0) maxlen=i+1;
        if(hm.containsKey(sum)) maxlen=Math.max(maxlen,i-hm.get(sum));
        else hm.put(sum,i);
    }
    return maxlen;
}
```
TC O(n), SC O(n)

---

## 1️⃣4️⃣ Longest Subarray K Sum
### Brute
All subarrays.
TC O(n³)

### Better
Prefix sum map.

### Optimal
Sliding window (positive only).

### Code
```java
public static int longestSubarrayWithKSum(int arr[],int k) {
    int currentSum = 0, result = 0, i = 0, j = 0;
    while(j<arr.length){
        currentSum+=arr[j];
        while(i<j && currentSum>k){ currentSum-=arr[i]; i++; }
        if(currentSum==k) result = Math.max(j-i+1, result);
        j++;
    }
    return result;
}
```
TC O(n), SC O(1)

---

# 🧠 Universal Tips
- sorted arrays → two pointers
- subarray sum → prefix sum
- single unique → XOR
- missing/repeating → math / marking
- rotate → shifting

# 🚀 Interview Checklist
✔ duplicates?
✔ sorted?
✔ negative values?
✔ can modify array?
✔ extra space?

