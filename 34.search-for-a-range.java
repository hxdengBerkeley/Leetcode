public class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int[] result = {-1,-1};
    	if (nums.length==0) return result;
		int i = 0, j = nums.length-1, k = (i+j+1)/2;
		while(i<=j){
			k = (i+j+1)/2;
			if(nums[k]>target) {
				j = k-1;
				continue;
			}
			if(nums[k]<target) {
				i = k+1;
				continue;
			}
			if(nums[k]==target){
				if(k==nums.length-1) {
					result[1] = k;
					break;
				}
				if(nums[k+1]==target){
					i=k+1;
					continue;
				}
				if(nums[k+1]>target) {
					result[1] = k;
					break;
				}
			}
		}

		i = 0; j = nums.length-1; k = (i+j)/2;
		while(i<=j){
			k = (i+j)/2;
			if(nums[k]>target) {
				j = k-1;
				continue;
			}
			if(nums[k]<target) {
				i = k+1;
				continue;
			}
			if(nums[k]==target){
				if(k==0) {
					result[0] = k;
					break;
				}
				if(nums[k-1]==target){
					j=k-1;
					continue;
				}
				if(nums[k-1]<target) {
					result[0] = k;
					break;
				}
			}
		}
		return result;
    }
}
