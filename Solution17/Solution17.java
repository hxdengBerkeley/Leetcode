/**
 * Created by denghanxiao on 2017/5/9.
 */
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.lang.Character;

public class Solution17 {
    private static final String[] KEYS = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length()>0){
            char x = digits.charAt(0);
            int number = Character.getNumericValue(x);
            for (int i = 0; i < KEYS[number].length(); i++) {
                result.add((Character.toString(KEYS[number].charAt(i))));
            }

            for(int i=1; i<digits.length(); i++){
                letterCombination(result,Character.getNumericValue(digits.charAt(i)));
            }
        }
        return  result;
    }

    public static void letterCombination(List<String> result1, int digit){
        if(digit==0||digit==1) return;
        int times = KEYS[digit].length();
        List<String> result = new ArrayList<String>();
        for(int i=0; i<result1.size()*times; i++){
            result.add(result1.get(i/times)+KEYS[digit].charAt(i%times));
        }
        result1.clear();
        result1.addAll(result);
    }
    public static void main(String[] args){
        String a = "23";
        List<String> b = letterCombinations(a);
        System.out.println(b);
    }
}
