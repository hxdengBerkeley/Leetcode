public class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s,new ArrayList<>());
        return result;
    }

    public void helper(String s, List<String> resulti){
        if (s.length()==0){
            result.add(resulti);
        }else {
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