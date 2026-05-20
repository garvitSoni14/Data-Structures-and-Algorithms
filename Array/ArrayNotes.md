# 📘 DSA Arrays Notes — Easy to Medium Problems (Hindi + English)

## 1️⃣ Largest Element

### 🧠 Problem
Array me sabse bada element nikalna.

### Brute Force
Sort karo ascending → last index largest.  
Reason: sorting ke baad values increasing order me hoti hain.  
TC: O(n log n), SC: depends sorting.

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

TC: O(n), SC: O(1)

💡 Tip: initialize with arr[0], not 0 (negative array issue).

---

## 2️⃣ Second Largest

### Brute
Sort → second last.

### Better
One pass for largest, second pass for second largest.  
TC: O(2n)

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
        if (l < arr[i]) {
            sl = l;
            l = arr[i];
        }

        if (sl < arr[i] && arr[i] < l) {
            sl = arr[i];
        }
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
Har index ke right side sab compare karo.  
Agar koi smaller mila → false.

Why: kisi bhi element ke baad smaller aaya to order break.

TC: O(n²), SC: O(1)

### Optimal
Sirf adjacent compare.

### Code
```java
public static boolean ifArraySorted(int arr[]){
    for(int i=0;i<=arr.length-2;i++)
        if(arr[i]>arr[i+1]) return false;

    return true;
}
```

TC O(n), SC O(1)

---

## 4️⃣ Remove Duplicates (Sorted)

### Brute
HashSet use.

TC O(n), SC O(n)

### Optimal
Two pointers.

### Code
```java
public static int[] removeDuplicatedFromSorted(int arr[]){
    int j=0;

    for(int i=1;i<arr.length;i++)
        if(arr[j]!=arr[i]) arr[++j]=arr[i];

    return java.util.Arrays.copyOfRange(arr,0,j+1);
}
```

TC O(n), SC O(1)

---

## 5️⃣ Left Rotate by One

### Optimal
Store first, shift left.

### Code
```java
public static void leftRotateByOne(int arr[]){
    int first=arr[0];

    for(int i=1;i<arr.length;i++)
        arr[i-1]=arr[i];

    arr[arr.length-1]=first;
}
```

TC O(n), SC O(1)

---

## 6️⃣ Left Rotate by K

### Brute Force
Copy first/last k elements into temp array and shift remaining elements.

TC: O(n), SC: O(n)

### Optimal Approach
Reverse first k elements, reverse remaining elements, then reverse whole array.

### Code
```java
public static void leftRotateByk(int arr[], int k)
{
    reverseArray(arr,0,k-1);
    reverseArray(arr,k,arr.length-1);
    reverseArray(arr,0, arr.length-1);
}

public static void reverseArray(int arr[], int startIndex, int endIndex)
{
    while(startIndex <= endIndex)
    {
        int temp = arr[startIndex];
        arr[startIndex] = arr[endIndex];
        arr[endIndex] = temp;

        startIndex++;
        endIndex--;
    }
}
```

TC: O(n)  
SC: O(1)

---

# 🚀 EASY SECTION ENDS HERE

---

## 7️⃣ Move Zeroes to End

### Optimal
Two pointers.

### Code
```java
public static void moveZeroesToEnd(int [] arr){
    int i=0,j=0;

    while(j<arr.length){
        if(arr[j]!=0){
            if(i!=j){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
            i++;
        }
        j++;
    }
}
```

TC O(n), SC O(1)

---

## 8️⃣ Linear Search

### Code
```java
public static int linearSearch(int arr[], int k){
    for(int i=0;i<arr.length;i++)
        if(arr[i]==k) return i;

    return -1;
}
```

TC O(n), SC O(1)

---

## 9️⃣ Union of Arrays

### Optimal
Two pointers.

### Code
```java
public static java.util.List<Integer> Union(int a[], int b[]) {

    java.util.ArrayList<Integer> union = new java.util.ArrayList<>();

    int i = 0, j = 0;

    while(i<a.length && j<b.length){

        if(a[i]<=b[j]){

            if(union.isEmpty() || union.get(union.size()-1) !=a[i])
                union.add(a[i]);

            i++;
        }
        else {

            if(union.isEmpty() || union.get(union.size()-1) !=b[j])
                union.add(b[j]);

            j++;
        }
    }

    return union;
}
```

TC O(n+m), SC O(n+m)

---

## 🔟 Missing and Repeating Number

### Brute Force
For every number 1..n count frequency.

TC: O(n²), SC: O(1)

### Better
Use frequency array / HashMap.

TC: O(n), SC: O(n)

### Optimal
Use mathematical equations.

