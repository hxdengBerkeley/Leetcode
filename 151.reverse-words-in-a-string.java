public class Solution {
    public String reverseWords(String s) {
        String result = helper(s);
        while (result.startsWith(" ")){
            result = result.substring(1);
        }
        while (result.endsWith(" ")){
            result = result.substring(0,result.length()-1);
        }
        return result;
    }

    public String helper(String s) {
        for (int i = s.length()-1; i >=0 ; i--) {
            if (!Character.isSpaceChar(s.charAt(i))){
                for (int j = i; j >=0 ; j--) {
                    if (j==0) return s.substring(0,i+1);
                    if (Character.isSpaceChar(s.charAt(j))){
                        return s.substring(j+1,i+1)+" "+helper(s.substring(0,j));
                    }
                }
            }
        }
        return "";
    }
}