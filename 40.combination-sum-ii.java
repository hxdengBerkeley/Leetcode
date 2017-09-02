public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resulti = new ArrayList<>();
        Arrays.sort(candidates);
        reduceSum(candidates,target,result,resulti);
        Set<List<Integer>> set = new HashSet<>(result);
        result = new ArrayList<>(set);
        return result;
    }

    public boolean reduceSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> resulti){
        for (int i = 0; i<candidates.length; i++) {
            List<Integer> now = new ArrayList<>(resulti);
            int x = candidates[i];
            if(now.isEmpty()&&i>0&&x==candidates[i-1]) continue;
	    if (target-x == 0){
                now.add(x);
                result.add(now);
                return true;
            }
            if(target-x>0){
                now.add(x);
                reduceSum(Arrays.copyOfRange(candidates,i+1,candidates.length),target-x,result,now);
            }
            if (target-x<0){
                continue;
            }
        }
        return false;
    }
}
