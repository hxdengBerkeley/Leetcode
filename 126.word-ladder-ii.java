public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result =  new ArrayList<>();
        List<String> resulti = new ArrayList<>();
        resulti.add(beginWord);
        findLadder(result,resulti,endWord,wordList);
        return result;
    }


    public boolean oneDiff(String a, String b){
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i)!=b.charAt(i)){
                if (i==a.length()-1) return true;
                else return a.substring(i+1,a.length()).equals(b.substring(i+1,a.length()));
            }
        }
        return false;
    }
}