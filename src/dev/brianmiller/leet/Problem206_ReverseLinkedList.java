package dev.brianmiller.leet;

public class Problem206_ReverseLinkedList {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions
     * for Reverse Linked List.
     *
     * Memory Usage: 42.1 MB, less than 94.16% of Java online submissions
     * for Reverse Linked List.
     */
    public static ListNode reverseList_iterative(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(head.val);
        ListNode tmp = head.next;
        while (tmp != null) {

            ListNode newNode = new ListNode(tmp.val);
            newHead = insertAtFront(newHead, newNode);

            tmp = tmp.next;
        }
        return newHead;
    }

    private static ListNode insertAtFront(ListNode oldHead, ListNode newHead) {
        newHead.next = oldHead;
        return newHead;
    }
}
