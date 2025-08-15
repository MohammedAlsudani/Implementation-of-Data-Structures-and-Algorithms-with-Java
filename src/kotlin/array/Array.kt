package kotlin.array

import java.util.LinkedList
import java.util.ArrayDeque
import java.util.PriorityQueue
import java.util.concurrent.CopyOnWriteArrayList

fun main() {
    println("=== KOTLIN COLLECTIONS COMPREHENSIVE DEMO ===\n")

    demoImmutableList()
    println("\n" + "=".repeat(50) + "\n")

    demoMutableList()
    println("\n" + "=".repeat(50) + "\n")

    demoArrayList()
    println("\n" + "=".repeat(50) + "\n")

    demoLinkedList()
    println("\n" + "=".repeat(50) + "\n")

    demoArrayDeque()
    println("\n" + "=".repeat(50) + "\n")

    demoPriorityQueue()
    println("\n" + "=".repeat(50) + "\n")

    demoCopyOnWriteArrayList()

    printCollectionComparison()
}

// IMMUTABLE LIST - Read-only collection, cannot be modified after creation
fun demoImmutableList() {
    println("🔒 IMMUTABLE LIST DEMO")
    println("Characteristics: Read-only, thread-safe, memory efficient")
    println("Time Complexity: Access O(1), Search O(n)")

    // Creation methods
    val list1 = listOf("A", "B", "C", "D", "E")
    val list2 = listOf<String>() // Empty list
    val list3 = emptyList<String>() // Another way to create empty list

    println("\nCreation:")
    println("listOf(): $list1")
    println("Empty list: $list2")

    // Access operations - O(1)
    println("\nAccess Operations (O(1)):")
    println("First element: ${list1.first()}")
    println("Last element: ${list1.last()}")
    println("Element at index 2: ${list1[2]}")
    println("Get element safely: ${list1.getOrNull(10)}")
    println("Get with default: ${list1.getOrElse(10) { "Default" }}")

    // Size and emptiness checks - O(1)
    println("\nSize Operations (O(1)):")
    println("Size: ${list1.size}")
    println("Is empty: ${list1.isEmpty()}")
    println("Is not empty: ${list1.isNotEmpty()}")

    // Search operations - O(n)
    println("\nSearch Operations (O(n)):")
    println("Contains 'C': ${list1.contains("C")}")
    println("Index of 'C': ${list1.indexOf("C")}")
    println("Last index of 'C': ${list1.lastIndexOf("C")}")

    // Iteration methods
    println("\nIteration Methods:")
    print("forEach: ")
    list1.forEach { print("$it ") }
    println()

    print("forEachIndexed: ")
    list1.forEachIndexed { index, value -> print("$index:$value ") }
    println()

    // Transformation operations (return new collections)
    println("\nTransformation Operations:")
    val mapped = list1.map { it.lowercase() }
    println("map to lowercase: $mapped")

    val filtered = list1.filter { it > "B" }
    println("filter > 'B': $filtered")

    val sorted = list1.sorted()
    println("sorted: $sorted")

    val reversed = list1.reversed()
    println("reversed: $reversed")

    // Sublist operations
    println("\nSublist Operations:")
    println("subList(1,3): ${list1.subList(1, 3)}")
    println("take(3): ${list1.take(3)}")
    println("drop(2): ${list1.drop(2)}")
    println("slice(1..3): ${list1.slice(1..3)}")

    // Aggregate operations
    println("\nAggregate Operations:")
    val numbers = listOf(1, 2, 3, 4, 5)
    println("Numbers: $numbers")
    println("sum: ${numbers.sum()}")
    println("max: ${numbers.maxOrNull()}")
    println("min: ${numbers.minOrNull()}")
    println("average: ${numbers.average()}")
    println("count: ${numbers.count()}")
    println("count > 3: ${numbers.count { it > 3 }}")

    // Joining operations
    println("\nJoining Operations:")
    println("joinToString: ${list1.joinToString()}")
    println("joinToString with separator: ${list1.joinToString(" | ")}")
    println("joinToString with prefix/suffix: ${list1.joinToString(", ", "[", "]")}")
}

