class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n<2) return 0;
        int max = nums[0],min = nums[0];
        for (int x:nums) {
            max = Math.max(max,x);
            min = Math.min(min,x);
        }
        int[] xmin = new int[nums.length];
        int[] xmax = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            xmin[i]=-1;
            xmax[i]=-1;
        }
        int gap = (max-min)/(nums.length-1)+1;
        if (gap==0) return 0;

        for (int x:nums) {
            int index =  (x-min)/gap;
            if (xmin[index]==-1){
                xmin[index]=x;
                xmax[index]=x;
            }else {
                xmin[index] = Math.min(xmin[index],x);
                xmax[index] = Math.max(xmax[index],x);
            }
        }
        int maxindex = 0, minindex = 1, result = 0;

        while(maxindex<nums.length){
            if (xmax[maxindex]==-1){
                maxindex++;
                continue;
            }else {
                result = Math.max(xmax[maxindex]-xmin[maxindex],result);
                minindex=maxindex+1;
                while(minindex<nums.length){
                    if (xmin[minindex]==-1){
                        minindex++;
                        continue;
                    }else {
                        result = Math.max(xmax[minindex]-xmin[minindex],result);
                        result = Math.max(xmin[minindex]-xmax[maxindex],result);
                        maxindex=minindex;
                        break;
                    }
                }
                maxindex=minindex;
            }
        }
        return result;
    }}