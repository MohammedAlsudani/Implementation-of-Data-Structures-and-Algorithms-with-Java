package kotlin.linkedList

class LinkedListExample {

    // Node class
    data class Node(var data: Int, var next: Node? = null)

    private var head: Node? = null

    // Insert a new element at the end
    fun append(data: Int) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = newNode
    }

    // Insert a new element at the beginning
    fun prepend(data: Int) {
        val newNode = Node(data)
        newNode.next = head
        head = newNode
    }

    // Print the linked list
    fun printList() {
        var current = head
        while (current != null) {
            print("${current.data} -> ")
            current = current.next
        }
        println("null")
    }

    // Find the length of the linked list
    fun length(): Int {
        var count = 0
        var current = head
        while (current != null) {
            count++
            current = current.next
        }
        return count
    }

    /**
     * Reverse the linked list in-place
     * Time Complexity: O(n)
     */
    fun reverse() {
        var prev: Node? = null
        var current = head
        var next: Node?

        while (current != null) {
            next = current.next   // Save next node
            current.next = prev   // Reverse pointer
            prev = current        // Move prev forward
            current = next        // Move current forward
        }

        head = prev  // Update head to new first node
    }
}

fun main() {
    val list = LinkedListExample()

    println("=== LinkedList Operations ===")
    list.append(10)
    list.append(20)
    list.append(30)
    list.printList() // 10 -> 20 -> 30 -> null

    println("=== Reversing LinkedList ===")
    list.reverse()
    list.printList() // 30 -> 20 -> 10 -> null
}
