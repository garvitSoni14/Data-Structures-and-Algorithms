___________📘 DSA Arrays
---


## <img src="https://img.shields.io/badge/1. Largest_Element_in_an_Array-28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array me sabse bada element (`max`) find karna.

```text
Input:  arr[] = {2, 5, 1, 3, 0}
Output: 5
```

---


#### ❌ Brute Force Approach
* **Concept:** Array ko **ascending order** me sort karo. Jo last index (`n-1`) par element hoga, wahi sabse bada hoga.
* **Why?** Sorting ke baad values hamesha increasing order me chali jaati hain.



TC $O(n \log n)$,  &emsp;  SC Depends on sorting algorithm

---

#### 🚀 Optimal Approach (Single Pass)
* **Concept:** Ek `max` variable maintain karo aur pure array ko ek baar traverse karo. Agar koi element `max` se bada milta hai, toh `max` ko update kar do.

> 
> **Pseudocode**
> ```text
> max = arr[0]
> for each element in array:
>    if element > max:
>       max = element
> return max
> ```
### Code
```java
public static int largestElement(int arr[]) {
    if (arr.length == 1) return arr[0];

    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}
```

TC O(n) &emsp;  SC O(1) 

---

## <img src="https://img.shields.io/badge/2. Second Largest_Element_in_an_Array-28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array me second sabse bada element (`max`) find karna.

```text
Input:  arr[] = {2, 5, 1, 3, 0}
Output: 3
```

---


#### ❌ Brute Force Approach
* **Concept:** Array ko **ascending order** me sort karo. Jo last-second index (`n-2`) par element hoga, wahi sabse bada hoga.
* **Why?** Sorting ke baad values hamesha increasing order me chali jaati hain.



TC $O(n \log n)$,  &emsp;  SC Depends on sorting algorithm$

---

#### 🚀 Optimal Approach (Single Pass)
* **Concept:** Do variables maintain karo: `l` (largest) aur `sl` (second largest). Pure array ko ek baar traverse karo. Agar current element `l` se bada hai, toh purana `l` ab `sl` ban jayega, aur `l`update hoga. Agar element `l` se chhota hai par `sl` se bada hai, toh sirf `sl` update hoga.

>
> **Pseudocode**
> ```text
> l = MIN_VALUE, sl = MIN_VALUE
> for each element in array:
> if element > l:
> sl = l
> l = element
> else if element > sl AND element != l:
> sl = element
> return sl
> ```
### Code
```java
public static int secondLargestElement(int arr[]) {
    if (arr.length < 2) return -1;

    int l = Integer.MIN_VALUE;
    int sl = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > l) {
            sl = l;
            l = arr[i];
        } else if (arr[i] > sl && arr[i] != l) {
            sl = arr[i];
        }
    }
    return (sl == Integer.MIN_VALUE) ? -1 : sl;
}
```

TC O(n) &emsp;  SC O(1)

---


## <img src="https://img.shields.io/badge/3. If Array Sorted -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array elements ascending order me he ya nhi .

```text
Input:  arr[] = {1,2,3,5,7,8,99}
Output: True
```

---


#### ❌ Brute Force Approach
* **Concept:** Array ke har ek element ke liye, uske right side waale saare elements ko check karo aur compare karo.
* **Why?** Agar kisi bhi element ke baad usse chhota element milta hai, toh sorted order break ho jaata hai.



TC O(n²),  &emsp;  SC O(1)

---

#### 🚀 Optimal Approach (Single Pass)
* **Concept:** Pure array me linearly travel karo aur sirf adjacent (aaju-baaju waale) elements ko compare karo. Agar kabhi bhi `arr[i] > arr[i+1]` milta hai, toh array sorted nahi hai.

>
> **Pseudocode**
> ```text
> for i from 0 to n-2:
>      if arr[i] > arr[i+1]:
>           return false
> return true
> ```
### Code
```java
public static boolean ifArraySorted(int arr[]) {
    for (int i = 0; i <= arr.length - 2; i++) {
        if (arr[i] > arr[i + 1]) {
            return false;
        }
    }
    return true;
}
```

TC O(n) &emsp;  SC O(1)

---


## <img src="https://img.shields.io/badge/4. Remove duplicate from sorted Array -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Sorted array me se saare duplicate elements ko remove karke unique elements ko shuruat me arrange karna.

```text
Input:  arr[] = {1,1,2,2,2,3,3}
Output: [1,2,3,_,_,_,_]
```

---


#### ❌ Brute Force Approach
* **Concept:** Ek HashSet ka use karo. Array ke saare elements ko set me daal do kyunki set duplicates allow nahi karta. Phir unhe wapas array me copy kar do.
* **Why?** Hashing unique elements ko collect karne ka sabse aasan tarika hai, par ye extra space leta hai.


TC O(n),  &emsp;  SC O(n)

---

#### 🚀 Optimal Approach (Two Pointers)
* **Concept:** Do pointers ka use karo (`i` aur `j`). `j` ko shuruat me fix rakho aur `i` se aage scan karo. Jab bhi koi naya element mile `(arr[j] != arr[i])`, `j` ko aage badhao aur waha naya element copy kar do.

>
> **Pseudocode**
> ```text
> j = 0
> for i from 1 to n-1:
>      if arr[j] != arr[i]:
>           j += 1
>           arr[j] = arr[i]
> return arr up to index j+1
> ```
### Code
```java
public static int[] removeDuplicatedFromSorted(int arr[]) {
    int j = 0;
    for (int i = 1; i < arr.length; i++) {
        if (arr[j] != arr[i]) {
            arr[++j] = arr[i];
        }
    }
    return Arrays.copyOfRange(arr, 0, j + 1);
}
```

TC O(n) &emsp;  SC O(1)

---

## <img src="https://img.shields.io/badge/5. Left rotate by one -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array ke saare elements ko ek position left me shift karna, aur pehle element ko khinch kar aakhri position par daalna.
```text

```text
Input:  arr[] = {1, 2, 3, 4, 5}
Output: {2, 3, 4, 5, 1}
```

---


#### ❌ Brute Force Approach
* **Concept:** Create a dummy array, put all elements of original array from `[1]` to `[last]` into dummy array. Then put the first `[0]th` element of origina array on the last index of dummy array.
* **Why?** By this first element of original array will be at the last..



TC O(n),  &emsp;  SC O(n)

---

#### 🚀 Optimal Approach (Single Pass)
* **Concept:** Ek `max` variable maintain karo aur pure array ko ek baar traverse karo. Agar koi element `max` se bada milta hai, toh `max` ko update kar do.

>
> **Pseudocode**
> ```text
> max = arr[0]
> for each element in array:
>    if element > max:
>       max = element
> return max
> ```
### Code
```java
public static int largestElement(int arr[]) {
    if (arr.length == 1) return arr[0];

    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}
```

TC O(n) &emsp;  SC O(1)

---

## <img src="https://img.shields.io/badge/6. Left rotate by K -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array ke saare elements ko K position left me shift karna, aur pehle K elements ko khinch kar aakhri position par daalna.


```text
Input:  arr[] = {1, 2, 3, 4, 5, 6, 7}, k = 2
Output: {3, 4, 5, 6, 7, 1, 2}
```

---


#### ❌ Brute Force Approach
* **Concept:** Create a dummy array, put all elements of original array from `[0]` to `[k-1]` into dummy array. Then shift the remaining elements of original array from `[k]` to `[0]`, and then place the elements of dummy array into the last of original array.
* **Why?** By this first `0 to k-1` element of original array will be at the last..



TC O(n),  &emsp;  SC O(k)

---

#### 🚀 Optimal Approach (Reversal Algorithm)
* **Concept:** Pehle k elements ko reverse karo.
Bache hue (n-k) elements ko reverse karo.
Pure ke pure array ko ek aur baar reverse kar do.
(Pehle k = k % n kar lena chahiye taaki agar k array size se bada ho, toh extra rotations skip ho sakein).

>
> **Pseudocode**
> ```text
> k = k % n    // if k > array size, shink it.
> reverse(arr, 0, k-1)
> reverse(arr, k, n-1)
> reverse(arr, 0, n-1)
> ```
### Code
```java
public static void leftRotateByk(int arr[], int k) {
    int n = arr.length;
    if (n == 0) return;
    k = k % n; // Handling edge case if k > n

    reverseArray(arr, 0, k - 1);
    reverseArray(arr, k, n - 1);
    reverseArray(arr, 0, n - 1);
}

 public static void reverseArray(int arr[], int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++ ;
            end--;
        }
    }
