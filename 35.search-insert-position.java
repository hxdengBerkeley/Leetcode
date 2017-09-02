public class Solution {
    public int searchInsert(int[] nums, int target) {
	if(nums.length==0) return 1;
	int i=0,j=nums.length-1,k=(i+j)/2;
	while(i<=j){
		k = (i+j)/2;
		if(nums[k]<target){
			i=k+1;
			continue;
		}
		if(nums[k]>target){
			j=k-1;
			continue;
		}
		if(nums[k]==target){
			return k;
		}
	}
	return i;
	        
    }
}
