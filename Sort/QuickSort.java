import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by denghanxiao on 2017/5/22.
 */
public class QuickSort {
    public static void sort(int[] nums){
        sort(nums,0,nums.length-1);
    }
    public static void sort(int[] nums, int start, int end){
        if (start>=end) return;
        int[] x = new int[end-start+1];
        int i=0, j=x.length-1, flag=nums[start];
        for (int k = start+1; k <= end; k++)
            if (nums[k] > flag) {
                x[j] = nums[k];
                j--;
            } else {
                x[i] = nums[k];
                i++;
            }
        x[i] = flag;
        System.arraycopy(x,0,nums,start,x.length);
        sort(nums,start,start+i-1);
        sort(nums,start+i+1,end);
    }

    public static void sort(List<Integer> list){
        if (list.size()==0) return;
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        int flag = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)>flag){
                big.add(list.get(i));
            }else {
                small.add(list.get(i));
            }
        }
        sort(small);
        sort(big);
        small.add(flag);
        list.clear();
        list.addAll(small);
        list.addAll(big);
        return;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(5);
        a.add(4);
        a.add(3);
        a.add(2);
        sort(a);
        System.out.println(a);
    }
}