// MUTABLE LIST - Kotlin's standard mutable list (usually ArrayList underneath)
fun demoMutableList() {
    println("🔄 MUTABLE LIST DEMO")
    println("Characteristics: Resizable array, allows modifications")
    println("Time Complexity: Access O(1), Insert/Remove at end O(1) amortized, Insert/Remove middle O(n)")

    // Creation methods
    val list = mutableListOf("A", "B", "C")
    val emptyList = mutableListOf<String>()
    val listWithCapacity = ArrayList<String>(10) // Pre-allocated capacity

    println("\nInitial list: $list")

    // Addition operations
    println("\nAddition Operations:")
    list.add("D")                    // Add at end - O(1) amortized
    println("After add('D'): $list")

    list.add(0, "Start")            // Add at specific index - O(n)
    println("After add(0, 'Start'): $list")

    list.addAll(listOf("X", "Y"))   // Add multiple elements - O(m) where m is added elements
    println("After addAll: $list")

    list.addAll(2, listOf("P", "Q")) // Add multiple at index - O(n+m)
    println("After addAll at index 2: $list")

    // Update operations
    println("\nUpdate Operations:")
    list[1] = "UPDATED"              // Update by index - O(1)
    println("After update index 1: $list")

    list.fill("FILL")               // Fill all with same value - O(n)
    println("After fill: $list")

    // Restore list for other operations
    list.clear()
    list.addAll(listOf("A", "B", "C", "D", "E", "F"))

    // Removal operations
    println("\nRemoval Operations:")
    println("Current list: $list")

    list.remove("C")                // Remove by value - O(n)
    println("After remove('C'): $list")

    list.removeAt(0)                // Remove by index - O(n)
    println("After removeAt(0): $list")

    list.removeAll(listOf("D", "E")) // Remove multiple values - O(n*m)
    println("After removeAll: $list")

    list.retainAll(listOf("B", "F", "Z")) // Keep only specified elements - O(n)
    println("After retainAll: $list")

    // Restore list again
    list.clear()
    list.addAll(listOf("A", "B", "C", "D", "E"))

    val removed = list.removeFirst() // Remove first element - O(n)
    println("Removed first: $removed, List: $list")

    val removedLast = list.removeLast() // Remove last element - O(1)
    println("Removed last: $removedLast, List: $list")

    // Conditional removal
    list.removeIf { it > "B" }      // Remove elements matching predicate - O(n)
    println("After removeIf > 'B': $list")

    // List manipulation
    println("\nList Manipulation:")
    list.addAll(listOf("X", "Y", "Z", "A"))
    println("List: $list")

    list.sort()                     // Sort in place - O(n log n)
    println("After sort: $list")

    list.reverse()                  // Reverse in place - O(n)
    println("After reverse: $list")

    list.shuffle()                  // Shuffle randomly - O(n)
    println("After shuffle: $list")

    // Capacity operations (for ArrayList)
    if (list is ArrayList) {
        list.trimToSize()           // Reduce capacity to current size
        println("Trimmed to size")
    }

    // Bulk operations
    println("\nBulk Operations:")
    val otherList = mutableListOf("A", "B")
    println("Current list: $list")
    println("Other list: $otherList")
    println("containsAll(otherList): ${list.containsAll(otherList)}")

    // Iterator operations
    println("\nIterator Operations:")
    val iterator = list.iterator()
    print("Using iterator: ")
    while (iterator.hasNext()) {
        print("${iterator.next()} ")
    }
    println()

    // Mutable iterator for safe removal during iteration
    val mutableIterator = list.listIterator()
    println("Using mutable iterator to remove elements containing 'A':")
    while (mutableIterator.hasNext()) {
        val item = mutableIterator.next()
        if (item.contains("A")) {
            mutableIterator.remove()
        }
    }
    println("After iterator removal: $list")
}

