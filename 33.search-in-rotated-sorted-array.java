public class Solution {
    public int search(int[] nums, int target) {
	if(nums.length==0) return -1;
	if(nums.length==1){
		if(nums[0]==target) return 0;
		return -1;
	}
	int i = 0, j=nums.length-1, k=(i+j)/2;
	boolean sorted=true;
	while(i<=j){
		k = (i+j)/2;
		if(nums[k]>nums[k+1]){
			sorted = false;
			break;
		}
		if(nums[k]>=nums[0]){
			i = k+1;
		}
		if(nums[k]<=nums[nums.length-1]){
			j = k-1;
		}
	}
	if(sorted){
		i=0;
		j=nums.length-1;
	}else{
		if(target>nums[k]||target<nums[k+1]) return -1;
		if(target>=nums[0]){
			i=0;
			j=k;
		}
		if(target<=nums[nums.length-1]){
			i=k+1;
			j=nums.length-1;
		}
	}
	while(i<=j){
		k = (i+j)/2;
		if(nums[k]==target) return k;
		if(nums[k]>target) j=k-1;
		if(nums[k]<target) i=k+1;
	}
	return -1;
    }
}
