/**
 * Created by denghanxiao on 2017/5/7.
 */
public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        String longestCP = "";
        if (strs.length == 0) {
            return longestCP;
        }
        int length = minLenght(strs);
        for (int j = 0; j < length; j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    return longestCP;
                }
            }
            longestCP+=strs[0].charAt(j);
        }
        return longestCP;
    }

    public static int minLenght(String[] strs){
        int length = strs[0].length();
        for (String str:strs) {
            length = Math.min(length,str.length());
        }
        return length;
    }

    public static void main(String[] args){
        String[] strs = {};
        System.out.println(longestCommonPrefix(strs));
    }
}
