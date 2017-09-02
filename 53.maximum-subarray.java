public class Solution {
	public int maxSubArray(int[] nums) {
		if(nums.length==0) return 0;
		int max=nums[0],maxi=max,maxi_1=max;
		for(int i=1; i<nums.length; i++){
			maxi = Math.max(nums[i],nums[i]+maxi_1);
			max = Math.max(maxi,max);
			maxi_1=maxi;
		}
		return max;
	}
}