// ARRAYLIST - Java-backed dynamic array implementation
fun demoArrayList() {
    println("📊 ARRAYLIST DEMO")
    println("Characteristics: Dynamic array, good for random access, poor for frequent insertions/deletions in middle")
    println("Time Complexity: Access O(1), Insert/Remove at end O(1) amortized, Insert/Remove middle O(n)")

    // Creation with different constructors
    val list1 = arrayListOf("A", "B", "C")                    // With initial elements
    val list2 = ArrayList<String>()                           // Empty
    val list3 = ArrayList<String>(20)                         // With initial capacity
    val list4 = ArrayList(listOf("X", "Y", "Z"))             // From collection

    println("\nCreated ArrayList: $list1")

    // Capacity operations specific to ArrayList
    println("\nCapacity Operations:")
    list1.ensureCapacity(50)        // Ensure minimum capacity
    println("Ensured capacity of 50")

    // All operations from MutableList are available
    println("\nModification Operations:")
    list1.add(1, "INSERTED")        // Insert at index - O(n)
    println("After insert at index 1: $list1")

    list1.removeAt(2)               // Remove at index - O(n)
    println("After remove at index 2: $list1")

    // Conversion operations
    println("\nConversion Operations:")
    val array = list1.toTypedArray() // Convert to array
    println("To array: ${array.contentToString()}")

    val immutableList = list1.toList() // Convert to immutable list
    println("To immutable list: $immutableList")

    // Performance demonstration
    println("\nPerformance Characteristics:")
    val perfList = ArrayList<Int>()

    // Fast: Adding to end
    val startTime1 = System.nanoTime()
    repeat(10000) { perfList.add(it) }
    val endTime1 = System.nanoTime()
    println("Time to add 10000 elements at end: ${(endTime1 - startTime1) / 1_000_000}ms")

    // Slow: Adding to beginning
    val startTime2 = System.nanoTime()
    repeat(1000) { perfList.add(0, it) }
    val endTime2 = System.nanoTime()
    println("Time to add 1000 elements at beginning: ${(endTime2 - startTime2) / 1_000_000}ms")

    perfList.clear()
}

// LINKEDLIST - Java doubly-linked list implementation
fun demoLinkedList() {
    println("🔗 LINKEDLIST DEMO")
    println("Characteristics: Doubly-linked list, efficient insertions/deletions, poor random access")
    println("Time Complexity: Access O(n), Insert/Remove at ends O(1), Insert/Remove middle O(1) with iterator")

    // Creation methods
    val list = LinkedList<String>()
    val listWithData = LinkedList(listOf("A", "B", "C"))

    println("\nInitial LinkedList: $listWithData")

    // LinkedList specific operations (Deque interface)
    println("\nDeque Operations (both ends):")

    // Add operations
    listWithData.addFirst("FIRST")      // Add to beginning - O(1)
    println("After addFirst: $listWithData")

    listWithData.addLast("LAST")        // Add to end - O(1)
    println("After addLast: $listWithData")

    listWithData.offerFirst("OFFER_FIRST") // Same as addFirst - O(1)
    println("After offerFirst: $listWithData")

    listWithData.offerLast("OFFER_LAST")   // Same as addLast - O(1)
    println("After offerLast: $listWithData")

    // Peek operations (don't remove)
    println("\nPeek Operations (O(1)):")
    println("peekFirst: ${listWithData.peekFirst()}")
    println("peekLast: ${listWithData.peekLast()}")
    println("peek (same as peekFirst): ${listWithData.peek()}")

    // Get operations (same as peek but throw exception if empty)
    println("getFirst: ${listWithData.first}")
    println("getLast: ${listWithData.last}")

    // Remove operations
    println("\nRemove Operations (O(1)):")
    val removedFirst = listWithData.removeFirst()   // Remove from beginning
    println("removeFirst returned: $removedFirst, List: $listWithData")

    val removedLast = listWithData.removeLast()     // Remove from end
    println("removeLast returned: $removedLast, List: $listWithData")

    val polledFirst = listWithData.pollFirst()      // Same as removeFirst but returns null if empty
    println("pollFirst returned: $polledFirst, List: $listWithData")

    val polledLast = listWithData.pollLast()        // Same as removeLast but returns null if empty
    println("pollLast returned: $polledLast, List: $listWithData")

    val polled = listWithData.poll()                // Same as pollFirst
    println("poll returned: $polled, List: $listWithData")

    // Restore some data
    listWithData.addAll(listOf("X", "Y", "Z", "W"))
    println("Restored list: $listWithData")

    // Stack operations (LIFO)
    println("\nStack Operations (LIFO):")
    listWithData.push("PUSHED")         // Add to front (same as addFirst) - O(1)
    println("After push: $listWithData")

    val popped = listWithData.pop()     // Remove from front (same as removeFirst) - O(1)
    println("pop returned: $popped, List: $listWithData")

    // Queue operations (FIFO)
    println("\nQueue Operations (FIFO):")
    listWithData.offer("OFFERED")       // Add to end (same as addLast) - O(1)
    println("After offer: $listWithData")

    val polledFromQueue = listWithData.poll() // Remove from front - O(1)
    println("poll returned: $polledFromQueue, List: $listWithData")

    // Index-based operations (slower - O(n))
    println("\nIndex-based Operations (O(n)):")
    println("Element at index 1: ${listWithData[1]}")
    listWithData[1] = "UPDATED"
    println("After update at index 1: $listWithData")

    // Iterator operations (efficient for LinkedList)
    println("\nIterator Operations:")
    val iterator = listWithData.listIterator(1) // Start from index 1
    println("Using listIterator from index 1:")
    while (iterator.hasNext()) {
        val item = iterator.next()
        println("  Next: $item at index ${iterator.nextIndex() - 1}")
        if (item.contains("Y")) {
            iterator.set("Y_MODIFIED")  // Modify current element
            println("    Modified to Y_MODIFIED")
        }
    }
    println("Final list: $listWithData")

    // Performance comparison
    println("\nPerformance Characteristics:")
    val perfList = LinkedList<Int>()

    // Fast: Adding to beginning
    val startTime1 = System.nanoTime()
    repeat(10000) { perfList.addFirst(it) }
    val endTime1 = System.nanoTime()
    println("Time to add 10000 elements at beginning: ${(endTime1 - startTime1) / 1_000_000}ms")

    // Slow: Random access
    val startTime2 = System.nanoTime()
    repeat(1000) { perfList[perfList.size / 2] }
    val endTime2 = System.nanoTime()
    println("Time for 1000 random accesses: ${(endTime2 - startTime2) / 1_000_000}ms")
}

