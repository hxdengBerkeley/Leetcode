public class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        combinei(result,now,n,k);
        return result;
    }
    public static void combinei(List<List<Integer>> result,List<Integer> now ,int n, int k){
        if (now.size()==k){
            result.add(now);
            return;
        }else if(now.size()==0){
            for (int i = 1; i <=n-k+1; i++) {
                List<Integer> nowi = new ArrayList<>(now);
                nowi.add(i);
                combinei(result,nowi,n,k);
            }
            return;
        }else {
            for (int i = now.get(now.size()-1)+1; i <=n+now.size()+1-k ; i++) {
                List<Integer> nowi = new ArrayList<>(now);
                nowi.add(i);
                combinei(result,nowi,n,k);
            }
            return;
        }
    }
}