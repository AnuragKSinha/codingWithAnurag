/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=reverse(slow);
        fast=head;
        while(slow!=null){
            if(slow.val!=fast.val)
                return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
                return head;
        ListNode prev=null;
        ListNode curr=head;
        ListNode nxt=curr.next;
        while(nxt!=null){
            curr.next=prev;
            prev=curr;
            curr=nxt;
            nxt=nxt.next;
        }
        curr.next=prev;
        return curr;
    }
}