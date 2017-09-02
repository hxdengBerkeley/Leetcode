public class Solution {
    public static boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int low=0,high=nums.length-1,mid=(low+high)/2;
        while(low<high){
            mid=(low+high)/2;
            if (nums[mid]==target) return true;
            if(nums[mid]>nums[high]){
                if(nums[mid]>target && nums[low] <= target) high = mid;
                else low = mid + 1;
            }else if(nums[mid] < nums[high]){
                if(nums[mid]<target && nums[high] >= target) low = mid + 1;
                else high = mid;
            }else{
                high--;
            }
        }
        mid=(low+high)/2;
        return nums[mid]==target;
    }
}
