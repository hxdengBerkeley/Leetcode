/**
 * Created by denghanxiao on 2017/5/10.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int k,l,now;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                k = j+1; l=nums.length-1;
                while(k<l){
                    now = nums[i]+nums[j]+nums[k]+nums[l];
                    if(now == target) result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                    if(now<target) k++;
                    if(now>target) l--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] a = {-1,0,1,0};
        System.out.println(fourSum(a,0));
    }
}
