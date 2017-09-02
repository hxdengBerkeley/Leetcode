public class Solution {
    public String minWindow(String s, String t) {
        ArrayList<Integer> queuei = new ArrayList<>(t.length());
        ArrayList<Character> queuet = new ArrayList<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            queuet.add(t.charAt(i));
        }
        ArrayList<Character> queue = new ArrayList<>();
        int i=0;
        while(i<s.length()) {
            if (queuet.contains(s.charAt(i))){
                queuet.remove((Character)s.charAt(i));
                queue.add(s.charAt(i));
                queuei.add(i);
            }else if (queue.contains(s.charAt(i))){
                int index = queue.indexOf(s.charAt(i));
                queue.remove(index);
                queue.add(s.charAt(i));
                queuei.remove(index);
                queuei.add(i);
            }
            if (queue.size()==t.length()){
                break;
            }else{
                i++;
            }
        }
        if (queuei.size()!=t.length()){
            return "";
        }else{
            i++;
            int start =queuei.get(0),end=queuei.get(queuei.size()-1),min=end-start;
            for (int index:queuei) {
                queuet.add(s.charAt(index));
            }
            while(i<s.length()) {
                if (queuet.contains(s.charAt(i))) {
                    int index = queuet.indexOf(s.charAt(i));
                    queuet.remove(index);
                    queuet.add(s.charAt(i));
                    queuei.remove(index);
                    queuei.add(i);
                    if (queuei.get(queuei.size()-1)-queuei.get(0)<min){
                        start =queuei.get(0);
                        end=queuei.get(queuei.size()-1);
                        min=end-start;
                    }
                }
                i++;
            }
            return s.substring(start,end+1);
        }
    }
}