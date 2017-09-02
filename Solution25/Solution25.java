/**
 * Created by denghanxiao on 2017/5/12.
 */
public class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if( head==null || head.next == null ) return head;
        ListNode result = new ListNode(1); result.next=head;
        ListNode end=result;

        do{
            end = reverseK(end, end.next, k);
        }while(end!=null);
        return result.next;
    }

    public static ListNode reverseK(ListNode end, ListNode head, int k){
        if(size(head)<k) return null;
        ListNode node=head,nexthead;
        for(int j=1; j<k; j++){
            node=node.next;
        }
        end.next = node; end = end.next;
        nexthead = node.next;
        for(int i=k-1; i>0; i--){
            node = head;
            for(int j=1; j<i; j++){
                node = node.next;
            }
            end.next = node;
            end = end.next;
        }
        head.next = nexthead;
        return head;
    }

    public static int size(ListNode head){
        if(head==null) return 0;
        return size(head.next)+1;
    }
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        ListNode c = reverseKGroup(a,2);
        System.out.print(c.next.val);
    }

}
