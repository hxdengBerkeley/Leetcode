/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if(intervals.size()==0) return result;
    	sort(intervals);
		result.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			if(intervals.get(i).start<=result.get(result.size()-1).end){
				result.set(result.size()-1, new Interval(result.get(result.size()-1).start, Math.max(intervals.get(i).end,result.get(result.size()-1).end)));
			}else {
				result.add(intervals.get(i));
			}
		}
		return result;
    }

	public void sort(List<Interval> intervals){
		if (intervals.size()==0) return;
		List<Interval> small = new ArrayList<>();
		List<Interval> big = new ArrayList<>();
		Interval flag = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if(intervals.get(i).start>flag.start){
				big.add(intervals.get(i));
			}else {
				small.add(intervals.get(i));
			}
		}
		sort(small);
		sort(big);
		small.add(flag);
		intervals.clear();
		intervals.addAll(small);
		intervals.addAll(big);
		return;
	}
}
