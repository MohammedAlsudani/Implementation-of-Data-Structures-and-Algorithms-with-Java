package Lists.Queue;

public class QueueExample {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue("james");
        queue.enqueue("matt");
        queue.enqueue("andree");
        queue.enqueue("jenny");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
    }

}
