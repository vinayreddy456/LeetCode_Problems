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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n==0){
            return head;
        }
        if(head.next==null && n==1){
             head=head.next;
        }
        else{
        ListNode ref=head;
        ListNode main=head;
        while(n-->0){
            ref=ref.next;
        }
        ListNode temp=null;
        while(ref!=null){
            temp=main;
            main=main.next;
            ref=ref.next;

        }
        if(main.next==null){
            temp.next=null;
        }
        else if(temp==null){
            head=head.next;
        }
        else{
             temp.next=main.next;
        }
        System.out.println(main.val);
        }
        
       // temp.next=ref;
        return head;
    }
}