import java.util.Stack;

public class LeetCode430 {
    public static void main(String[] args) {

    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        g(head, new Stack<>());
        return head;
    }

    public void g(Node node, Stack<Node> nodes) {
        if (node.next != null) {
            if (node.child == null) {
                g(node.next, nodes);
            } else {
                nodes.push(node.next);
                node.child.prev = node;
                node.next = node.child;
                node.child = null;
                g(node.next, nodes);
            }
        } else if (node.child != null) {
            node.child.prev = node;
            node.next = node.child;
            node.child = null;
            g(node.next, nodes);
        } else if (!nodes.isEmpty()) {
            Node pop = nodes.pop();
            node.next = pop;
            pop.prev = node;
            g(node.next, nodes);
        }
    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
