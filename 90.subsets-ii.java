public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resulti = new ArrayList<>();
        Arrays.sort(nums);
        subi(result,resulti,nums,-1);
        return result;
    }

    public void subi(List<List<Integer>> result, List<Integer> resulti, int[] nums, int index) {
        if (!result.contains(resulti)){
            result.add(resulti);
            for (int i = index+1; i < nums.length; i++) {
                List<Integer> resulticpy = new ArrayList<>(resulti);
                resulticpy.add(nums[i]);
                subi(result,resulticpy,nums,i);
            }
        }
    }
}