```

TC O(n) &emsp;  SC O(1)

---

## <img src="https://img.shields.io/badge/7. Move Zeroes to end -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array ke saare zeroes (`0`) ko last me shift karna bina non-zero elements ka relative order change kiye.


```text
Input:  arr[] = {1, 0, 2, 3, 0, 4, 0, 1}
Output: {1, 2, 3, 4, 1, 0, 0, 0}
```

---


#### ❌ Brute Force Approach
* **Concept:** Ek temporary array banao. Pure main array ko traverse karke saare non-zero elements ko temp array me copy kar lo. Phir bachi hui jagah par zeroes bhar do aur elements ko wapas original array me daal do.
* **Why?** Non-zero elements ke order ko maintain karne ka yeh sabse seedha tarika hai, par isme extra linear space lagti hai.

TC O(n),  &emsp;  SC O(n)

---

#### 🚀 Optimal Approach (Two Pointers)
* **Concept:** Do pointers ka use karo (i and j). i hamesha pehle zero element par rukne ki koshish karega (ya track rakhega ki naya non-zero element kaha swap hona hai) aur j poore array ko scan karega. Jab bhi j ko koi non-zero element milega, hum use i ke saath swap kar denge aur i ko aage badha denge.

>
> **Pseudocode**
> ```text
>i = 0, j = 0
> while j < array_length:
>     if arr[j] != 0:
>         if i != j:
>             swap(arr[i], arr[j])
>         i += 1
>     j += 1
> ```
### Code
```java

public static void moveZeroesToEnd(int[] arr) {
    int i = 0, j = 0;

    while (j < arr.length) {
        if (arr[j] != 0) {
            if (i != j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
            i++;
        }
        j++;
    }
}
```

TC O(n) &emsp;  SC O(1)

---

## <img src="https://img.shields.io/badge/8. Linear Search -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array ke saare zeroes (`0`) ko last me shift karna bina non-zero elements ka relative order change kiye.


```text
Input:  arr[] = {8, 4, 1, 9, 4} , k = 4
Output: 1
```

---

#### 🚀 Only Approach (Sequential Scan)


>
> **Pseudocode**
> ```text
> for i from 0 to n-1:
>     if arr[i] == k:
>         return i
> return -1
> ```

### Code
```java

public static int linearSearch(int arr[], int k) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == k) {
            return i;
        }
    }
    return -1;
}
```

TC O(n) &emsp;  SC O(1)

---

## <img src="https://img.shields.io/badge/9. Union of 2 Sorted Arrays -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Do sorted arrays ke saare unique elements ko mila kar ek single sorted list (Union) banana.

```text
Input:  arr_1[] = {1, 2, 2, 4, 6, 6}, arr_2[] = {2, 4, 7, 8}
Output: res[] = {1, 2, 4, 6, 7, 8}
```

---


#### ❌ Brute Force Approach
* **Concept:** Ek HashSet ya TreeSet ka use karo. Dono arrays ke saare elements ko set me insert kar do. Kyunki set duplicates allow nahi karta, hume saare unique elements mil jayenge. Phir unhe list me copy kar lo.
* **Why?** Hashing se duplicates handle karna aasan hota hai, par ye unique elements store karne ke liye extra space leta hai.



TC O((n+m)log(n+m))   &emsp;  SC O(n+m)

---

#### 🚀 Optimal Approach (Single Pass)
* **Concept:** Do pointers ka use karo (i for array a aur j for array b). Dono arrays sorted hain, toh jo element chhota hoga use hum union list me daalenge (sirf tab jab wo list ke aakhri element ke barabar na ho, taaki duplicates avoid hon) aur us pointer ko aage badha denge.

> 
> **Pseudocode**
> ```text
> i = 0, j = 0
> while i < a.length AND j < b.length:
>     if a[i] <= b[j]:
>         if union is empty OR last_element != a[i]: add a[i]
>          i++
>     else:
>         if union is empty OR last_element != b[j]: add b[j]
>         j++
> // Remaining elements ko check karke add karo (cleanup loops)
> ```
### Code
```java
import java.util.ArrayList;
import java.util.List;

