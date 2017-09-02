public class Solution {
    public void nextPermutation(int[] nums) {
	if(nums.length<2) return;
	if(nums.length==2){
		nums[0]+=nums[1];
		nums[1]=nums[0]-nums[1];
		nums[0]-=nums[1];
		return;
	}
	int i = nums.length-1;
	while(i>0){
		if(nums[i-1]<nums[i]) break;
		i--;
	}
	if(i==0){ 
		Arrays.sort(nums);
       		return;
	}
	i--;
	int j = nums.length-1;
	while(j>i){
		if(nums[j]>nums[i]) break;
		j--;
	}
	int flag = nums[j];
	nums[j] = nums[i];
	nums[i] = flag;
	Arrays.sort(nums,i+1,nums.length);
    }
}
