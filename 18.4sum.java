public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
	Arrays.sort(nums);
	int k,l,now;
	List<List<Integer>> result = new ArrayList<>();

	for(int i=0;i<nums.length-3;i++){
		if(i>0&&nums[i]==nums[i-1]) continue;
		for(int j=i+1;j<nums.length-2;j++){
			if(j>i+1&&nums[j]==nums[j-1]) continue;
			k = j+1; l=nums.length-1;
			while(k<l){
				now = nums[i]+nums[j]+nums[k]+nums[l];
				if(now == target) {
					result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
					do{
						k++;
					}while(k>j+1&&nums[k]==nums[k-1]&&k<l);
				}
				if(now<target) k++;
				if(now>target) l--;
			} 
		}
	}
	return result;
    }
}
