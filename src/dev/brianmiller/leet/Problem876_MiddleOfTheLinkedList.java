package dev.brianmiller.leet;

/**
 * My Java solution for the problem described at
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @author Brian A. Miller
 * @date Monday, November 4, 2024
 */
public class Problem876_MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode iNode = head;
        int iPosition = 1;
        ListNode jNode = head;
        int jPosition = 1;
        while (jNode.next != null) {
            jNode = jNode.next;
            jPosition++;
            iNode = iNode.next;
            iPosition++;
            if (jNode.next != null) {
                jNode = jNode.next;
                jPosition++;
            }
        }

        return iNode;
    }

}
