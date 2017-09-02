public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            int carGas = 0;
            boolean a=true,b=true;
            for (int now = start; now < gas.length; now++) {
                carGas+=gas[now];
                if (carGas<cost[now]) {
                    a=false;
                    break;
                }
                carGas-=cost[now];
            }
            if (!a) continue;
            for (int now = 0; now < start; now++) {
                carGas+=gas[now];
                if (carGas<cost[now]) {
                    b=false;
                    break;
                }
                carGas-=cost[now];
            }
            if (!b) continue;
            return start;
        }
        return -1;
    }
}