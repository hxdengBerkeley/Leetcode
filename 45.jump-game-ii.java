public class Solution {
    public int jump(int[] nums) {
        if (nums.length<2) return 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Set<Integer> marked = new HashSet<>();
        int now=0,level=0, target=nums.length-1,levelend=0;
        queue.add(now);marked.add(now);
        while(now<nums.length){
            now = queue.poll();
            for (int i = Math.min(nums.length-1,now+nums[now]); i >=now+1; i--) {
                if(i==target) return level+1;
                if (!marked.contains(i)) {
                    marked.add(i);
                    queue.add(i);
                }
            }
            if (now==levelend) {
                levelend=queue.peekLast();
                level++;
            }
        }
        return 0;
    }
}