// ARRAYDEQUE - Java circular array-based double-ended queue
fun demoArrayDeque() {
    println("🔄 ARRAYDEQUE DEMO")
    println("Characteristics: Circular array-based deque, efficient at both ends, no capacity restrictions")
    println("Time Complexity: Insert/Remove at ends O(1), Access by index O(n)")

    // Creation methods
    val deque = ArrayDeque<String>()
    val dequeWithData = ArrayDeque(listOf("A", "B", "C"))
    val dequeWithCapacity = ArrayDeque<String>(16) // Initial capacity

    println("\nInitial ArrayDeque: $dequeWithData")

    // Deque operations (both ends)
    println("\nDeque Operations:")

    // Add operations - O(1)
    dequeWithData.addFirst("FIRST")
    println("After addFirst: $dequeWithData")

    dequeWithData.addLast("LAST")
    println("After addLast: $dequeWithData")

    dequeWithData.offerFirst("OFFER_FIRST")
    println("After offerFirst: $dequeWithData")

    dequeWithData.offerLast("OFFER_LAST")
    println("After offerLast: $dequeWithData")

    // Examine operations (don't remove) - O(1)
    println("\nExamine Operations:")
    println("peekFirst: ${dequeWithData.peekFirst()}")
    println("peekLast: ${dequeWithData.peekLast()}")
    println("peek: ${dequeWithData.peek()}")      // Same as peekFirst
    println("element: ${dequeWithData.element()}")  // Same as getFirst, throws exception if empty

    // Remove operations - O(1)
    println("\nRemove Operations:")
    val removedFirst = dequeWithData.removeFirst()
    println("removeFirst: $removedFirst, Deque: $dequeWithData")

    val removedLast = dequeWithData.removeLast()
    println("removeLast: $removedLast, Deque: $dequeWithData")

    val polledFirst = dequeWithData.pollFirst()   // Returns null if empty
    println("pollFirst: $polledFirst, Deque: $dequeWithData")

    val polledLast = dequeWithData.pollLast()     // Returns null if empty
    println("pollLast: $polledLast, Deque: $dequeWithData")

    // Stack operations (LIFO) - O(1)
    println("\nStack Operations:")
    dequeWithData.push("STACK1")     // Same as addFirst
    dequeWithData.push("STACK2")
    println("After push operations: $dequeWithData")

    val popped1 = dequeWithData.pop()  // Same as removeFirst
    val popped2 = dequeWithData.pop()
    println("Popped: $popped1, $popped2, Deque: $dequeWithData")

    // Queue operations (FIFO) - O(1)
    println("\nQueue Operations:")
    dequeWithData.offer("QUEUE1")    // Same as addLast
    dequeWithData.offer("QUEUE2")
    println("After offer operations: $dequeWithData")

    val polled1 = dequeWithData.poll()  // Same as removeFirst
    val polled2 = dequeWithData.poll()
    println("Polled: $polled1, $polled2, Deque: $dequeWithData")

    // Restore data for other operations
    dequeWithData.addAll(listOf("X", "Y", "Z", "W", "V"))
    println("Restored deque: $dequeWithData")

    // Collection operations
    println("\nCollection Operations:")
    println("Size: ${dequeWithData.size}")
    println("isEmpty: ${dequeWithData.isEmpty()}")
    println("contains('Y'): ${dequeWithData.contains("Y")}")

    // Remove by value - O(n)
    dequeWithData.remove("Y")
    println("After remove('Y'): $dequeWithData")

    // Iteration
    println("\nIteration:")
    print("Forward iteration: ")
    for (item in dequeWithData) {
        print("$item ")
    }
    println()

    print("Reverse iteration: ")
    val descendingIterator = dequeWithData.descendingIterator()
    while (descendingIterator.hasNext()) {
        print("${descendingIterator.next()} ")
    }
    println()

    // Conversion
    println("\nConversion Operations:")
    val array = dequeWithData.toTypedArray()
    println("To array: ${array.contentToString()}")

    val list = dequeWithData.toList()
    println("To list: $list")

    // Performance characteristics
    println("\nPerformance Demo:")
    val perfDeque = ArrayDeque<Int>()

    // Efficient: Operations at both ends
    val startTime = System.nanoTime()
    repeat(10000) {
        perfDeque.addFirst(it)
        perfDeque.addLast(it)
    }
    repeat(5000) {
        perfDeque.removeFirst()
        perfDeque.removeLast()
    }
    val endTime = System.nanoTime()
    println("Time for 20000 additions and 10000 removals at ends: ${(endTime - startTime) / 1_000_000}ms")
}

