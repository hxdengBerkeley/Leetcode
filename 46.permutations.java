public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resulti = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x:nums) {
            set.add(x);
        }
        permuteBK(result, set , resulti);
        return result;

    }

    public void permuteBK( List<List<Integer>> result, Set<Integer> set, List<Integer> resulti ) {
        if (resulti.size()==set.size()){
            result.add(resulti);
        }
        for (int x:set) {
            List<Integer> resultnow = new ArrayList<>(resulti);
            if(!resultnow.contains(x)){
                resultnow.add(x);
                permuteBK(result,set,resultnow);
            }
        }
    }
}
