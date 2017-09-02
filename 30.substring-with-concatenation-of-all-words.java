public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        String now,nowword;
        int length = words[0].length()*words.length,j,count;

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i < s.length() - length + 1; i++) {
            Map<String, Integer> wordmap = new HashMap<String, Integer>(map); j=0;
            while(j+words[0].length()<length+1){
                nowword=s.substring(i+j,i+j+words[0].length());
                if (wordmap.containsKey(nowword)){
                    count = wordmap.get(nowword);
                    if (count==1){
                        wordmap.remove(nowword);
                    }else{
                        wordmap.put(nowword,count-1);
                    }
                }else {
                    break;
                }
                j+=words[0].length();
            }
            if (wordmap.isEmpty()) result.add(i);
        }
        return result;
    }
}
