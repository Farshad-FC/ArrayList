package ir.maktab74.domain;

public class Node<T> {
    private T data;
    private Node nextNode;

    public Node(T data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
