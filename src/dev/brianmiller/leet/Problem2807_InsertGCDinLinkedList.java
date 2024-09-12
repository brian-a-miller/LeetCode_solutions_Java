package dev.brianmiller.leet;
/*
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
*/

/**
 * https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
 */
public class Problem2807_InsertGCDinLinkedList {



    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode gcdNode = new ListNode(getGCD(current.val, next.val));
            gcdNode.next = next;
            current.next = gcdNode;
            current = next;
            next = current.next;
        }

        return head;
    }

    private static int getGCD(int a, int b) {
        int c = Math.min(a, b);
        while (c > 0) {
            if ((a % c == 0) && (b % c == 0)) {
                return c;
            }
            c--;
        }
        return c;
    }
}
