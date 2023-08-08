/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy,next=dummy,cur=dummy;
        dummy.next=head;
        int count=0;
        ListNode Cur=head;
        while(cur.next!=null){
            count++;
            cur=cur.next;
        }
        while(count>=k){
            cur=prev.next;
            next=cur.next;
            for(int i=1;i<k;i++){
                 cur.next=next.next;
                 next.next=prev.next;
                 prev.next=next;
                 next=cur.next;
            }
            count-=k;
            prev=cur;
        }
        return dummy.next;
    }
}