package kotlin.queue
/**
 * Demonstrates how to implement and use a Queue in Kotlin.
 *
 * Queue:
 * - Follows FIFO (First In, First Out) principle.
 * - Main operations:
 *      enqueue(item) → add to back
 *      dequeue() → remove from front
 *      peek() → view front element
 *      isEmpty() → check if empty
 *
 * We can implement a queue using:
 * - ArrayDeque (efficient for queue operations)
 */
class QueueExample<T> {

    private val items = ArrayDeque<T>()

    // Add to back of the queue
    fun enqueue(item: T) {
        items.addLast(item)
    }

    // Remove from front of the queue
    fun dequeue(): T? {
        if (isEmpty()) return null
        return items.removeFirst()
    }

    // View the front item without removing
    fun peek(): T? {
        return items.firstOrNull()
    }

    // Check if queue is empty
    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    // Get size of queue
    fun size(): Int {
        return items.size
    }

    // Print the queue (front at left)
    fun printQueue() {
        println(items.joinToString(" <- "))
    }

    /**
     * Algorithm Example:
     * Simulate processing tasks in order using a queue.
     */
    fun processTasks(tasks: List<String>) {
        val queue = QueueExample<String>()

        // Add all tasks to the queue
        for (task in tasks) {
            queue.enqueue(task)
        }

        println("Processing tasks in order:")
        while (!queue.isEmpty()) {
            val currentTask = queue.dequeue()
            println("Processing: $currentTask")
        }
    }
}

/**
 * Main function to test the queue
 */
fun main() {
    val queue = QueueExample<Int>()

    println("=== Queue Operations ===")
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    queue.printQueue() // 10 <- 20 <- 30

    println("Dequeued: ${queue.dequeue()}") // 10
    println("Front item: ${queue.peek()}") // 20
    println("Queue size: ${queue.size()}")

    println("\n=== Task Processing Example ===")
    val taskQueue = QueueExample<String>()
    taskQueue.processTasks(listOf("Task1", "Task2", "Task3"))
}
