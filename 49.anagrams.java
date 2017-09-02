public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word:strs) {
            if (!map.containsKey(anagramsCode(word))){
                map.put(anagramsCode(word),new ArrayList<String>());
            }
            map.get(anagramsCode(word)).add(word);
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }

    public int anagramsCode(String word){
        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);
        return String.valueOf(wordArray).hashCode();
    }
}
