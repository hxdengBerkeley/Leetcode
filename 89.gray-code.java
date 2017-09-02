public class Solution {
    public List<Integer> grayCode(int n) {
        List<List<Integer>> resulti = new ArrayList<>();
        List<Integer> biti = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            biti.add(0);
        }
        resulti.add(biti);
        grayCodei(resulti,biti,n);
        return bi2ten(resulti);
    }

    public void grayCodei(List<List<Integer>> resulti, List<Integer> biti, int n){
        if (resulti.size()==Math.pow(2,n)){
            return;
        }else {
            for (int i = biti.size()-1; i >=0; i--) {
                List<Integer> biticpy = new ArrayList<>(biti);
                biticpy.set(i,1-biti.get(i));
                if (!resulti.contains(biticpy)){
                    resulti.add(biticpy);
                    grayCodei(resulti,biticpy,n);
                    break;
                }
            }
        }
    }

    public List<Integer> bi2ten(List<List<Integer>> resulti){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < resulti.size(); i++) {
            int x=0;
            for (int j = 0; j <resulti.get(i).size() ; j++) {
                x=2*x+resulti.get(i).get(j);
            }
            result.add(x);
        }
        return result;
    }


    /**for all grayCode
    public void grayCodei(List<Integer> result, List<List<Integer>> resulti, List<Integer> biti, int n){
        if (resulti.size()==Math.pow(2,n)){
            result.add(bi2ten(resulti));
        }else {
            for (int i = 0; i < biti.size(); i++) {
                List<Integer> biticpy = new ArrayList<>(biti);
                biticpy.set(i,1-biti.get(i));
                if (!resulti.contains(biticpy)){
                    List<List<Integer>> resulticpy = new ArrayList<>(resulti);
                    resulticpy.add(biticpy);
                    grayCodei(result,resulticpy,biticpy,n);
                }
            }
        }
    }

    public int bi2ten(List<List<Integer>> resulti){
        int result = 0;
        for (int i = 0; i < resulti.size(); i++) {
            int x=0;
            for (int j = 0; j <resulti.get(i).size() ; j++) {
                x=2*x+resulti.get(i).get(j);
            }
            result=10*result+x;
        }
        return result;
    }*/
}