public static List<Integer> Union(int a[], int b[]) {
    ArrayList<Integer> union = new ArrayList<>();
    int i = 0, j = 0;

    // Both arrays traverse karne ke liye
    while (i < a.length && j < b.length) {
        if (a[i] <= b[j]) {
            if (union.isEmpty() || union.get(union.size() - 1) != a[i]) {
                union.add(a[i]);
            }
            i++;
        } else {
            if (union.isEmpty() || union.get(union.size() - 1) != b[j]) {
                union.add(b[j]);
            }
            j++;
        }
    }

    // Agar array 'a' me elements bache hain
    while (i < a.length) {
        if (union.isEmpty() || union.get(union.size() - 1) != a[i]) {
            union.add(a[i]);
        }
        i++;
    }

    // Agar array 'b' me elements bache hain
    while (j < b.length) {
        if (union.isEmpty() || union.get(union.size() - 1) != b[j]) {
            union.add(b[j]);
        }
        j++;
    }

    return union;
}
```

TC O(n) &emsp;  SC O(1) 

---

## <img src="https://img.shields.io/badge/10. Find Missing Number -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> $1$ se lekar $n$ tak ke numbers waale array me ek number duplicate (repeating) hai aur ek number missing hai. Dono ko find karna.

```text
Input:  arr[] = {3, 1, 2, 5, 3} 
Output: Repeating = 3, Missing = 4
```

---


#### ❌ Brute Force Approach
* **Concept:** $1$ se lekar $n$ tak ke har ek number ko array me manually linear search karke uski frequency count karo. Jiski 0 aayegi wo missing hai.
* **Why?** 2 nested loops lagte hain jiski wajah se time complexity bohot zyada badh jaati hai.

TC O(n²)   &emsp;  SC O(1)

---

#### ⚡ Better Approach
* **Concept:** Ek frequency array (ya hash table) banao size n+1 ka. Pure array ko traverse karke elements ki count store kar lo, phir frequency table me check karo kiski value 0 aur kiski 2 hai.
* **Why?** Linear time me kaam ho jaata hai, par extra space memory me allocate karni padti hai.



TC O(n)   &emsp;  SC O(n)

---

#### 🚀 Optimal Approach (Mathematical Equations)
* **Concept:** Maths ke sum formulas ka use karo.
 $\text{Sum of first } n \text{ numbers } (S_n) = \frac{n(n+1)}{2} $ $\text{Sum of squares of first } n \text{ numbers } (S_{2n}) = \frac{n(n+1)(2n+1)}{6}$
* Array ke actual sum ($S$) aur actual square sum ($S_2$) ko nikal kar hum do linear equations banate hain:
 $\text{val1} = X - Y$ (where $X$ is Repeating, $Y$ is Missing)
 $\text{val2} = X^2 - Y^2$
* Inhe solve karke bina kisi extra space ke linear time me answer mil jata hai.

> 
> **Pseudocode**
> ```text
> i = 0, j = 0
>Sn = (n * (n + 1)) / 2
> S2n = (n * (n + 1) * (2 * n + 1)) / 6
> Find actual sum (s) and actual square sum (s2) of array
> val1 = s - Sn      // X - Y
> val2 = s2 - S2n    // X^2 - Y^2
> val2 = val2 / val1 // X + Y
> X = (val1 + val2) / 2
> Y = X - val1
> return {X, Y}
> ```
### Code
```java
public static int[] findMissingRepeating(int[] nums) {
    long n = nums.length;

    // Standard mathematical formulas
    long Sn = (n * (n + 1)) / 2;
    long S2n = (n * (n + 1) * (2 * n + 1)) / 6;

    long s = 0, s2 = 0;
    for (int i = 0; i < n; i++) {
        s += (long) nums[i];
        s2 += (long) nums[i] * (long) nums[i]; // Prevents overflow during multiplication
    }

    // Equation 1: X - Y
    long val1 = s - Sn;
    
    // Equation 2: X^2 - Y^2
    long val2 = s2 - S2n;

    // (X^2 - Y^2) / (X - Y) => X + Y
    val2 = val2 / val1;

    // Solving the linear equations
    long x = (val1 + val2) / 2; // Repeating Number
    long y = x - val1;          // Missing Number

    return new int[]{(int) x, (int) y};
}
```

TC O(n) &emsp;  SC O(1) 

---

## <img src="https://img.shields.io/badge/11. Length of Maximum Consecutive Ones -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Sabse badi subarray jisme consecutively 11...1 ho.

```text
Input:  arr[] = {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1} 
Output: 5
```

---


#### ❌ Brute Force Approach
* **Concept:** Har possible subarray reate kro or usme `count` of 1 dekho agr `maxCount` se badhaa ho to `maxCount` ko update kr do.
* **Why?** 2 nested loops lagte hain jiski wajah se time complexity bohot zyada badh jaati hai.

TC O(n²)   &emsp;  SC O(1)

---

#### 🚀 Optimal Approach (Single Pass)
* **Concept:** Ek `count` variable maintain karo jo current streak ko track kare, aur ek `result` variable jo ab tak ki maximum streak ko store kare. Pure array par loop lagao; agar element 1 hai toh `count` badhao aur use `result` ke sath update karo. Agar element 0 aata hai, toh streak tut jayegi, isliye `count` ko reset karke 0 kar do.

> 
> **Pseudocode**
> ```text
> result = 0, count = 0
> for each element in array:
>     if element == 1:
>         count++
>         result = max(result, count)
>     else:
>         count = 0
> return result
> ```
### Code
```java
public static int maxConsecutiveOnes(int arr[]) {
    int result = 0, count = 0;

    for (int i : arr) {
        if (i == 1) {
            count++;
            result = Math.max(result, count);
        } else {
            count = 0;
        }
    }
    return result;
}
```

TC O(n) &emsp;  SC O(1) 

---

## <img src="https://img.shields.io/badge/12. Find the Element that Appears Once -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array me har ek element do baar (twice) aata hai, siwaye ek element ke jo sirf ek baar (once) aata hai. Us single element ko dhoondna.

```text
Input:  arr[] = {4, 1, 2, 1, 2}
Output: 4
```

---


#### ❌ Brute Force Approach
* **Concept:** Do nested loops lagao. Outer loop se ek element pick karo aur inner loop se poore array me uski occurrence count karo. Agar kisi element ki count 1 milti hai, toh wahi hamara answer hai.
* **Why?** Har element ke liye poore array ko scan karne se time complexity quadratic ho jaati hai.


TC O(n²)   &emsp;  SC O(1)

---

#### ⚡ Better Approach
* **Concept:** Ek hashing mechanism (jaise HashMap ya frequency array) ka use karo. Pure array ko traverse karke har element ki frequency store kar lo. Phir map me iterate karke check karo ki kis element ki frequency 1 hai.
* **Why?** Linear time me unique element mil jata hai, par frequency map maintain karne ke liye extra space storage lagta hai.


TC O(n)   &emsp;  SC O(n)

---

#### 🚀 Optimal Approach (Single Pass)
* **Concept:** Bitwise XOR (^) operator ki properties ka use karo:
* A \oplus A = 0$ (Same numbers ek dusre ko cancel kar dete hain)
* A \oplus 0 = A$ (Kisi bhi number ka 0 ke sath XOR wahi number hota hai)
Pure array ke saare elements ka aapas me XOR nikal lo.
 Jo elements do baar aaye hain wo aapas me cancel hokar 0 ban jayenge, aur aakhri me sirf wahi element bachega jo ek baar aaya tha.

> 
> **Pseudocode**
> ```text
> xor_sum = 0
> for each element in array:
>     xor_sum = xor_sum ^ element
> return xor_sum
> ```
### Code
```java
public static int occurForOnce(int arr[]) {
    int xor = 0;

    for (int i : arr) {
        xor ^= i;
    }
    return xor;
}
```

TC O(n) &emsp;  SC O(1) 

---

## <img src="https://img.shields.io/badge/13. Longest Subarray length with Sum K(Positive) -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Array me wo sabse lamba contiguous subarray dhoondna jiska sum exact `k` ke barabar ho, aur uski length return karna.

```text
Input:  arr[] = {1, 2, 3, 8, 4, 1, 2, 7, 9}, k = 15
Output: 4    //(8, 4, 1, 2)
```

---


#### ❌ Brute Force Approach
* **Concept:** Three nested loops ka use karo. Pehle do loops se saare possible subarrays `(i, j)` generate karo, aur teesra loop lagakar unka sum nikal lo. Agar sum k ke barabar milta hai, toh maximum length `(j - i + 1)` update kar do.
* **Why?** Har subarray ka sum baar-baar scratch se calculate karne ki wajah se cubic time lagta hai.

TC O(n³) &emsp;  SC O(1)

---

#### ⚡ Better Approach
* **Concept:** Prefix Sum aur HashMap (PreSumMap) ka use karo. Traverse karte waat ab tak ka currentSum nikalte jao aur use map me store karo. Agar kisi point par currentSum - k map me pehle se maujood hai, iska matlab uske baad se ab tak ke elements ka sum k hai.
* **Why?** Ye approach positive aur negative dono numbers waale arrays ke liye optimal kaam karti hai.


TC O(n \log n) (with TreeMap) / O(n) (with HashMap)   &emsp;  SC O(n)

---

#### 🚀 Optimal Approach (Two Pointers / Sliding Window)
* **Concept:** Do pointers (`i` aur `j`) ka use karke ek dynamic window maintain karo. `j` ko aage badha kar `currentSum` me elements add karte jao. Agar `currentSum` target `k` se bada ho jata hai, toh peeche se `i` pointer ke elements ko tab tak subtract karte jao jab tak sum chhota ya barabar na ho jaye. Jab bhi `currentSum == k` ho, window ki max length save kar lo.
* **NOTE** Ye sliding window optimal approach tabhi kaam karti hai jab array me sirf positive numbers hon.

> 
> **Pseudocode**
> ```text
> currentSum = 0, result = 0, i = 0, j = 0
> while j < n:
>     currentSum += arr[j]
>     while i < j AND currentSum > k:
>         currentSum -= arr[i]
>         i++
>     if currentSum == k:
>         result = max(result, j - i + 1)
>     j++
> return result
> ```
### Code
```java
public static int longestSubarrayWithKSum(int arr[], int k) {
    int currentSum = 0;
    int result = 0;
    int i = 0;
    int j = 0;

    while (j < arr.length) {
        currentSum += arr[j];

        // Window ko shrink karo agar sum limit cross kar jaye
        while (i < j && currentSum > k) {
            currentSum -= arr[i];
            i++;
        }

        // Target match hone par max length update karo
        if (currentSum == k) {
            result = Math.max(j - i + 1, result);
        }
        j++;
    }
    return result;
}
```

TC O(n) &emsp;  SC O(1) 

---

## <img src="https://img.shields.io/badge/14. Longest Subarray Length with Sum 0 (+ve and neg ve) -28A745?style=for-the-badge&logoColor=white" alt="Question 1">

> Ek aise array me sabse lamba contiguous subarray dhoondna jiska sum exact `0` ho, aur uski length return karna. Array me positive aur negative dono numbers ho sakte hain.

```text
Input:  arr[] = {15, -2, 2, -8, 1, 7, 10, 23}
Output: 5    // Subarray: (-2, 2, -8, 1, 7)
```

---


#### ❌ Brute Force Approach
* **Concept:** Do nested loops ka use karke saare possible subarrays generate karo. Har subarray ka sum calculate karo, aur agar sum 0 milta hai, toh uski length `(j - i + 1)` ko max length se compare karke save kar lo.
* **Why?** Do loops use karne se time complexity quadratic ($O(n^2)$) ho jaati hai, jo bade inputs ke liye efficient nahi hai.

TC O(n²) &emsp;  SC O(1)

---

#### 🚀 Optimal Approach (Prefix Sum + HashMap)
* **Concept:** Hum traverse karte waqt running prefix sum `sum` calculate karte hain. Agar ye `sum` hume pehle bhi kisi index par mil chuka hai, iska matlab un dono indices ke beech ke elements ka sum pakka 0 hua hai! Hum ek HashMap maintain karenge jo `<Prefix_Sum, First_Seen_Index>` store karega.
* **Edge Case** Agar `sum` khud `0` ho jaye, toh iska matlab shuruat se lekar current index tak ka subarray hi answer hai, toh length `i + 1` hogi.
> 
> **Pseudocode**
> ```text
> map = empty HashMap
> sum = 0, max_len = 0
> for i from 0 to n-1:
>     sum += arr[i]
>     if sum == 0:
>         max_len = i + 1
>     else if sum exists in map:
>         max_len = max(max_len, i - map.get(sum))
>     else:
>         map.put(sum, i)
> return max_len
> ```
### Code
```java

