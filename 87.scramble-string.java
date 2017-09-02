public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        if (s1.equals(s2)) {
            return true;
        } else {
            int l = s1.length();
            int[] count = new int[26];
            for (int i = 0; i < l; i++) {
                count[s1.charAt(i)-'a']++;
                count[s2.charAt(i)-'a']--;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i]!=0) return false;
            }
            for (int i = 1; i < l; i++) {
                if (isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i,l),s2.substring(i,l))) return true;
                if (isScramble(s1.substring(0,i),s2.substring(l-i,l))&&isScramble(s1.substring(i,l),s2.substring(0,l-i))) return true;
            }
            return false;
        }
    }
}