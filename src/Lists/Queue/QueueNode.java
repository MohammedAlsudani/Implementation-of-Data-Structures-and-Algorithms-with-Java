package Lists.Queue;

public class QueueNode {
    private String value;
    private QueueNode next;

    public QueueNode(String value) {
        this.value = value;
        this.next = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "QueueNode{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }
}
