/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    Map<RandomListNode,RandomListNode> map;
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        map = new HashMap<>();
        RandomListNode now = head;
        while (now.next!=null){
            if (!map.containsKey(now)) map.put(now,new RandomListNode(now.label));
            if (!map.containsKey(now.next)) map.put(now.next,new RandomListNode(now.next.label));
            map.get(now).next=map.get(now.next);
            if (now.random==null){
                map.get(now).random=null;
            }else {
                if (!map.containsKey(now.random)) map.put(now.random,new RandomListNode(now.random.label));
                map.get(now).random=map.get(now.random);
            }
            now=now.next;
        }
        if (!map.containsKey(now)) map.put(now,new RandomListNode(now.label));
        map.get(now).next = null;
        if (now.random==null){
            map.get(now).random=null;
        }else {
            if (!map.containsKey(now.random)) map.put(now.random,new RandomListNode(now.random.label));
            map.get(now).random=map.get(now.random);
        }
        return map.get(head);
    }
}