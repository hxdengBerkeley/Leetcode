public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> resultPre = new ArrayList<>(result);
            result.clear();
            for (int j = 0; j <= i; j++) {
                if (j==0){
                    result.add(1);
                }else if (j==i){
                    result.add(1);
                }else {
                    result.add(resultPre.get(j-1)+resultPre.get(j));
                }
            }
        }
        return result;
    }
}