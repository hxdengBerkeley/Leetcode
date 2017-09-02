public class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resulti = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int x:nums) {
            list.add(x);
            set.add(x);
        }
        permuteBK(result, list , resulti, set );
        return result;

    }

    public static void permuteBK( List<List<Integer>> result, List<Integer> list, List<Integer> resulti, Set<Integer> set) {
        if (list.size()==0){
            result.add(resulti);
        }
        for (int x:set) {
            if(list.contains(x)){
                List<Integer> resultnow = new ArrayList<>(resulti);
                List<Integer> listi = new ArrayList<>(list);
                listi.remove((Integer)x);
                resultnow.add(x);
                permuteBK(result,listi,resultnow,set);
            }
        }
    }
}
