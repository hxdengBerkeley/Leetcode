public class Solution {
    public int threeSumClosest(int[] nums, int target) {
	Arrays.sort(nums);
	int result = nums[0]+nums[1]+nums[2];
	int j,k,now;
	for(int i=0; i<nums.length-2; i++){
		j = i+1; k = nums.length-1;
		while(j<k){
			now = nums[i]+nums[j]+nums[k];
			if(now==target) return target;
			if(now<target){
				j++;
			}
			if(now>target){
				k--;
			}
			if(Math.abs(now-target)<Math.abs(result-target)) result = now;
		}
	}
	return result;
    }
}