### Code
```java
public static int[] findMissingRepeating(int []nums){

    long n = nums.length;

    long Sn = (n*(n+1))/2;
    long S2n = (n*(n+1)*(2*n+1))/6;

    long s=0, s2=0;

    for(int i=0;i<n; i++){
        s += (long)nums[i];
        s2 += (long) (nums[i]*nums[i]);
    }

    long val1 = s-Sn;
    long val2 = s2-S2n;

    val2 = val2/val1;

    long x = (val1 + val2)/2;
    long y = x - val1;

    return new int[]{(int)x,(int)y};
}
```

TC: O(n)  
SC: O(1)

---

## 1️⃣1️⃣ First Missing Positive

### Optimal
Index marking / Pigeonhole technique.

### Code
```java
public static int firstMissingPositive(int[] nums) {

    int l = nums.length;

    for(int i=0; i<l; i++){
        if(nums[i]<=0 || nums[i]>=l+1)
            nums[i] = l+1;
    }

    for(int i=0; i<l; i++){

        int el = Math.abs(nums[i]);

        if(el == l+1) continue;

        int seat = el-1;

        if(nums[seat]>0)
            nums[seat] *= -1;
    }

    for(int i=0; i<l; i++){
        if(nums[i]>0) return i+1;
    }

    return l+1;
}
```

TC: O(n)  
SC: O(1)

---

## 1️⃣2️⃣ Maximum Consecutive Ones

### Optimal
Count streak.

```java
public static int maxConsecutiveOnes(int arr[]){

    int result=0,count=0;

    for(int i:arr){

        if(i==1){
            count++;
            result=Math.max(result,count);
        }
        else count=0;
    }

    return result;
}
```

TC O(n), SC O(1)

---

## 1️⃣3️⃣ Element Appearing Once

### Optimal
XOR.

Reason: a^a = 0

```java
public static int occurForOnce(int arr[]) {

    int xor=0;

    for(int i:arr) xor^=i;

    return xor;
}
```

TC O(n), SC O(1)

---

## 1️⃣4️⃣ Two Sum

### Brute Force
Nested loops.

TC O(n²), SC O(1)

### Better
HashMap.

TC O(n), SC O(n)

### Optimal
Sort + Two pointers.

```java
public static int[] twoSum(int[] arr, int k){

    Arrays.sort(arr);

    int i=0, j=arr.length-1;

    while(i<=j){

        if(arr[i] + arr[j] > k) j--;

        else if (arr[i] + arr[j]<k) i++;

        else return new int[] {i,j};
    }

    return new int[] {};
}
```

---

## 1️⃣5️⃣ Sort 0s 1s 2s

### Optimal
Dutch National Flag Algorithm.

```java
public static void sort0s_1s_2s(int []arr){

    int low=0, mid=0, high= arr.length-1;

    while(mid<=high){

        if(arr[mid] ==0) {

            int temp = arr[low];
            arr[low] =arr[mid];
            arr[mid] = temp;

            low++;
            mid++;
        }

        else if(arr[mid]==1){
            mid++;
        }

        else {

            int temp =arr[mid];
            arr[mid] =arr[high];
            arr[high] = temp;

            high--;
        }
    }
}
```

TC O(n), SC O(1)

---

## 1️⃣6️⃣ Majority Element > n/2

### Optimal
Moore Voting Algorithm.

```java
public static int majority(int [] arr){

    int count=0, element=0;

    for(int i=0; i< arr.length; i++){

        if(count==0){
            count=1;
            element=arr[i];
        }

        else if(arr[i] == element) count++;

        else count--;
    }

    return element;
}
```

TC O(n), SC O(1)

---

## 1️⃣7️⃣ Majority Element > n/3

### Optimal
Modified Boyer Moore Voting.

```java
public static List<Integer> majority(int arr[]){

    int count1=0,count2=0;
    int e1=Integer.MIN_VALUE, e2=Integer.MIN_VALUE;

    for(int i:arr){

        if(count1==0 && i !=e2){
            count1=1;
            e1 = i;
        }

        else if(count2==0 && i!=e1){
            count2=1;
            e2 = i;
        }

        else if(e1 == i) count1++;

        else if(e2 == i) count2++;

        else {
            count1--;
            count2--;
        }
    }

    return new ArrayList<>();
}
```

---

## 1️⃣8️⃣ Maximum Subarray Sum (Kadane)

### Optimal
Kadane Algorithm.

```java
public static int kadaneAlgo(int [] arr){

    int currentSum=arr[0], maxSum=arr[0];

    for(int i=0; i<arr.length; i++){

        currentSum = Math.max(arr[i], currentSum+arr[i]);

        maxSum = Math.max(maxSum,currentSum);
    }

    return maxSum;
}
```

