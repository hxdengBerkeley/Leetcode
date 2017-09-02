public class Solution {
    List<String> wordDic;
    Map<String,List<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDic=wordDict;
        map = new HashMap<>();
        return DFS(s);
    }
    public List<String> DFS(String s) {
        if (map.containsKey(s)) return map.get(s);
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
        } else {
            for (String word:wordDic){
                if (s.startsWith(word)){
                    List<String> resulti = DFS(s.substring(word.length()));
                    for (String substr:resulti) {
                        if (substr.length()==0) result.add(word);
                        else result.add(word+" "+substr);
                    }
                }
            }
        }
        map.put(s,result);
        return result;
    }
}