package dev.brianmiller.leet;

import java.util.EmptyStackException;

public class MaxStack {

    class Node {

        private final int value;
        private final int maximum;
        private Node next;

        public Node(int value, int maximum) {
            this.value = value;
            this.maximum = maximum;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public int getMaximum() {
            return maximum;
        }
    }

    private Node topOfStack;

    public MaxStack() {
        topOfStack = null;
    }

    public void push(int value) {

        if (topOfStack == null) {
            Node newTop = new Node(value, value);
            return;
        }

        int oldMaximum = topOfStack.getMaximum();
        Node newTop = new Node(value, Math.max(value, oldMaximum));
        newTop.setNext(topOfStack);
        topOfStack = newTop;
    }

    public int pop() {
        if (topOfStack == null) {
            throw new EmptyStackException();
       }
        Node oldTop = topOfStack;
        int val = oldTop.getValue();
        topOfStack = topOfStack.getNext();
        oldTop.setNext(null);
        return val;
    }

    public int max() {
        if (topOfStack == null) {
            throw new EmptyStackException();
        }
        return topOfStack.getMaximum();
    }
}