// PRIORITYQUEUE - Java binary heap-based priority queue
fun demoPriorityQueue() {
    println("🏆 PRIORITYQUEUE DEMO")
    println("Characteristics: Binary heap, maintains elements in priority order, not thread-safe")
    println("Time Complexity: Insert O(log n), Remove min O(log n), Peek O(1)")

    // Creation methods
    val pq1 = PriorityQueue<Int>()                           // Natural ordering (min-heap)
    val pq2 = PriorityQueue<Int>(10)                         // With initial capacity
    val pq3 = PriorityQueue<Int>(compareByDescending { it }) // Max-heap using comparator
    val pq4 = PriorityQueue(listOf(5, 2, 8, 1, 9))         // From collection

    println("\nMin-heap PriorityQueue: $pq4")

    // Basic operations
    println("\nBasic Operations:")

    // Add elements - O(log n)
    pq1.add(10)
    pq1.add(5)
    pq1.add(20)
    pq1.add(1)
    pq1.add(15)
    pq1.offer(3)  // Same as add
    println("After adding elements: $pq1")

    // Peek (examine without removing) - O(1)
    println("peek (min element): ${pq1.peek()}")
    println("element (same as peek): ${pq1.element()}")

    // Remove operations - O(log n)
    val polled = pq1.poll()  // Remove and return min element
    println("poll (remove min): $polled, Queue: $pq1")

    val removed = pq1.remove() // Same as poll but throws exception if empty
    println("remove: $removed, Queue: $pq1")

    // Collection operations
    println("\nCollection Operations:")
    println("Size: ${pq1.size}")
    println("isEmpty: ${pq1.isEmpty()}")
    println("contains(15): ${pq1.contains(15)}")

    // Remove specific element - O(n)
    pq1.remove(15)
    println("After remove(15): $pq1")

    // Demonstrate with custom objects
    println("\nCustom Objects with Priority:")

    data class Task(val name: String, val priority: Int)

    // Create priority queue with custom comparator (higher priority number = higher priority)
    val taskQueue = PriorityQueue<Task>(compareByDescending { it.priority })

    taskQueue.addAll(listOf(
        Task("Low priority task", 1),
        Task("High priority task", 10),
        Task("Medium priority task", 5),
        Task("Critical task", 15),
        Task("Normal task", 3)
    ))

    println("Tasks in priority order:")
    while (taskQueue.isNotEmpty()) {
        val task = taskQueue.poll()
        println("  ${task.name} (priority: ${task.priority})")
    }

    // String priority queue with custom comparator
    println("\nString Priority Queue (by length):")
    val stringPQ = PriorityQueue<String>(compareBy { it.length })
    stringPQ.addAll(listOf("a", "hello", "hi", "world", "longest string"))

    println("Strings by length:")
    while (stringPQ.isNotEmpty()) {
        println("  '${stringPQ.poll()}'")
    }

    // Bulk operations
    println("\nBulk Operations:")
    val bulkPQ = PriorityQueue<Int>()
    bulkPQ.addAll(listOf(50, 30, 70, 20, 60, 40))
    println("After addAll: $bulkPQ")

    val toRemove = listOf(30, 60)
    bulkPQ.removeAll(toRemove)
    println("After removeAll($toRemove): $bulkPQ")

    val toRetain = listOf(20, 40, 100)  // 100 is not in queue
    bulkPQ.retainAll(toRetain)
    println("After retainAll($toRetain): $bulkPQ")

    // Iteration (unordered!)
    println("\nIteration (WARNING: Not in priority order!):")
    bulkPQ.addAll(listOf(10, 30, 25))
    print("Iterator order: ")
    for (item in bulkPQ) {
        print("$item ")
    }
    println()

    print("Correct priority order: ")
    val copy = PriorityQueue(bulkPQ)
    while (copy.isNotEmpty()) {
        print("${copy.poll()} ")
    }
    println()

    // Conversion operations
    println("\nConversion Operations:")
    val array = bulkPQ.toTypedArray()
    println("To array (unordered): ${array.contentToString()}")

    val sortedList = bulkPQ.sorted()
    println("To sorted list: $sortedList")

    // Performance demonstration
    println("\nPerformance Characteristics:")
    val perfPQ = PriorityQueue<Int>()

    val startTime1 = System.nanoTime()
    repeat(10000) { perfPQ.add((0..100000).random()) }
    val endTime1 = System.nanoTime()
    println("Time to add 10000 random elements: ${(endTime1 - startTime1) / 1_000_000}ms")

    val startTime2 = System.nanoTime()
    repeat(5000) { perfPQ.poll() }
    val endTime2 = System.nanoTime()
    println("Time to remove 5000 min elements: ${(endTime2 - startTime2) / 1_000_000}ms")

    perfPQ.clear()
}

