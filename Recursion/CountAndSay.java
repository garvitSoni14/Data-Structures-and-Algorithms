package Recursion;

public class CountAndSay {

    public static void main(String[] args){
        System.out.println(countAndSay(4));
    }
    public static  String countAndSay(int n) {
        if (n==1) return "1";
        String say = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        int count=0;
        for(int i=0;i<say.length();i++){
            char c = say.charAt(i);
            count=1;
            while(i<say.length()-1 && say.charAt(i)==say.charAt(i+1)){
                count++; i++;
            }
            result.append(count);
            result.append(say.charAt(i));
        }
        return result.toString();
    }
}
