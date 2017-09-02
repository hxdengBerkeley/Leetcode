public class Solution {
	public int firstMissingPositive(int[] nums) {
		int i=0;
		while(i<nums.length){
			if(nums[i]<1||nums[i]>nums.length||nums[i]-1==i){
				i++;
				continue;
			}
			if(nums[i]-1!=i&&nums[nums[i]-1]!=nums[i]) {
				swap(nums, i, nums[i] - 1);
				continue;
			}
			i++;
		}
		i=0;
		while(i<nums.length&&nums[i]-1==i){
			i++;
		}
		i++;
		return i;
	}

	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