// COPYONWRITEARRAYLIST - Thread-safe list with copy-on-write semantics
fun demoCopyOnWriteArrayList() {
    println("🔒 COPYONWRITEARRAYLIST DEMO")
    println("Characteristics: Thread-safe, optimized for reads, expensive writes")
    println("Time Complexity: Reads O(1), Writes O(n) due to array copying")

    // Creation methods
    val cowList = CopyOnWriteArrayList<String>()
    val cowListWithData = CopyOnWriteArrayList(listOf("A", "B", "C"))
    val cowListFromArray = CopyOnWriteArrayList(arrayOf("X", "Y", "Z"))

    println("\nInitial CopyOnWriteArrayList: $cowListWithData")

    // Write operations (expensive - O(n))
    println("\nWrite Operations (Each copies entire array):")

    cowListWithData.add("D")        // Copies entire array
    println("After add('D'): $cowListWithData")

    cowListWithData.add(1, "INSERT") // Copies entire array
    println("After add(1, 'INSERT'): $cowListWithData")

    cowListWithData.addAll(listOf("E", "F"))
    println("After addAll: $cowListWithData")

    cowListWithData[0] = "MODIFIED"  // Copies entire array
    println("After set(0, 'MODIFIED'): $cowListWithData")

    cowListWithData.remove("B")      // Copies entire array
    println("After remove('B'): $cowListWithData")

    cowListWithData.removeAt(1)      // Copies entire array
    println("After removeAt(1): $cowListWithData")

    // Read operations (fast - O(1))
    println("\nRead Operations (Fast, no copying):")
    println("Size: ${cowListWithData.size}")
    println("get(0): ${cowListWithData[0]}")
    println("First element: ${cowListWithData.first()}")
    println("Last element: ${cowListWithData.last()}")
    println("isEmpty: ${cowListWithData.isEmpty()}")
    println("contains('E'): ${cowListWithData.contains("E")}")
    println("indexOf('F'): ${cowListWithData.indexOf("F")}")

    // Iteration (safe during concurrent modifications)
    println("\nIteration (Thread-safe, snapshot-based):")
    print("Elements: ")
    for (item in cowListWithData) {
        print("$item ")
    }
    println()

    // Iterator is snapshot-based - won't see concurrent modifications
    println("\nSnapshot Iterator Behavior:")
    val iterator = cowListWithData.iterator()
    cowListWithData.add("ADDED_DURING_ITERATION") // This won't appear in current iterator

    print("Iterator sees: ")
    while (iterator.hasNext()) {
        print("${iterator.next()} ")
    }
    println()
    println("Actual list now: $cowListWithData")

    // Bulk operations
    println("\nBulk Operations:")
    val otherList = listOf("E", "F", "G")
    cowListWithData.addAll(otherList)
    println("After addAll($otherList): $cowListWithData")

    cowListWithData.removeAll(listOf("E", "G"))
    println("After removeAll(['E', 'G']): $cowListWithData")

    cowListWithData.retainAll(listOf("MODIFIED", "C", "D", "F", "ADDED_DURING_ITERATION"))
    println("After retainAll: $cowListWithData")

    // Search operations
    println("\nSearch Operations:")
    cowListWithData.addAll(listOf("D", "F", "D")) // Add duplicates
    println("List with duplicates: $cowListWithData")
    println("indexOf('D'): ${cowListWithData.indexOf("D")}")
    println("lastIndexOf('D'): ${cowListWithData.lastIndexOf("D")}")
    println("containsAll(['C', 'D']): ${cowListWithData.containsAll(listOf("C", "D"))}")

    // Sublist operations
    println("\nSublist Operations:")
    println("subList(1, 4): ${cowListWithData.subList(1, 4)}")

    // Conversion operations
    println("\nConversion Operations:")
    val array = cowListWithData.toTypedArray()
    println("toTypedArray: ${array.contentToString()}")

    val regularList = cowListWithData.toList()
    println("toList: $regularList")

    val mutableCopy = cowListWithData.toMutableList()
    println("toMutableList: $mutableCopy")

    // Thread safety demonstration
    println("\nThread Safety Demonstration:")
    val threadSafeList = CopyOnWriteArrayList<Int>()

    // Simulate concurrent access
    val threads = List(5) { threadId ->
        Thread {
            repeat(100) { i ->
                threadSafeList.add(threadId * 1000 + i)
                if (threadSafeList.size > 50) {
                    threadSafeList.removeAt(0)
                }
            }
        }
    }

    threads.forEach { it.start() }
    threads.forEach { it.join() }

    println("After concurrent operations, size: ${threadSafeList.size}")
    println("Sample elements: ${threadSafeList.take(10)}")

    // Performance characteristics
    println("\nPerformance Characteristics:")
    val perfList = CopyOnWriteArrayList<Int>()

    // Fast reads
    perfList.addAll((1..1000).toList())
    val startTime1 = System.nanoTime()
    repeat(10000) { perfList[perfList.size / 2] }
    val endTime1 = System.nanoTime()
    println("Time for 10000 reads: ${(endTime1 - startTime1) / 1_000_000}ms")

    // Slow writes (each write copies entire array)
    val startTime2 = System.nanoTime()
    repeat(100) { perfList.add(it) }
    val endTime2 = System.nanoTime()
    println("Time for 100 writes: ${(endTime2 - startTime2) / 1_000_000}ms")

    // Clear operation
    cowListWithData.clear()
    println("After clear, isEmpty: ${cowListWithData.isEmpty()}")

    // Use cases
    println("\nBest Use Cases:")
    println("✓ Mostly read operations with occasional writes")
    println("✓ Thread-safe iteration without external synchronization")
    println("✓ Event listener lists")
    println("✓ Configuration data that rarely changes")
    println("✗ Frequent modifications")
    println("✗ Large lists with many writes")
    println("✗ Memory-constrained environments")
}

