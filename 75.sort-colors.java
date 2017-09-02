public class Solution {
    public void sortColors(int[] nums) {
	int white=0,blue=0;
	for(int i=0; i<nums.length; i++){
		if(nums[i]==1) white++;
		if(nums[i]==2) blue++;
	}
	for(int i=0; i<nums.length-white-blue; i++){
		nums[i]=0;
	}
	for(int i=nums.length-white-blue; i<nums.length-blue; i++){
		nums[i]=1;
	}
	for(int i=nums.length-blue; i<nums.length; i++){
		nums[i]=2;
	}
    }
}
