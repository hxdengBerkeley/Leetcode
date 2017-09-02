public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            combine(result,new ArrayList<>(),new ArrayList<>(),nums,i);
        }
        return result;
    }

    public void combine(List<List<Integer>> result,List<Integer> nowIndex, List<Integer> nowReal ,int[] nums, int k){
        if (nowReal.size()==k){
            result.add(nowReal);
            return;
        }else if(nowReal.size()==0){
            for (int i = 1; i <=nums.length-k+1; i++) {
                List<Integer> nowi = new ArrayList<>(nowIndex);
                List<Integer> nowr = new ArrayList<>(nowReal);
                nowi.add(i);
                nowr.add(nums[i-1]);
                combine(result,nowi,nowr,nums,k);
            }
            return;
        }else {
            for (int i = nowIndex.get(nowIndex.size()-1)+1; i <=nums.length+nowIndex.size()+1-k ; i++) {
                List<Integer> nowi = new ArrayList<>(nowIndex);
                List<Integer> nowr = new ArrayList<>(nowReal);
                nowi.add(i);
                nowr.add(nums[i-1]);
                combine(result,nowi,nowr,nums,k);
            }
            return;
        }
    }
}