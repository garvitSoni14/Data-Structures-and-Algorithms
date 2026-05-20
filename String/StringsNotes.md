# 📘 DSA Strings Notes — Hindi + English

---

# 1️⃣ Remove Outer Most Parenthesis

### 🧠 Problem
Primitive valid parentheses ke outermost brackets remove karo.

### Optimal Approach
Count variable maintain karo.
Agar current bracket outermost nahi hai tabhi append karo.

### Code
```java
public static String removeOuterParenthesis(String s)
{
    StringBuilder stringBuilder = new StringBuilder();

    int count=0;

    for(int i = 0; i<s.length(); i++)
    {
        if( s.charAt(i) == ')')
        {
            count-=1;
        }

        if(count != 0)
        {
            stringBuilder.append(s.charAt(i));
        }

        if( s.charAt(i) == '(' )
        {
            count+=1;
        }
    }

    return stringBuilder.toString();
}
```

TC: O(n)  
SC: O(n)

---

# 2️⃣ Largest Odd Number in String

### 🧠 Problem
Numeric string me largest odd-number substring return karo.

### Optimal Approach
Right se traverse karo.
Jab pehla odd digit mile → us index tak substring return.

### Code
```java
public static String largestOddNumber(String s)
{
    for( int i = s.length()-1 ; i>=0 ; i--)
    {
        if( ( (int) s.charAt(i) & 1) ==1)
        {
            return (s.substring(0,i+1));
        }
    }

    return "";
}
```

TC: O(n)  
SC: O(1)

---

# 3️⃣ Longest Common Prefix

### Brute Force
Pick first string as prefix and reduce on mismatch.

TC: O(n*m), SC: O(1)

### Better Approach
Compare characters column-wise across all strings.

TC: O(n*m), SC: O(1)

### Optimal Approach
Sort array.
First and last strings sabse different honge.
In dono ka common prefix hi final answer hoga.

### Code
```java
public static String longestCommonPrefix(String[] strs) {

    if(strs.length==0 || strs==null) return "";

    Arrays.sort(strs);

    String first = strs[0];
    String last = strs[strs.length-1];

    int i=0;

    while(i<first.length() &&
          i<last.length() &&
          first.charAt(i) == last.charAt(i))
    {
        i++;
    }

    return first.substring(0,i);
}
```

TC: O(n log n + m)  
SC: O(1)

---

# 4️⃣ Isomorphic Strings

### 🧠 Problem
Check if one string characters can map uniquely to another string.

### Optimal Approach
Use HashMap for mapping and HashSet for uniqueness checking.

### Code
```java
public static Boolean isomorphicString(String s1, String s2) {

    if(s1.length() != s2.length()) return false;

    HashMap<Character, Character> hm = new HashMap<>();
    HashSet<Character> hs = new HashSet<>();

    for(int i = 0; i<s1.length(); i++){

        char c1 = s1.charAt(i),
             c2 = s2.charAt(i);

        if(hm.containsKey(c1)){

            if(hm.get(c1) != c2) return false;
        }

        else {

            if(hs.contains(c2)) return false;

            hm.put(c1,c2);
            hs.add(c2);
        }
    }

    return true;
}
```

TC: O(n)  
SC: O(n)

---

# 5️⃣ Rotate String

### 🧠 Problem
Check if one string is rotation of another.

### Optimal Approach
If lengths equal and s2 exists inside s1+s1 → rotation exists.

### Code
```java
public static Boolean rotateString(String s1, String s2)
{
    return (s1.length()==s2.length() &&
           (s1+s1).contains(s2));
}
```

TC: O(n)  
SC: O(n)

---

# 6️⃣ Valid Anagram

### Brute Force
Sort both strings and compare.

TC: O(n log n)

### Better / Optimal
Use frequency map.

### Code
```java
public static Boolean anagramStrings(String s1, String s2)
{
    if(s1.length() != s2.length())
    {
        return false;
    }

    Map<Character,Integer> freq = new HashMap<>();

    for(char c:s1.toCharArray())
    {
        freq.put(c,freq.getOrDefault(c,0)+1);
    }

    for(char c:s2.toCharArray())
    {
        if(!freq.containsKey(c))
        {
            return false;
        }

        freq.put(c,freq.get(c)-1);
    }

    for(int i : freq.values())
    {
        if(i != 0)
        {
            return false;
        }
    }

    return true;
}
```

TC: O(n)  
SC: O(n)

---

# 7️⃣ Sort Characters by Frequency

### 🧠 Problem
Characters ko descending frequency me arrange karo.

