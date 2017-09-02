class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length==1) return 0;
        int head=0,tail=nums.length-1,mid=0;
        while(head<=tail){
            mid = (head+tail)/2;
            if (mid==0){
                if (nums[mid]>nums[mid+1]) return mid;
                else head = mid+1;
            }else if (mid==nums.length-1){
                if (nums[mid-1]<nums[mid]) return mid;
                else tail = mid-1;
            }else {
                if (nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                    return mid;
                }else if(nums[mid-1]>nums[mid]){
                    tail=mid-1;
                }else {
                    head=mid+1;
                }
            }
        }
        return mid;
    }
}