package DSA.LinkedList;
/**
 * https://leetcode.com/problems/add-two-numbers/
 * Time Complexity: O(n+m)
 * Space Complexity: O(n+m)
 * where n and m are the size of input Linked List
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        int carry=0;
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode curr=new ListNode();
        ListNode head=curr;
        while(temp1!=null || temp2!=null){
            int a=temp1==null?0:temp1.val;
            int b=temp2==null?0:temp2.val;
            int sum=(a+b+carry)%10;
            carry=(a+b+carry)/10;
            ListNode node=new ListNode(sum);
            curr.next=node;
            curr=curr.next;
            if(temp1!=null)
                temp1=temp1.next;
            if(temp2!=null)
                temp2=temp2.next;
        }
        if(carry!=0){
             ListNode node=new ListNode(carry);
             curr.next=node;
        }
        return head.next;
    }
}