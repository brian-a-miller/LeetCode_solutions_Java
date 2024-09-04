package dev.brianmiller.leet;

/*
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
*/

/**
 * LeetCode problem "19. Remove Nth Node From End of List"
 * as described at
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Problem19_RemoveNthNodeFromEndOfList {



    /*
     * @author Brian A. Miller
     * @date August 21, 2024
     *
     * LeetCode Status: Accepted
     * LeetCode Submission Detail:
     *     Status: Accepted
     *     208 / 208 test cases passed.
     *     Runtime: 12 ms
     *     Memory Usage: 42 MB
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        int nodesFound = 0;
        // TODO: remove special cases that are not actually needed
        if ((n == 1) && (head.next == null)) {
            return null;
        } else if ((n == 2) && (head.next.next == null)) {
            return head.next;
        } else if ((n == 3) && (head.next.next.next == null)) {
            return head.next;
        }
        ListNode[] endNodes = new ListNode[n+1];
        ListNode currentNode = head;
        while (currentNode != null) {
            nodesFound++;
            for (int i = 0; i < n; i++) {
                endNodes[i] = endNodes[i+1];
            }
            endNodes[n] = currentNode;
            currentNode = currentNode.next;
        }
        for (int i = 0; i < n+1; i++) {
            System.out.print((endNodes[i] == null ? "null" : endNodes[i].val) + " ");
        }
        System.out.println();

        if (nodesFound == n) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        if ((endNodes[0] != null) && (endNodes[1] != null)) {
            endNodes[0].next = endNodes[1].next;
            endNodes[1].next = null;
        }
        return head;
    }
}