Input:  arr[] = {15, -2, 2, -8, 1, 7, 10, 23}
Output: 5    // Subarray: (-2, 2, -8, 1, 7)

import java.util.HashMap;

public static int maxLen(int arr[]) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int max_len = 0;

    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];

        // Agar shuruat se lekar ab tak ka sum 0 ho gaya ho
        if (sum == 0) {
            max_len = i + 1;
        } else {
            // Agar ye sum pehle dekh chuke hain, toh beech ka subarray sum 0 hai
            if (map.containsKey(sum)) {
                max_len = Math.max(max_len, i - map.get(sum));
            } else {
                // Pehli baar sum dikhne par uska index store karo
                map.put(sum, i);
            }
        }
    }
    return max_len;
}
``` 

TC O(n) &emsp;  SC O(n)

---
# --------------------------------- EASY SECTION ENDS HERE

---

## <img src="https://img.shields.io/badge/16. Two_Sum-28A745?style=for-the-badge&logoColor=white" alt="Question 16">

> Array me aise do elements dhoondna jinka sum exact target `k` ke barabar ho, aur unke indices return karna.

```text
Input:  arr[] = {2, 7, 11, 15}, k = 9
Output: [0, 1]   //(Because arr[0] + arr[1] == 9)
```

---

#### ❌ Brute Force Approach
* **Concept:** Do nested loops ka use karo. Outer loop se ek element `arr[i]` pakdo aur inner loop se bache hue elements me check karo ki kya koi aisa element `arr[j]` hai jiska sum `arr[i] + arr[j] == k` ho jaye.
* **Why?** Har possible pair ko manually check karna padta hai, isliye quadratic time lagta hai.

TC O(n²) &emsp; SC O(1)

---

#### ⚡ Better Approach (Hashing)
* **Concept:** Ek `HashMap<Element, Index>` maintain karo. Array traverse karte waqt har element ke liye check karo ki `k - arr[i]` map me pehle se present hai ya nahi. Agar mil jaye to uska index aur current index return kar do. Agar na mile to current element ko map me store kar do.
* **Why?** Ye original indices preserve karta hai aur linear time me solution deta hai.

TC O(n) &emsp; SC O(n)

---

#### 🚀 Optimal Approach (Two Pointers)
* **Concept:** Array ko pehle sort karo. Phir do pointers (`i` aur `j`) use karo. Agar `arr[i] + arr[j]` target se bada hai to `j--` karo. Agar chhota hai to `i++` karo. Jab sum target ke equal ho jaye, pair mil gaya.
* **Interview Note:** Agar question sirf **YES/NO** poochta hai ki pair exist karta hai ya nahi, to ye approach **SC O(1)** ke saath best hai. Lekin agar **original indices** return karni ho, to sorting element positions change kar deti hai, isliye **HashMap approach** prefer ki jaati hai.

>
> **Pseudocode**
> ```text
> sort(arr)
> i = 0
> j = n - 1
>
> while i < j:
>     sum = arr[i] + arr[j]
>
>     if sum > k:
>         j--
>     else if sum < k:
>         i++
>     else:
>         return {i, j}
>
> return {}
> ```

### Code
```java
import java.util.Arrays;

