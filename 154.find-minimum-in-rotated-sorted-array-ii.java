class Solution {
    public int findMin(int[] nums) {
        int head=0,tail=nums.length-1,mid=(head+tail)/2;
        if (nums[head]<nums[tail]) return nums[head];
        while (head<tail){
            mid=(head+tail)/2;
            if (nums[mid]>nums[mid+1]) return nums[mid+1];
            if (nums[mid]>nums[head]){
                head=mid;
            }else if (nums[mid]<nums[head]){
                tail=mid;
            }else {
                int[] left = new int[mid-head];
                int[] right = new int[tail-mid];
                System.arraycopy(nums,head,left,0,left.length);
                System.arraycopy(nums,mid+1,right,0,right.length);
                if (left.length!=0) return Math.min(findMin(left),findMin(right));
                else return findMin(right);
            }
        }
        return nums[mid];
    }
}