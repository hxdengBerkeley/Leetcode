public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1cpy = nums1.clone();
        int i=0,j=0;
        for (int k = 0; k < m+n; k++) {
            if (i==m){
                System.arraycopy(nums2,j,nums1,k,n-j);
                break;
            }
            if (j==n){
                System.arraycopy(nums1cpy,i,nums1,k,m-i);
                break;
            }
            if (nums1cpy[i]<nums2[j]) {
                nums1[k]=nums1cpy[i];
                i++;
            }else {
                nums1[k]=nums2[j];
                j++;
            }
        }
        return;
    }
}