public static int[] twoSum(int[] arr, int k) {
    Arrays.sort(arr); // Two pointers ke liye sorting zaroori hai

    int i = 0;
    int j = arr.length - 1;

    while (i < j) {
        int sum = arr[i] + arr[j];

        if (sum > k) {
            j--;
        } else if (sum < k) {
            i++;
        } else {
            return new int[] {i, j};
        }
    }
    return new int[] {};
}
```

TC O(n log n) &emsp; SC O(1)

---

## <img src="https://img.shields.io/badge/17. Sort_an_Array_of_0s,_1s,_and_2s-28A745?style=for-the-badge&logoColor=white" alt="Question 17">

> Ek array jisme sirf `0s`, `1s`, aur `2s` hain, use bina kisi built-in sorting function ke in-place sort karna.

```text
Input:  arr[] = {0, 1, 0, 2, 0, 0, 1, 2, 2, 1}
Output: {0, 0, 0, 0, 1, 1, 1, 2, 2, 2}
```

---

#### ❌ Brute Force Approach
* **Concept:** Koi bhi standard sorting algorithm (jaise Merge Sort ya Quick Sort) apply karke poore array ko sort kar do.
* **Why?** Ye generic sorting algorithm hai jo problem ki specific property (sirf `0`, `1`, aur `2`) ka fayda nahi uthata, isliye unnecessary extra time (aur kabhi-kabhi memory) consume karta hai.

TC O(n log n) &emsp; SC O(1) *(or O(n), depending on sorting algorithm)*

---

#### ⚡ Better Approach (Counting Elements)
* **Concept:** Ek pass me `count0`, `count1`, aur `count2` maintain karke teeno values ki frequency count kar lo. Phir doosre pass me pehle saare `0`, phir `1`, aur last me `2` array me fill kar do.
* **Why?** Ye simple aur linear-time solution hai, lekin array ko do baar traverse karna padta hai.

TC O(n) + O(n) = O(2n) &emsp; SC O(1)

---

#### 🚀 Optimal Approach (Dutch National Flag Algorithm)
* **Concept:** Teen pointers `low`, `mid`, aur `high` ka use karo. Puri process ke dauran array 4 parts me divide rehta hai:

  * `0` se `low - 1` → Hamesha `0` honge.
  * `low` se `mid - 1` → Hamesha `1` honge.
  * `mid` se `high` → Unsorted elements (jinhe process karna baaki hai).
  * `high + 1` se `n - 1` → Hamesha `2` honge.

  `mid` pointer se traversal shuru hota hai:
  * Agar `arr[mid] == 0` ho → `low` aur `mid` swap karo, phir `low++` aur `mid++`.
  * Agar `arr[mid] == 1` ho → Sirf `mid++`.
  * Agar `arr[mid] == 2` ho → `mid` aur `high` swap karo, phir `high--`. **Mid ko increment nahi karte**, kyunki swapped element abhi check karna baaki hai.

>
> **Pseudocode**
> ```text
> low = 0
> mid = 0
> high = n - 1
>
> while mid <= high:
>     if arr[mid] == 0:
>         swap(arr[low], arr[mid])
>         low++
>         mid++
>
>     else if arr[mid] == 1:
>         mid++
>
>     else:
>         swap(arr[mid], arr[high])
>         high--
> ```

### Code
```java
public static void sort0s_1s_2s(int[] arr) {
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;

    while (mid <= high) {
        if (arr[mid] == 0) {
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
            low++;
            mid++;
        } else if (arr[mid] == 1) {
            mid++;
        } else { // Element is 2
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
            high--;
        }
    }
}
```

TC O(n) &emsp; SC O(1)

---

## <img src="https://img.shields.io/badge/18. Majority_Element_(Greater_than_N/_2)-28A745?style=for-the-badge&logoColor=white" alt="Question 18">

> Array me wo element find karna jo $\frac{n}{2}$ se zyada baar (majority times) aata hai. Agar koi aisa element nahi hai, toh `-1` return karna.

```text
Input:  arr[] = {3, 2, 3, 3}
Output: 3   //(Size n = 4, count of 3 is 3, which is greater than 4/2)
```

---

#### ❌ Brute Force Approach
* **Concept:** Array ke har ek element ko select karo aur ek inner loop chala kar poore array me uski frequency count karo. Agar kisi element ki frequency `n/2` se zyada ho jaye, wahi majority element hai.
* **Why?** Har element ke liye poora array dobara traverse karna padta hai, isliye quadratic time lagta hai.

TC O(n²) &emsp; SC O(1)

---

#### ⚡ Better Approach (Hashing)
* **Concept:** Ek `HashMap<Element, Frequency>` maintain karo. Array traverse karte waqt har element ki frequency update karte jao. Agar kisi element ki frequency `n/2` se zyada ho jaye, use return kar do.
* **Why?** Frequency counting ki wajah se linear time me answer mil jata hai, lekin extra space use hoti hai.

TC O(n) &emsp; SC O(n)

---

#### 🚀 Optimal Approach (Boyer-Moore Voting Algorithm)
* **Concept:** Ye algorithm is principle par kaam karta hai ki agar koi element `n/2` se zyada baar aata hai, to woh baaki sab elements ke votes ko cancel karke last me candidate ban hi jayega.

  Do variables maintain karte hain:
  * `element` → Current candidate
  * `count` → Candidate ke votes

  Array traverse karte waqt:
  * Agar `count == 0` ho, to current element ko naya candidate bana do aur `count = 1`.
  * Agar current element candidate ke equal ho, to `count++`.
  * Warna `count--`.

  Traversal ke baad ek **verification pass** zaroor lagao taaki confirm ho sake ki candidate waqai `n/2` se zyada baar present hai.

>
> **Pseudocode**
> ```text
> count = 0
> element = 0
>
> for each item in array:
>     if count == 0:
>         element = item
>         count = 1
>     else if item == element:
>         count++
>     else:
>         count--
>
> // Verification Step
> actualCount = frequency of element
>
> if actualCount > n / 2:
>     return element
>
> return -1
> ```

### Code
```java
public static int majority(int[] arr) {
    int count = 0;
    int element = 0;

    // Phase 1: Finding majority candidate
    for (int i = 0; i < arr.length; i++) {
        if (count == 0) {
            element = arr[i];
            count = 1;
        } else if (arr[i] == element) {
            count++;
        } else {
            count--;
        }
    }

    // Phase 2: Verification
    int actualCount = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == element) {
            actualCount++;
        }
    }

    if (actualCount > arr.length / 2) {
        return element;
    }

    return -1;
}
```

TC O(n) &emsp; SC O(1)

---

## <img src="https://img.shields.io/badge/19. Maximum_Subarray_Sum_(Kadane's_Algorithm)-28A745?style=for-the-badge&logoColor=white" alt="Question 19">

> Array ka maximum possible contiguous subarray sum find karna.

```text
Input:  arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
Output: 6   //(Subarray: {4, -1, 2, 1})
```

---

#### ❌ Brute Force Approach
* **Concept:** Teen nested loops ka use karo. Pehle do loops se saare possible subarrays `(i, j)` ki boundary set karo, aur teesra loop lagakar unke elements ka total sum nikal lo. Har baar `maxSum` ko maximum value se update karte jao.
* **Why?** Har unique subarray ka sum har baar scratch se calculate karna padta hai, isliye complexity cubic ho jaati hai.

TC O(n³) &emsp; SC O(1)

---

#### ⚡ Better Approach
* **Concept:** Do nested loops ka use karo. Outer loop `i` start position fix karega aur inner loop `j` aage badhte hue pichle sum me hi naya element `arr[j]` add karta chalega (`currentSum += arr[j]`). Isse teesre loop ki zaroorat nahi padti.
* **Why?** Pehle se calculate kiye hue sum ko reuse karne ki wajah se ek loop bach jata hai aur complexity quadratic ho jaati hai.

TC O(n²) &emsp; SC O(1)

---

#### 🚀 Optimal Approach (Kadane's Algorithm)
* **Concept:** Pure array par sirf ek baar iterate karo. Har index par do choices hoti hain:
  * Pichle subarray ko current element ke saath continue karo.
  * Ya phir current element se naya subarray start karo.

  Is decision ko is formula se represent karte hain:

  `currentSum = max(arr[i], currentSum + arr[i])`

  Har step par `maxSum` ko update karte jao.

>
> **Pseudocode**
> ```text
> currentSum = arr[0]
> maxSum = arr[0]
>
> for i from 1 to n-1:
>     currentSum = max(arr[i], currentSum + arr[i])
>     maxSum = max(maxSum, currentSum)
>
> return maxSum
> ```

### Code
```java
public static int kadaneAlgo(int[] arr) {
    if (arr.length == 0) return 0;

    int currentSum = arr[0];
    int maxSum = arr[0];

    for (int i = 1; i < arr.length; i++) {

        // Decide: Extend previous subarray OR start a new one
        currentSum = Math.max(arr[i], currentSum + arr[i]);

        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
}
```

TC O(n) &emsp; SC O(1)

---

## <img src="https://img.shields.io/badge/20. Print_Subarray_with_Maximum_Sum-28A745?style=for-the-badge&logoColor=white" alt="Question 20">

> Maximum Subarray Sum nikalne ke saath-saath, us sum ko dene waale actual continuous subarray portion ko print ya return karna.

```text
Input:  arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
Output: [4, -1, 2, 1]   //(This subarray gives the maximum sum of 6)
```

---

#### ❌ Brute Force Approach
* **Concept:** Three nested loops ka use karke saare possible subarrays generate karo aur unka sum nikalte jao. Jab bhi ab tak ka sabse bada sum mile, uski starting boundary `i` aur ending boundary `j` ko track kar lo aur aakhri me wahi subarray return karo.
* **Why?** Har subarray ka sum baar-baar scratch se calculate karna padta hai, isliye execution time cubic ho jata hai.

TC O(n³) &emsp; SC O(1)

---

#### ⚡ Better Approach
* **Concept:** Do nested loops ka use karo jisme inner loop `j` aage badhte waqt pichle running sum me hi naye elements add karta jaye (`currentSum += arr[j]`). Jab bhi `currentSum > maxSum` ho, `start = i` aur `end = j` update kar do.
* **Why?** Running sum reuse karne ki wajah se ek loop bach jata hai aur algorithm quadratic time me chalne lagta hai.

TC O(n²) &emsp; SC O(1)

---

#### 🚀 Optimal Approach (Modified Kadane's Algorithm)
* **Concept:** Kadane's Algorithm ke saath indices bhi track karo.

  * `tempStart` → Current candidate subarray ka starting index.
  * `start` aur `end` → Final answer ke indices.

  Agar `currentSum + arr[i] < arr[i]` ho, to iska matlab naya subarray shuru karna zyada beneficial hai. Isliye `currentSum = arr[i]` aur `tempStart = i`.

  Jab bhi `currentSum > maxSum` ho, `maxSum` ke saath final `start = tempStart` aur `end = i` bhi update kar do.

>
> **Pseudocode**
> ```text
> maxSum = arr[0]
> currentSum = arr[0]
>
> start = 0
> end = 0
> tempStart = 0
>
> for i from 1 to n-1:
>
>     if currentSum + arr[i] < arr[i]:
>         currentSum = arr[i]
>         tempStart = i
>     else:
>         currentSum += arr[i]
>
>     if currentSum > maxSum:
>         maxSum = currentSum
>         start = tempStart
>         end = i
>
> return array from start to end
> ```

### Code
```java
import java.util.Arrays;

public static int[] maxSumSubarray(int[] arr) {
    int maxSum = arr[0];
    int currentSum = arr[0];

    int start = 0;
    int end = 0;
    int tempStart = 0;

    for (int i = 1; i < arr.length; i++) {

        // Naya subarray shuru karna better hai
        if (currentSum + arr[i] < arr[i]) {
            currentSum = arr[i];
            tempStart = i;
        } else {
            currentSum += arr[i];
        }

        // Maximum sum aur uske indices update karo
        if (currentSum > maxSum) {
            maxSum = currentSum;
            start = tempStart;
            end = i;
        }
    }

    // end + 1 exclusive hota hai
    return Arrays.copyOfRange(arr, start, end + 1);
}
```

TC O(n) &emsp; SC O(1) *(Tracking logic only; output array ki space ignore ki gayi hai.)*

---

## <img src="https://img.shields.io/badge/21. Best_Time_to_Buy_and_Sell_Stock-28A745?style=for-the-badge&logoColor=white" alt="Question 21">

> Ek stock prices ka array diya hai jahan `arr[i]` ith day ki price represent karta hai. Sirf **ek baar buy** aur **ek baar sell** karke maximum possible profit return karna. Agar profit possible na ho, toh `0` return karna.

```text
Input:  arr[] = {7, 1, 5, 3, 6, 4}
Output: 5   //(Buy at 1 and Sell at 6)
```

---

#### ❌ Brute Force Approach
* **Concept:** Do nested loops ka use karo. Outer loop har din ko buying day (`i`) maanega aur inner loop uske baad ke saare days (`j`) ko selling day maan kar profit `arr[j] - arr[i]` calculate karega. Har valid transaction ke liye maximum profit update karte jao.
* **Why?** Har possible buy-sell pair ko manually check karna padta hai, isliye quadratic time lagta hai.

TC O(n²) &emsp; SC O(1)

---

#### 🚀 Optimal Approach
* **Concept:** Array ko sirf ek baar traverse karo. Ek variable `minPurchasePrice` maintain karo jo ab tak ki minimum stock price (best buying price) store karega. Har naye element par current profit `arr[i] - minPurchasePrice` calculate karo aur `maxProfit` update karte jao. Saath hi `minPurchasePrice` ko bhi update karte raho.
* **Why?** Har element par best buying price pehle se available hoti hai, isliye sirf ek traversal me maximum profit mil jata hai.

>
> **Pseudocode**
> ```text
> minPurchasePrice = ∞
> maxProfit = 0
>
> for each price in array:
>     minPurchasePrice = min(minPurchasePrice, price)
>     maxProfit = max(maxProfit, price - minPurchasePrice)
>
> return maxProfit
> ```

### Code
```java
public static int profit(int[] arr) {
    int maxProfit = 0;
    int minPurchasePrice = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {

        // Ab tak ki minimum buying price update karo
        minPurchasePrice = Math.min(minPurchasePrice, arr[i]);

        // Current day par sell karke maximum profit update karo
        maxProfit = Math.max(maxProfit, arr[i] - minPurchasePrice);
    }

    return maxProfit;
}
```

TC O(n) &emsp; SC O(1)

---

## <img src="https://img.shields.io/badge/22. Rearrange_Array_Elements_by_Sign-28A745?style=for-the-badge&logoColor=white" alt="Question 22">

> Ek array diya hai jisme **positive** aur **negative** elements ki sankhya barabar hai. Array ko is tarah rearrange karna hai ki positive aur negative elements alternate positions par aayein, aur unka relative order bhi preserve rahe.

```text
Input:  arr[] = {1, 2, -4, -5}
Output: {1, -4, 2, -5}
```

---

#### ❌ Brute Force Approach
* **Concept:** Positive aur negative elements ko pehle do alag arrays (`pos[]` aur `neg[]`) me store karo. Uske baad ek naya result array banao aur usme alternate positions par pehle positive, phir negative elements fill kar do.
* **Why?** Pehle elements ko separate karna aur phir unhe merge karna padta hai, isliye extra arrays ki zaroorat hoti hai.

TC O(2n) &emsp; SC O(2n)

---

#### ⚡ Better Approach
* **Concept:** Ek hi result array banao. Do indices maintain karo:
  * `posIndex = 0` → Even positions (0, 2, 4, ...)
  * `negIndex = 1` → Odd positions (1, 3, 5, ...)

  Array ko ek baar traverse karo. Positive element mile to `posIndex` par rakho aur `posIndex += 2` karo. Negative element mile to `negIndex` par rakho aur `negIndex += 2` karo.
* **Why?** Positive aur negative elements ko directly unki final positions par place kar dete hain, isliye separate arrays ki zaroorat nahi padti.

TC O(n) &emsp; SC O(n)

---

### Code
```java
public static int[] seggregatePN_BETTERAPPROACH(int[] arr) {
    int posIndex = 0;
    int negIndex = 1;

    int[] result = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {

        if (arr[i] >= 0) {
            result[posIndex] = arr[i];
            posIndex += 2;
        } else {
            result[negIndex] = arr[i];
            negIndex += 2;
        }
    }

    return result;
}
```

TC O(n) &emsp; SC O(n)

> **Note:** Ye approach tabhi kaam karti hai jab **positive aur negative elements ki count equal ho**, aur answer ko store karne ke liye extra result array allowed ho.

---

## <img src="https://img.shields.io/badge/23. Leaders_in_an_Array-28A745?style=for-the-badge&logoColor=white" alt="Question 23">

> Array me aise saare **leader elements** find karna jo apne **right side ke har element se bade** hon. Rightmost element hamesha leader hota hai.

```text
Input:  arr[] = {10, 22, 12, 3, 0, 6}
Output: {22, 12, 6}
```

---

#### ❌ Brute Force Approach
* **Concept:** Har element ke liye uske right side ke saare elements check karo. Agar current element se bada koi bhi element nahi milta, to current element leader hai aur use result me add kar do.
* **Why?** Har element ke liye poora right part traverse karna padta hai, isliye quadratic time lagta hai.

TC O(n²) &emsp; SC O(n)

---

#### 🚀 Optimal Approach
* **Concept:** Array ko **right se left** traverse karo. Ek variable `maxTillNow` maintain karo jo ab tak ka sabse bada element store karega. Agar current element `maxTillNow` se bada ho, to wahi leader hai. Use result me add karo aur `maxTillNow` update kar do. Kyunki leaders reverse order me store hote hain, end me result ko reverse kar do.
* **Why?** Right side ka maximum ek hi variable me maintain karne se sirf ek traversal me saare leaders mil jaate hain.

>
> **Pseudocode**
> ```text
> maxTillNow = -∞
> result = []
>
> for i from n-1 to 0:
>     if arr[i] > maxTillNow:
>         add arr[i] to result
>         maxTillNow = arr[i]
>
> reverse(result)
> return result
> ```

### Code
```java
import java.util.ArrayList;
import java.util.Collections;

public static ArrayList<Integer> leader(int[] arr) {

    ArrayList<Integer> result = new ArrayList<>();
    int maxTillNow = Integer.MIN_VALUE;

    for (int i = arr.length - 1; i >= 0; i--) {

        if (arr[i] > maxTillNow) {
            result.add(arr[i]);
            maxTillNow = arr[i];
        }
    }

    // Leaders reverse order me store hue hain
    Collections.reverse(result);

    return result;
}
```

TC O(n) &emsp; SC O(n)

> **Note:** Result ko reverse karna zaroori hai kyunki traversal right se left hota hai, jabki output original left-to-right order me chahiye.

---

## <img src="https://img.shields.io/badge/24. Next_Permutation-28A745?style=for-the-badge&logoColor=white" alt="Question 24">

> Ek permutation diya hai. Uska **lexicographically next greater permutation** find karna. Agar next permutation exist nahi karta, toh array ko smallest possible permutation me convert karna.

```text
Input:  arr[] = {1, 2, 3}
Output: {1, 3, 2}

Input:  arr[] = {3, 2, 1}
Output: {1, 2, 3}
```

---

#### ❌ Brute Force Approach
* **Concept:** Recursion ki help se array ki saari possible permutations generate karo. Unhe lexicographical order me sort karo. Current permutation ki position find karo aur uske just next permutation ko return kar do. Agar current permutation last hai, toh first permutation return karo.
* **Why?** Saari permutations generate karni padti hain (`n!`), isliye ye approach bahut expensive hai.

TC O(n!) &emsp; SC O(n × n!)

---

#### 🚀 Optimal Approach
* **Concept:** Next permutation sirf 3 steps me mil sakti hai:
>
> 1. **Breakpoint** find karo — Right se pehla index `i` jahan `arr[i] < arr[i + 1]`.
> 2. Breakpoint ke right side se **just greater** element dhoondo aur dono ko swap kar do.
> 3. Breakpoint ke baad wale poore suffix ko reverse kar do taaki smallest possible arrangement mil jaye.

* **Why?** Breakpoint ke baad ka part hamesha decreasing order me hota hai. Swap aur reverse karke next lexicographically greater permutation mil jata hai.

>
> **Pseudocode**
> ```text
> breakpoint = -1
>
> // Step 1: Find breakpoint
> for i from n-2 to 0:
>     if arr[i] < arr[i+1]:
>         breakpoint = i
>         break
>
> if breakpoint == -1:
>     reverse whole array
>     return
>
> // Step 2: Find next greater element
> for i from n-1 to breakpoint+1:
>     if arr[i] > arr[breakpoint]:
>         swap(arr[i], arr[breakpoint])
>         break
>
> // Step 3: Reverse suffix
> reverse(arr, breakpoint+1, n-1)
> ```

### Code
```java
public static void nextPermutation(int[] nums) {

    int n = nums.length;
    int bpIndex = -1;

    // Step 1: Find breakpoint
    for (int i = n - 1; i > 0; i--) {
        if (nums[i - 1] < nums[i]) {
            bpIndex = i - 1;
            break;
        }
    }

    // If breakpoint exists
    if (bpIndex != -1) {

        // Step 2: Find just greater element and swap
        for (int i = n - 1; i > bpIndex; i--) {
            if (nums[i] > nums[bpIndex]) {

                int temp = nums[bpIndex];
                nums[bpIndex] = nums[i];
                nums[i] = temp;

                break;
            }
        }

        // Step 3: Reverse suffix
        reverse(nums, bpIndex + 1, n - 1);

    } else {

        // Already the largest permutation
        reverse(nums, 0, n - 1);
    }
}

public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;

        start++;
        end--;
    }
}
```

TC O(n) &emsp; SC O(1)

> **Interview Tip:** Breakpoint ke baad wala suffix **hamesha decreasing order** me hota hai. Isi property ki wajah se us suffix ko sirf **reverse** karna enough hota hai—alag se sort karne ki zaroorat nahi padti.

---

## <img src="https://img.shields.io/badge/25. Longest_Consecutive_Sequence-28A745?style=for-the-badge&logoColor=white" alt="Question 25">

> Array me longest sequence find karna jisme consecutive integers present hon. Elements ka original order matter nahi karta.

```text
Input:  arr[] = {102, 4, 100, 1, 101, 3, 2, 1, 1}
Output: 4   //(Sequence: {1, 2, 3, 4})
```

---

#### ❌ Brute Force Approach
* **Concept:** Har element ko sequence ka starting point maan kar check karo ki `x + 1`, `x + 2`, ... array me exist karte hain ya nahi. Har next element ko **linear search** se dhoondo aur sequence ki length count karo. Sabhi elements ke liye maximum count return kar do.
* **Why?** Har element ke liye baar-baar linear search chalti hai, isliye overall quadratic time lagta hai.

TC O(n²) &emsp; SC O(1)

---

#### ⚡ Better Approach
* **Concept:** Pehle array ko sort karo. Phir sorted array me traverse karte hue consecutive elements count karo. Duplicate elements ko ignore karo aur jab sequence break ho jaye to count reset kar do. Maximum count hi answer hoga.
* **Why?** Sorting ke baad consecutive numbers ek saath aa jaate hain, jisse sequence detect karna easy ho jata hai.

TC O(n log n + n) &emsp; SC O(1)

---

#### 🚀 Optimal Approach (HashSet)
* **Concept:** Saare elements ko `HashSet` me store karo. Sirf un elements se sequence start karo jinke liye `element - 1` set me present **na ho**, kyunki wahi actual starting points hote hain. Phir `element + 1`, `element + 2`, ... ko set me check karke sequence ki length count karo.
* **Why?** Har sequence sirf ek hi baar traverse hoti hai, isliye overall linear time me solution mil jata hai.

>
> **Pseudocode**
> ```text
> insert all elements into HashSet
> longest = 1
>
> for each element in set:
>
>     if (element - 1) is not present:
>         count = 1
>         current = element
>
>         while (current + 1) exists:
>             current++
>             count++
>
>         longest = max(longest, count)
>
> return longest
> ```

### Code
```java
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public static int longestSequence(int[] arr) {

    if (arr.length == 0) return 0;

    int longest = 1;

    Set<Integer> set = Arrays.stream(arr)
                             .boxed()
                             .collect(Collectors.toSet());

    for (int num : set) {

        // Sequence ka starting point
        if (!set.contains(num - 1)) {

            int current = num;
            int count = 1;

            while (set.contains(current + 1)) {
                current++;
                count++;
            }

            longest = Math.max(longest, count);
        }
    }

    return longest;
}
```

TC O(n) *(Average case)* &emsp; SC O(n)

> **Interview Tip:** HashSet approach me sirf **sequence ke starting elements** (`num - 1` absent) se traversal shuru ki jaati hai. Isi wajah se har element maximum ek hi baar visit hota hai aur algorithm linear time achieve karta hai.

---

## <img src="https://img.shields.io/badge/26. Set_Matrix_Zeroes-28A745?style=for-the-badge&logoColor=white" alt="Question 26">

> Agar matrix me kisi bhi cell ki value `0` ho, to uski **poori row** aur **poora column** `0` kar dena. Transformation **in-place** karna hai.

```text
Input:
[
 [1, 1, 1, 1],
 [1, 0, 0, 1],
 [1, 1, 0, 1],
 [1, 1, 1, 1]
]

