package DSA.LinkedList;
/**
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
 * If the total number of nodes in the LinkedList is even, return the second middle node.
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
class ListNode {
    int value = 0;
    ListNode next;
  
    ListNode(int value) {
      this.value = value;
    }
  }
  
  class MiddleOfLinkedList {
  
    public static ListNode findMiddle(ListNode head) {
      if(head==null || head.next==null)
          return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
        }
      return slow;
    }
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
  
      head.next.next.next.next.next = new ListNode(6);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
  
      head.next.next.next.next.next.next = new ListNode(7);
      System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }
  }