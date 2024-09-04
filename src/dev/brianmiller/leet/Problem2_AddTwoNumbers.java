package dev.brianmiller.leet;

/**
 * Solution in Java to the problem from
 *
 *     https://leetcode.com/problems/add-two-numbers/
 *
 * With description:
 *
 * "You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.  You may assume the two numbers do not contain any leading zero, except
 * the number 0 itself."
 *
 * "Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading
 * zeros."
 *
 */
public class Problem2_AddTwoNumbers {

    /**
     * @author Brian A. Miller
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode last = null;
        if (l1 != null && l2 != null) {
            ListNode a = l1;
            ListNode b = l2;
            int carry = 0;
            while (a != null || b != null) {
                int tmpSum = (a == null ? 0 : a.val) +
                             (b == null ? 0 : b.val) + carry;
                // System.out.printf("a.val=%d, b.val=%d, carry=%d, tmpSum=%d%n", a.val, b.val, carry, tmpSum);
                if (tmpSum <= 9) {
                    carry = 0;
                } else {
                    carry = tmpSum / 10;
                    tmpSum = tmpSum % 10;
                }
                if (result == null) {
                    result = new ListNode(tmpSum);
                    last = result;
                } else {
                    ListNode newNode = new ListNode(tmpSum);
                    last.next = newNode;
                    last = last.next;
                }
                if (a != null) {
                    a = a.next;
                }
                if (b != null) {
                    b = b.next;
                }
            }
            if (carry > 0) {
                ListNode newNode = new ListNode(carry);
                last.next = newNode;
                last = last.next;
            }
        }
        return result;
        
    }
}

