package String;

public class ZigZag_Conversion {

    public static void main (String [] args){
        String s = "PAYPALISHIRING";
        String zigzag = convert(s,3);
        System.out.println(zigzag);
    }
    public static String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows;i++){
            rows[i]= new StringBuilder();
        }
        int curRow = 0;
        boolean goingDown = false;
        for(char c: s.toCharArray()){
            rows[curRow].append(c);
            if(curRow==0 || curRow == numRows - 1){
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1:-1;
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row:rows){
            result.append(row);
        }
        return result.toString();
    }
}


class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows;i++){
            rows[i]= new StringBuilder();
        }
        int curRow = 0;
        boolean goingDown = false;
        for(char c: s.toCharArray()){
            rows[curRow].append(c);
            if(curRow==0 || curRow == numRows - 1){
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1:-1;
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row:rows){
            result.append(row);
        }
        return result.toString();
    }
}