Output:
[
 [1, 0, 0, 1],
 [0, 0, 0, 0],
 [0, 0, 0, 0],
 [1, 0, 0, 1]
]
```

---

#### ❌ Brute Force Approach
* **Concept:** Matrix ko traverse karo. Jab bhi kisi cell me `0` mile, uski poori row aur poore column ko temporary value (jaise `-1`) se mark kar do taaki naye banaye gaye `0` dobara process na ho. Traversal ke baad saare `-1` ko `0` me convert kar do.
* **Why?** Har `0` ke liye poori row aur column dobara traverse karni padti hai, isliye complexity bahut badh jaati hai.

TC O((n × m) × (n + m)) &emsp; SC O(1)

---

#### ⚡ Better Approach
* **Concept:** Do extra arrays `row[]` aur `col[]` banao. Matrix traverse karte waqt agar `matrix[i][j] == 0` mile, to `row[i] = 1` aur `col[j] = 1` mark kar do. Phir ek aur traversal me jin rows ya columns ka marker `1` ho, unke cells ko `0` kar do.
* **Why?** Pehle sirf positions mark hoti hain, phir ek hi pass me changes apply hote hain.

TC O(2 × n × m) &emsp; SC O(n + m)

---

#### 🚀 Optimal Approach
* **Concept:** Extra row aur column arrays ki jagah **matrix ki first row aur first column ko hi markers** ki tarah use karo.

  * Sabse pehle check karo ki first row ya first column me pehle se `0` hai ya nahi (`row0`, `col0`).
  * Baaki matrix traverse karke jab bhi `0` mile, `matrix[i][0]` aur `matrix[0][j]` ko `0` mark kar do.
  * Phir first row aur first column ko markers ki tarah use karke baaki cells ko `0` karo.
  * Last me agar `row0` ya `col0` true ho, to first row aur first column ko bhi `0` kar do.

* **Why?** Matrix khud hi marker storage ban jaati hai, isliye extra arrays ki zaroorat nahi padti.

>
> **Pseudocode**
> ```text
> row0 = false
> col0 = false
>
> check first row and first column
>
> for remaining matrix:
>     if cell == 0:
>         matrix[i][0] = 0
>         matrix[0][j] = 0
>
> for remaining matrix:
>     if matrix[i][0] == 0 OR matrix[0][j] == 0:
>         matrix[i][j] = 0
>
> if row0:
>     make first row zero
>
> if col0:
>     make first column zero
> ```

### Code
```java
public static void setMatrix(int[][] arr, int n, int m) {

    boolean row0 = false;
    boolean col0 = false;

    // Check first row
    for (int j = 0; j < m; j++) {
        if (arr[0][j] == 0)
            row0 = true;
    }

    // Check first column
    for (int i = 0; i < n; i++) {
        if (arr[i][0] == 0)
            col0 = true;
    }

    // Mark rows and columns
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (arr[i][j] == 0) {
                arr[i][0] = 0;
                arr[0][j] = 0;
            }
        }
    }

    // Update remaining cells
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (arr[i][0] == 0 || arr[0][j] == 0) {
                arr[i][j] = 0;
            }
        }
    }

    // Update first row
    if (row0) {
        for (int j = 0; j < m; j++) {
            arr[0][j] = 0;
        }
    }

    // Update first column
    if (col0) {
        for (int i = 0; i < n; i++) {
            arr[i][0] = 0;
        }
    }
}
```

TC O(n × m) &emsp; SC O(1)

> **Interview Tip:** **First row aur first column ko marker arrays ki tarah use karna hi is problem ka main optimization hai.** Sirf unke original state ko preserve karne ke liye `row0` aur `col0` flags maintain kiye jaate hain.

---

## <img src="https://img.shields.io/badge/27. Rotate_Matrix_by_90_Degrees-28A745?style=for-the-badge&logoColor=white" alt="Question 27">

> Ek **N × N** matrix ko **90° clockwise** rotate karna. Optimal solution me rotation **in-place** karna hai.

```text
Input:
[
 [1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]
]