### Optimal Approach
HashMap frequency + sorting of characters.

### Code
```java
public static String frequencySort(String s)
{
    StringBuilder stringBuilder = new StringBuilder();

    Map<Character,Integer> hm = new HashMap<>();

    for(char c: s.toCharArray())
    {
        hm.put(c,hm.getOrDefault(c,0)+1);
    }

    List<Character> l = new ArrayList<>(hm.keySet());

    l.sort((ob1,ob2) -> hm.get(ob2)-hm.get(ob1));

    for(char c: l){

        for(int i=0; i<hm.get(c); i++)
        {
            stringBuilder.append(c);
        }
    }

    return stringBuilder.toString();
}
```

TC: O(n log n)  
SC: O(n)

---

# 8️⃣ Maximum Nesting Depth of Parenthesis

### 🧠 Problem
Maximum nested brackets depth find karo.

### Optimal Approach
Opening bracket pe count++.
Closing bracket pe count--.
Maximum count track karo.

### Code
```java
public static int maximumParenthesisNesting(String s)
{
    int res=-1;
    int point=0;

    for(char c: s.toCharArray())
    {
        if(c=='('){point++;}

        if(c==')'){point--;}

        res = Math.max(res,point);
    }

    return res;
}
```

TC: O(n)  
SC: O(1)

---

# 9️⃣ Roman To Integer

### Approach
Reverse traverse:
Agar current Roman symbol previous se smaller hai → subtract.
Otherwise add.

### Code
```java
public static int romanToInt(String s) {

    int res = 0;

    HashMap<Character, Integer> mp = new HashMap<>();

    mp.put('I',1);
    mp.put('V',5);
    mp.put('X',10);
    mp.put('L',50);
    mp.put('C',100);
    mp.put('D',500);
    mp.put('M',1000);

    for(int i=0;i<s.length()-1;i++){

        if( mp.get(s.charAt(i)) <
            mp.get(s.charAt(i+1)) )
        {
            res -= mp.get(s.charAt(i));
        }

        else
            res+=mp.get(s.charAt(i));
    }

    res+=mp.get(s.charAt(s.length()-1));

    return res;
}
```

TC: O(n)  
SC: O(1)

---

# 🔟 Integer To Roman

### 🧠 Problem
Integer ko Roman numeral me convert karo.

### Optimal Approach
Greedy approach.
Largest Roman value repeatedly subtract karo.

### Code
```java
public static String intToRoman(int num) {

    StringBuilder romanized= new StringBuilder();

    int[] values= {
        1000,900,500,400,
        100,90,50,40,
        10,9,5,4,1
    };

    String[] romanMapping = {
        "M","CM","D","CD",
        "C","XC","L","XL",
        "X","IX","V","IV","I"
    };

    for(int i=0;i<values.length;i++){

        while(num>=values[i]){

            romanized.append(romanMapping[i]);

            num-=values[i];
        }
    }

    return romanized.toString();
}
```

TC: O(1)  
SC: O(1)

---

# 1️⃣1️⃣ String To Integer (ATOI)

### 🧠 Problem
String ko integer me convert karo with overflow handling.

### Important Cases
✔ spaces ignore  
✔ sign handle  
✔ stop at non-digit  
✔ overflow check

### Code
```java
public static int ATOI(String s)
{
    s = s.trim();

    if (s.isEmpty()) return 0;

    int sign = 1, i = 0, res = 0;

    if (s.charAt(0) == '-' ||
        s.charAt(0) == '+')
    {
        sign = (s.charAt(0) == '-') ? -1 : 1;

        i++;
    }

    for (; i < s.length(); i++) {

        char c = s.charAt(i);

        if (c < '0' || c > '9') break;

        int digit = c - '0';

        if (res > (Integer.MAX_VALUE - digit) / 10)
        {
            return (sign == 1)
                   ? Integer.MAX_VALUE
                   : Integer.MIN_VALUE;
        }

        res = res * 10 + digit;
    }

    return res * sign;
}
```

TC: O(n)  
SC: O(1)

---

# 🧠 Universal String DSA Tips

- character frequency → HashMap / array
- palindrome / rotation → two pointers
- substring search → sliding window
- matching patterns → HashMap
- prefix problems → sorting / trie
- brackets → stack / counter

---

# 🚀 Interview Checklist

✔ spaces present?  
✔ uppercase/lowercase?  
✔ special characters?  
✔ duplicate mappings?  
✔ overflow possible?  
✔ empty string?  
✔ frequency counting needed?
