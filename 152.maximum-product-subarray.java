class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0],max = result, min = result;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<0){
                int flag = max;
                max=min;
                min=flag;
            }
            max = Math.max(nums[i],nums[i]*max);
            min = Math.min(nums[i],nums[i]*min);
            result = Math.max(result,max);
        }
        return result;
    }
}