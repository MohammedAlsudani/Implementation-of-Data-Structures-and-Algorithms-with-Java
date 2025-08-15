package kotlin.stack

/**
 * Demonstrates how to implement and use a Stack in Kotlin.
 *
 * Stack:
 * - Follows LIFO (Last In, First Out) principle.
 * - Main operations:
 *      push(item) → add to top
 *      pop() → remove from top
 *      peek() → view top element
 *      isEmpty() → check if empty
 *
 * We can implement a stack using:
 * - MutableList
 * - ArrayDeque
 */
class StackExample<T> {

    private val items = mutableListOf<T>()

    // Push item onto the stack
    fun push(item: T) {
        items.add(item)
    }

    // Pop item from the stack
    fun pop(): T? {
        if (isEmpty()) return null
        return items.removeAt(items.size - 1)
    }

    // Peek at the top item without removing
    fun peek(): T? {
        return items.lastOrNull()
    }

    // Check if stack is empty
    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    // Get size of stack
    fun size(): Int {
        return items.size
    }

    // Print the stack (top at right)
    fun printStack() {
        println(items.joinToString(" -> "))
    }

    /**
     * Algorithm Example:
     * Check if parentheses in a string are balanced using a stack.
     */
    fun isBalancedParentheses(input: String): Boolean {
        val stack = StackExample<Char>()

        for (char in input) {
            when (char) {
                '(', '{', '[' -> stack.push(char)
                ')', '}', ']' -> {
                    val top = stack.pop() ?: return false
                    if (!matches(top, char)) return false
                }
            }
        }
        return stack.isEmpty()
    }

    private fun matches(open: Char, close: Char): Boolean {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']')
    }
}

/**
 * Main function to test the stack
 */
fun main() {
    val stack = StackExample<Int>()

    println("=== Stack Operations ===")
    stack.push(10)
    stack.push(20)
    stack.push(30)
    stack.printStack() // 10 -> 20 -> 30

    println("Popped: ${stack.pop()}") // 30
    println("Top item: ${stack.peek()}") // 20
    println("Popped: ${stack.pop()}") // 30
    println("Stack size: ${stack.size()}")

    println("\n=== Balanced Parentheses Check ===")
    val parenthesesChecker = StackExample<Char>()
    println("(){}[] -> ${parenthesesChecker.isBalancedParentheses("(){}[]")}") // true
    println("({[)]} -> ${parenthesesChecker.isBalancedParentheses("({[)]}")}") // false
}