TC O(n), SC O(1)

---

## 1️⃣9️⃣ Longest Subarray with K Sum

### Optimal
Prefix Sum + HashMap.

```java
public static int kSumSubarray(int arr[],int k) {

    HashMap<Integer, Integer> mp = new HashMap<>();

    int prefixSum=0, maxlength=0;

    for(int i=0; i<arr.length; i++){

        prefixSum+=arr[i];

        if(prefixSum==k){
            maxlength = i+1;
        }

        if(mp.containsKey(prefixSum-k)){

            int prevIndex = mp.get(prefixSum-k);

            maxlength = Math.max(maxlength, i-prevIndex);
        }

        if( !mp.containsKey(prefixSum)){
            mp.put(prefixSum,i);
        }
    }

    return maxlength;
}
```

TC O(n), SC O(n)

---

## 2️⃣0️⃣ Stock Buy and Sell

### Optimal
Track minimum purchase price.

```java
public static int profit(int[] arr){

    int maxProfit=0;
    int minPurchasePrice=Integer.MAX_VALUE;

    for(int i=0; i<arr.length; i++){

        minPurchasePrice = Math.min(minPurchasePrice, arr[i]);

        maxProfit = Math.max(maxProfit, arr[i]-minPurchasePrice);
    }

    return maxProfit;
}
```

TC O(n), SC O(1)

---

## 2️⃣1️⃣ Rearrange Array by Sign

### Better
Place positive at even and negative at odd index.

```java
public static int [] seggregatePN_BETTERAPPROACH(int [] arr){

    int posIndex = 0, negIndex = 1;

    int [] result =new int [arr.length];

    for(int i=0; i< arr.length; i++){

        if(arr[i]>=0){

            result[posIndex] = arr[i];
            posIndex+=2;
        }

        else{

            result[negIndex] = arr[i];
            negIndex+=2;
        }
    }

    return result;
}
```

---

## 2️⃣2️⃣ Leaders in Array

### Optimal
Traverse from right.

```java
public static ArrayList<Integer> leader(int[] arr){

    ArrayList<Integer> result = new ArrayList<>();

    int maxTillNow=Integer.MIN_VALUE;

    for(int i=arr.length-1; i>=0; i--){

        if(arr[i]>maxTillNow){

            result.add(arr[i]);
            maxTillNow = arr[i];
        }
    }

    Collections.reverse(result);

    return result;
}
```

---

## 2️⃣3️⃣ Longest Consecutive Sequence

### Optimal
HashSet.

```java
public static int longestSequence(int [] arr){

    if(arr.length == 0) return 0;

    int longest = 1;

    Set<Integer> set =
        Arrays.stream(arr).boxed().collect(Collectors.toSet());

    for(int i:set){

        if(! set.contains(i-1)){

            int count = 1;
            int x = i;

            while(set.contains(x+1)){
                x +=1;
                count+=1;
            }

            longest = Math.max(longest, count);
        }
    }

    return longest;
}
```

TC O(n), SC O(n)

---

## 2️⃣4️⃣ Set Matrix Zero

### Optimal
Use first row and first column as markers.

```java
public static void setMatrix(int arr[][], int n, int m){

    boolean row0 = false;
    boolean col0 = false;

    for(int i=1; i<n;i++){

        for(int j=1; j<m; j++){

            if(arr[i][j] == 0){

                arr[i][0] = 0;
                arr[0][j] = 0;
            }
        }
    }
}
```

TC O(n*m), SC O(1)

---

## 2️⃣5️⃣ Rotate Matrix by 90 Degree

### Optimal
Transpose + Reverse rows.

```java
public static void rotate(int arr[][]){

    for(int i=0;i< arr.length; i++){

        for(int j=i; j<arr[0].length; j++){

            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }

    for(int i=0; i<arr.length;i++){

        for(int j=0; j<arr[0].length/2; j++){

            int temp = arr[i][j];
            arr[i][j] = arr[i][arr.length-1-j];
            arr[i][arr.length-1-j] = temp;
        }
    }
}
```

TC O(n*m), SC O(1)

---

# 🧠 Universal Tips

- sorted arrays → two pointers
- subarray sum → prefix sum
- single unique → XOR
- majority element → Moore voting
- rotate array → reversal
- matrix inplace → markers / transpose

---

# 🚀 Interview Checklist

✔ duplicates?  
✔ sorted?  
✔ negative values?  
✔ can modify array?  
✔ extra space?  
✔ overflow possible?  
✔ hashing allowed?
