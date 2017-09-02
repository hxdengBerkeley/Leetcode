public class Solution4 {
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n){
            return findMedianSortedArrays(nums2,nums1);
        }
        if (m==0){
            return (double)(nums2[(n-1)/2]+nums2[n/2])/2.0;
        }
        int low = 0, high = m;
        int i = (low+high)/2;
        int j = (m+n+1)/2-i;
        double maxOfLeft,minOfRight,result=-9999.0;
        while(low<=high){
            if ((i==0||j==n||nums1[i-1]<=nums2[j])&&(i==m||j==0||nums1[i]>=nums2[j-1])) {
                if(i==0){
                    maxOfLeft = (double)nums2[j-1];
                }else{
                    if (j==0) {
                        maxOfLeft = (double)nums1[i-1];
                    }else {
                        maxOfLeft = (double)Math.max(nums1[i-1],nums2[j-1]);                    
                    }
                }
                if(i==m){
                    minOfRight = (double)nums2[j];
                }else {
                    if (j==n) {
                        minOfRight = nums1[i];
                    }else {
                        minOfRight = Math.min(nums1[i],nums2[j]);
                    }
                }
                if((m+n)/2*2<(m+n)){    //return result
                    result = maxOfLeft;
                    break;
                }else {
                    result = (maxOfLeft+minOfRight)/2.0;
                    break;
                }
            }else{
                if (i==m||j==0||nums1[i]<nums2[j-1]) {
                    low = i+1;
                }else{
                    if (i==0||j==n||nums1[i-1]>nums2[j]) {
                        high = i-1;
                    }                       
                }
                i = (low+high)/2;
                j = (m+n+1)/2-i;
            }
        }
        return result;
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        return findMedianSortedArrays(twoSortedArrays2one(nums1,nums2));
    }
    
    public static int[] twoSortedArrays2one(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length+nums2.length];
        for (int k=0,i=0,j=0; k<result.length; k++) {
            if (nums1[i]<nums2[j]) {
                result[k]=nums1[i];
                i++;
            }else {
                result[k]=nums2[j];
                j++;
            }
            if(i==nums1.length){
                k++;
                System.arraycopy(nums2,j,result,k,result.length-k);
                break;
            }
            if(j==nums2.length){
                k++;
                System.arraycopy(nums1,i,result,k,result.length-k);
                break;
            }
        }
        return result;
    }

    public static double findMedianSortedArrays(int[] nums){
        return (double)((nums[(nums.length-1)/2]+nums[nums.length/2]))/2.0;
    }

    public static void printArray(int[] nums){
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays1(nums1,nums2));
    }


}