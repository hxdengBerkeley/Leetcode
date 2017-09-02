public class Solution {
    int size;
    public int minCut(String s) {
        size = Integer.MAX_VALUE;
        helper(s,new ArrayList<>());
        return Math.max(size,0);
    }

    public void helper(String s, List<String> resulti){
        if (s.length()==0){
            size = Math.min(size,resulti.size()-1);
        }else {
            if (resulti.size()-1>=size) return;
            for (int i = s.length(); i >0 ; i--) {
                if (palindrome(s.substring(0,i))){
                    List<String> resulticpy = new ArrayList<>(resulti);
                    resulticpy.add(s.substring(0,i));
                    helper(s.substring(i,s.length()),resulticpy);
                }
            }
        }
    }

    public boolean palindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}