Output:
[
 [7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]
]
```

---

#### ❌ Brute Force Approach
* **Concept:** Ek naya matrix banao. Original matrix ke har element `arr[i][j]` ko uski rotated position `result[j][n - i - 1]` par store kar do.
* **Why?** Rotation to linear time me ho jaati hai, lekin poora naya matrix banane ki wajah se extra space lagti hai.

TC O(n × m) &emsp; SC O(n × m)

---

#### 🚀 Optimal Approach
* **Concept:** Matrix ko **in-place** rotate karne ke liye do steps follow karo:
>
> 1. **Transpose** karo (Rows ko Columns me convert karo) by swapping `arr[i][j]` with `arr[j][i]`.
> 2. Har row ko reverse kar do.

* **Why?** Transpose ke baad rows columns ban jaati hain, aur rows reverse karne se matrix exactly **90° clockwise** rotate ho jaati hai bina extra matrix use kiye.

>
> **Pseudocode**
> ```text
> // Step 1: Transpose
> for i = 0 to n-1:
>     for j = i to n-1:
>         swap(matrix[i][j], matrix[j][i])
>
> // Step 2: Reverse every row
> for each row:
>     reverse(row)
> ```

### Code
```java
public static void rotate(int[][] arr) {

    // Step 1: Transpose
    for (int i = 0; i < arr.length; i++) {
        for (int j = i; j < arr[0].length; j++) {

            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }

    // Step 2: Reverse each row
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[0].length / 2; j++) {

            int temp = arr[i][j];
            arr[i][j] = arr[i][arr.length - 1 - j];
            arr[i][arr.length - 1 - j] = temp;
        }
    }
}
```

TC O(2 × n²) = O(n²) &emsp; SC O(1)

> **Interview Tip:**
> - **90° Clockwise Rotation** = **Transpose + Reverse every Row**
> - **90° Anti-clockwise Rotation** = **Transpose + Reverse every Column**

---

## <img src="https://img.shields.io/badge/28. Spiral_Traversal_of_Matrix-28A745?style=for-the-badge&logoColor=white" alt="Question 28">

> Matrix ke saare elements ko **spiral order** me print ya return karna.

```text
Input:
[
 [1,  2,  3,  4],
 [5,  6,  7,  8],
 [9, 10, 11, 12],
 [13,14,15,16]
]

Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
```

---

#### ❌ Brute Force / Standard Approach
* **Concept:** Matrix ko 4 boundaries (`top`, `bottom`, `left`, `right`) ki help se layer-by-layer traverse karo.
  1. Top row → **Left to Right**
  2. Right column → **Top to Bottom**
  3. Bottom row → **Right to Left**
  4. Left column → **Bottom to Top**

  Har traversal ke baad corresponding boundary ko update karo (`top++`, `right--`, `bottom--`, `left++`) aur ye process tab tak repeat karo jab tak `top <= bottom` aur `left <= right` ho.

* **Why?** Har element ko exactly ek hi baar visit kiya jata hai, isliye ye hi standard aur optimal solution hai.

> **Note:** Is problem ka koi better ya more optimal approach nahi hai. Spiral traversal ke liye ye hi expected interview solution hai.

>
> **Pseudocode**
> ```text
> top = 0
> bottom = n - 1
> left = 0
> right = m - 1
>
> while top <= bottom AND left <= right:
>
>     traverse top row
>     top++
>
>     traverse right column
>     right--
>
>     if top <= bottom:
>         traverse bottom row
>         bottom--
>
>     if left <= right:
>         traverse left column
>         left++
> ```

### Code
```java
public static void spiral(int[][] arr) {

    int n = arr.length;
    int m = arr[0].length;

    int top = 0;
    int bottom = n - 1;
    int left = 0;
    int right = m - 1;

    while (top <= bottom && left <= right) {

        // Left → Right
        for (int i = left; i <= right; i++) {
            System.out.println(arr[top][i]);
        }
        top++;

        // Top → Bottom
        for (int i = top; i <= bottom; i++) {
            System.out.println(arr[i][right]);
        }
        right--;

        // Right → Left
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                System.out.println(arr[bottom][i]);
            }
            bottom--;
        }

        // Bottom → Top
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                System.out.println(arr[i][left]);
            }
            left++;
        }
    }
}
```

TC O(n × m) &emsp; SC O(1)

> **Interview Tip:** Bottom row aur left column traverse karne se pehle **`top <= bottom`** aur **`left <= right`** ki condition zaroor check karo. Ye **single row** ya **single column** wale cases me duplicate traversal se bachata hai.

---

## <img src="https://img.shields.io/badge/29. Count_Subarrays_with_Sum_K-28A745?style=for-the-badge&logoColor=white" alt="Question 29">

> Array me aise **total subarrays** count karna jinka sum exactly target `k` ke barabar ho.

```text
Input:  arr[] = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3}, k = 3
Output: 8
```

---

#### 🚀 Optimal Approach (Prefix Sum + HashMap)
* **Concept:** Traverse karte waqt ek `prefixSum` maintain karo. Ek `HashMap<PrefixSum, Frequency>` store karega ki har prefix sum kitni baar aaya hai.

  Har element par:
  * `prefixSum` update karo.
  * Check karo ki `prefixSum - k` map me pehle se present hai ya nahi.
  * Agar present hai, to uski frequency jitni hogi utne subarrays current index par end hote hue sum `k` denge. Unhe answer me add kar do.
  * Fir current `prefixSum` ki frequency map me update kar do.

* **Why?** Agar kisi previous index par prefix sum `prefixSum - k` tha, to uske baad se current index tak ka subarray exactly `k` ka sum dega.

>
> **Pseudocode**
> ```text
> prefixSum = 0
> count = 0
>
> map = {0 : 1}
>
> for each element:
>     prefixSum += element
>
>     if (prefixSum - k) exists in map:
>         count += frequency(prefixSum - k)
>
>     map[prefixSum]++
>
> return count
> ```

### Code
```java
import java.util.HashMap;

public static int subarraySumK(int[] nums, int k) {

    int prefixSum = 0;
    int count = 0;

    HashMap<Integer, Integer> map = new HashMap<>();

    // Empty prefix
    map.put(0, 1);

    for (int num : nums) {

        prefixSum += num;

        if (map.containsKey(prefixSum - k)) {
            count += map.get(prefixSum - k);
        }

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }

    return count;
}
```

TC O(n) &emsp; SC O(n)

> **Interview Tip:** `map.put(0, 1)` bahut important hai. Ye un subarrays ko handle karta hai jo **index 0 se hi start hote hain** aur jinka sum directly `k` hota hai.

--- 
