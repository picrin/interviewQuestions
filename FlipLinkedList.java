public class FlipLinkedList {
private static class Node {
    private int value;
    private Node child;
    public Node(int value) {
        this.value = value;
        child = null;
    }
    public Node addNode(int value) {
        child = new Node(value);
        return child;
    }
    @Override
    public String toString() {
        return value + " ";
    }
    public String walkList() {
        if (child == null) {
            return this.toString();
        }
        return this.toString() + this.child.walkList();
    }
    public void flipList() {
        Node previous = this;
        Node current = previous.child;
        previous.child = null;
        Node next;
        while (current != null) {
            next = current.child;
            current.child = previous;
            previous = current;
            current = next; 
        }
    }
}
    public static void main(String[] args) {
        Node head = new Node(1);
        Node tail = head.addNode(4);
        tail = tail.addNode(5);
        tail = tail.addNode(7);
        System.out.println(head.walkList());
        head.flipList();
        System.out.println(tail.walkList());
    }
}

