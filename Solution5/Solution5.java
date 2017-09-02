public class Solution5 {
    public static String longestPalindrome(String s){
        String longestStr="";
        String currentStr="";
        for (int i=0; i<s.length(); i++) {
            currentStr=extendPalindrome(s,i);
            longestStr = currentStr.length()>longestStr.length()? currentStr:longestStr;
            if(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){
                currentStr=extendPalindrome(s,i,i+1);
                longestStr = currentStr.length()>longestStr.length()? currentStr:longestStr;
            }

        }
        return longestStr;
    }

    public static String extendPalindrome(String s, int i, int j){
        int low=i-1,high=j+1;
        while(low!=-1&&high!=s.length()&&s.charAt(low)==s.charAt(high)){
            low--;
            high++;
        }
        low++;
        high--;
        return s.substring(low,high+1);
    }

    public static String extendPalindrome(String s, int i){
        int low=i-1,high=i+1;
        while(low!=-1&&high!=s.length()&&s.charAt(low)==s.charAt(high)){
            low--;
            high++;
        }
        low++;
        high--;
        return s.substring(low,high+1);
    }


    public static String longestPalindrome1(String s) {
        for(int length=s.length(); length>0;length--){
            for(int first=0; first<s.length()-length+1;first++){
                if(isPalindrome(s.substring(first,first+length))){
                    return s.substring(first,first+length);
                }
            }
        }
        return "";
    }
    
    public static boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome1(s));
    }
}