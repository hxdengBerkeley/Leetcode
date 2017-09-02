public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int[] result = new int[nums.length];
        result[0]=nums[0];
        result[1]=nums[1];
        int j=2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i]!=result[j-1]||nums[i]!=result[j-2]) {
                result[j] = nums[i];
                j++;
            }
        }
        System.arraycopy(result,0,nums,0,j);
        return j;
    }
}