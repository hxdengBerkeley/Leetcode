public class Solution6 {
    public static String convert(String s, int numRows) {
        String result="";
        if (numRows == 1|| numRows == 0) {
            return s;
        }
        int flag,index;
        for(int i=0; i<numRows; i++){
            flag = numRows-1; index = i;
            if (i==0) {
                while (index<s.length()) {
                    result+=s.charAt(index);
                    index = flag*2-index;
                    flag+=2*(numRows-1);
                }
            }else if (i==numRows-1) {
                while (index<s.length()) {
                    result+=s.charAt(index);
                    index+=2*(numRows-1);
                }                
            }else {
                while (index<s.length()) {
                    result+=s.charAt(index);
                    index = flag*2-index;
                    flag+=(numRows-1);
                }                
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	String a ="abababab";
    	System.out.println(convert(a,0));
    }
}