package dev.brianmiller.leet;

public class GooglePrep_MinStack {

        class Node {
            private int val;
            private int minimum;
            private Node next;

            public Node(int val, int minimum) {
                this.val = val;
                this.minimum = minimum;
                this.next = null;
            }
            public int getValue() {
                return val;
            }
            public int getMinimum() {
                return minimum;
            }
            public void setNext(Node next) {
                this.next = next;
            }
            public Node getNext() {
                return next;
            }
        }

        private Node top;
        // private Node min;

        public GooglePrep_MinStack() {
            top = null;
        }

        public void push(int val) {
            if (top == null) {
                Node newNode = new Node(val, val);
                top = newNode;
            } else {
                int newMin = Math.min(val, topsMin());
                Node newNode = new Node(val, newMin);
                newNode.setNext(top);
                top = newNode;
            }
        }

        public void pop() {
            Node newTop = top.getNext();
            top.setNext(null);
            top = newTop;
        }

        public int top() {
            return top.getValue();
        }

        private int topsMin() {
            return top.getMinimum();
        }

        public int getMin() {
            return topsMin();
        }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
