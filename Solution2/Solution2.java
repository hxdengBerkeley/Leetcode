public class Solution2{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 		ListNode result = new ListNode((l1.val+l2.val)%10);
 		ListNode l = result;
 		int number1,number2,number3,sum;
 		sum=l1.val+l2.val;
 		while(l1.next!=null||l2.next!=null){
 			if(l1.next == null){
 				number1 = 0;
 			}else {
 				l1=l1.next;
 				number1 = l1.val;
 			}
 			if(l2.next == null){
 				number2 = 0;
 			}else {
 				l2=l2.next;
 				number2 = l2.val;
 			}

 			sum = number1 + number2 + sum/10;
 			number3 = sum % 10;
 			l.next = new ListNode(number3);
 			l = l.next;
 		}
 		if (sum > 9){
 			l.next = new ListNode(1);
 			l = l.next;
 		}
 		return result;
    }

    public static int listNode2Number(ListNode l){
        int value,i;
        ListNode list = l;
        value=list.val;
        i=10;
        while(list.next!=null){
            value=value+i*list.next.val;
            i=i*10;
            list=list.next;
        }
        return value;
    }

    public static ListNode number2ListNode(int x){
    	ListNode result = new ListNode(x%10);
    	ListNode l = result;
    	int y = x/10;
    	while(y!=0){
    		l.next = new ListNode(y%10);
    		l = l.next;
    		y=y/10;
    	}
    	return result;
    }

    public static void main(String[] args) {
    	ListNode l1 = number2ListNode(5);
    	ListNode l2 = number2ListNode(5);
    	System.out.println(listNode2Number(addTwoNumbers(l1,l2)));
    }
}