package Lists.Queue;

public class Queue {

    private QueueNode first;
    private QueueNode last;
    private int length;

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public void enqueue(String value) {
        QueueNode newNode = new QueueNode(value);
        if (isEmpty()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }
        this.last = newNode;
        this.length++;
    }

    public Object dequeue() {
        if (isEmpty()){
            return null;
        }
        if (this.first == this.last){
            this.last.setNext(null);
        }
        QueueNode holdingNode = this.first;
        this.first = this.first.getNext();
        this.length--;
        return holdingNode;
    }

    public QueueNode peek() {
        return this.first;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
    }
}