// COMPREHENSIVE COMPARISON AND BEST PRACTICES
fun printCollectionComparison() {
    println("\n" + "=".repeat(70))
    println("📋 COLLECTION COMPARISON & BEST PRACTICES")
    println("=".repeat(70))

    println("\n🎯 WHEN TO USE EACH COLLECTION:")

    println("\n📖 Immutable List (listOf):")
    println("  ✓ Read-only data that won't change")
    println("  ✓ Configuration, constants, lookup tables")
    println("  ✓ Thread-safe by nature")
    println("  ✓ Memory efficient (can be shared)")

    println("\n📝 Mutable List (mutableListOf):")
    println("  ✓ General-purpose list when you need modifications")
    println("  ✓ Random access and modifications")
    println("  ✓ When you don't know the specific use case")

    println("\n📊 ArrayList:")
    println("  ✓ Frequent random access by index")
    println("  ✓ More additions at the end than insertions in middle")
    println("  ✓ When you need to specify initial capacity")
    println("  ✗ Frequent insertions/deletions in middle")

    println("\n🔗 LinkedList:")
    println("  ✓ Frequent insertions/deletions at beginning or end")
    println("  ✓ When you iterate more than random access")
    println("  ✓ Stack or queue operations")
    println("  ✓ When you have an iterator and need to insert/remove")
    println("  ✗ Random access by index")
    println("  ✗ Memory overhead (each node stores pointers)")

    println("\n🔄 ArrayDeque:")
    println("  ✓ Need efficient operations at both ends")
    println("  ✓ Queue or deque operations")
    println("  ✓ Better than LinkedList for queue operations")
    println("  ✓ No capacity restrictions")
    println("  ✗ No random access")

    println("\n🏆 PriorityQueue:")
    println("  ✓ Need elements in priority order")
    println("  ✓ Always need the minimum/maximum element")
    println("  ✓ Task scheduling, event simulation")
    println("  ✓ Algorithm implementations (Dijkstra, A*)")
    println("  ✗ Need all elements in sorted order (use sorted list instead)")
    println("  ✗ Random access")

    println("\n🔒 CopyOnWriteArrayList:")
    println("  ✓ Many concurrent readers, few writers")
    println("  ✓ Event listener lists")
    println("  ✓ Configuration that rarely changes")
    println("  ✓ Thread-safe iteration")
    println("  ✗ Frequent modifications")
    println("  ✗ Memory-constrained environments")

    println("\n⚡ PERFORMANCE SUMMARY:")
    println("Operation           | ArrayList | LinkedList | ArrayDeque | PriorityQueue | CopyOnWriteArrayList")
    println("Access by index     | O(1)      | O(n)       | O(n)       | N/A           | O(1)")
    println("Insert at beginning | O(n)      | O(1)       | O(1)       | N/A           | O(n)")
    println("Insert at end       | O(1)*     | O(1)       | O(1)       | O(log n)      | O(n)")
    println("Remove at beginning | O(n)      | O(1)       | O(1)       | O(log n)      | O(n)")
    println("Remove at end       | O(1)      | O(1)       | O(1)       | N/A           | O(n)")
    println("Search              | O(n)      | O(n)       | O(n)       | N/A           | O(n)")
    println("Peek min/max        | N/A       | N/A        | N/A        | O(1)          | N/A")
    println("* Amortized time complexity")

    println("\n🧠 MEMORY CONSIDERATIONS:")
    println("• ArrayList: Continuous memory, may waste space due to capacity")
    println("• LinkedList: Each element has overhead for prev/next pointers")
    println("• ArrayDeque: Circular buffer, efficient memory usage")
    println("• PriorityQueue: Array-based heap, compact storage")
    println("• CopyOnWriteArrayList: Multiple array copies during writes")

    println("\n🔄 THREAD SAFETY:")
    println("• Immutable List: Thread-safe (immutable)")
    println("• MutableList/ArrayList: NOT thread-safe")
    println("• LinkedList: NOT thread-safe")
    println("• ArrayDeque: NOT thread-safe")
    println("• PriorityQueue: NOT thread-safe")
    println("• CopyOnWriteArrayList: Thread-safe")

    println("\n💡 QUICK DECISION GUIDE:")
    println("1. Need thread safety? → CopyOnWriteArrayList (rare writes) or Immutable List")
    println("2. Need priority ordering? → PriorityQueue")
    println("3. Need queue/stack operations? → ArrayDeque")
    println("4. Frequent insertions at beginning? → LinkedList")
    println("5. Need random access? → ArrayList or MutableList")
    println("6. Data won't change? → Immutable List")
    println("7. General purpose? → MutableList (usually becomes ArrayList)")
}