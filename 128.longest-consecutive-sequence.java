public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x:nums) {
            set.add(x);
        }
        Map<Integer,Integer> map1_2 = new HashMap<>();
        Map<Integer,Integer> map2_1 = new HashMap<>();
        int max = 0;
        for (int x:set) {
            boolean a = map1_2.containsKey(x+1);
            boolean b = map2_1.containsKey(x-1);
            if (a&&b){
                int start = map2_1.get(x-1);
                int end = map1_2.get(x+1);
                map1_2.put(start,end);
                map2_1.put(end,start);
                map1_2.remove(x+1);
                map2_1.remove(x-1);
                max = Math.max(max,end-start+1);
            }else if (a&&!b){
                int start = x;
                int end = map1_2.get(x+1);
                map1_2.put(start,end);
                map2_1.put(end,start);
                map1_2.remove(x+1);
                max = Math.max(max,end-start+1);
            }else if (!a&&b){
                int start = map2_1.get(x-1);
                int end = x;
                map1_2.put(start,end);
                map2_1.put(end,start);
                map2_1.remove(x-1);
                max = Math.max(max,end-start+1);
            }else {
                map1_2.put(x,x);
                map2_1.put(x,x);
                max = Math.max(max,1);
            }
        }
        return max;
    }
}