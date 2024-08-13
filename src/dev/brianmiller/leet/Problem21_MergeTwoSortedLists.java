package dev.brianmiller.leet;

public class Problem21_MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        if ((list1 == null) && (list2 == null)) {
            return null; //newHead;
        }
        ListNode newTail = null;
        ListNode a = list1;
        ListNode b = list2;
        while ((a != null) || (b != null)) {
            int nextValue;
            if (a == null) {
                nextValue = b.val;
                b = b.next;
            } else if (b == null) {
                nextValue = a.val;
                a = a.next;
            } else if (a.val <= b.val) {
                nextValue = a.val;
                a = a.next;
            } else {
                nextValue = b.val;
                b = b.next;
            }
            if (newTail == null) {
                newHead.val = nextValue;
                newTail = newHead;
            } else {
                ListNode newTailNode = new ListNode(nextValue);
                newTail.next = newTailNode;
                newTail = newTail.next;
            }
        }
        return newHead;
        
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
