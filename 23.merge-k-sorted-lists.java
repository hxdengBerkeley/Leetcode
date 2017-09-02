/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

    	if(lists.length==0) return null;
        ListNode result,end;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        for(int i = 0; i<lists.length; i++){
	    	if(lists[i]==null) continue;
            queue.add(lists[i]);
    	}
	    if(queue.size()==0) return null;
    	result = queue.peek(); end = result;
    	if(queue.peek().next==null){
    	    queue.poll();
        }else {
            queue.add(queue.poll().next);
        }
	    while(queue.size()!=0){
            end.next = queue.peek();
            if(queue.peek().next==null){
                queue.poll();
            }else {
                queue.add(queue.poll().next);
            }
            end = end.next;
        }
        return result;
    }
}
