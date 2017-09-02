class Solution {
    public int findMin(int[] nums) {
        int head=0,tail=nums.length-1,mid=(head+tail)/2;
        if (nums[head]<nums[tail]) return nums[head];
        while (head<tail){
            mid=(head+tail)/2;
            if (nums[mid]>nums[mid+1]) return nums[mid+1];
            if (nums[mid]>nums[head]){
                head=mid;
            }else {
                tail=mid;
            }
        }
        return nums[mid];
    }
}